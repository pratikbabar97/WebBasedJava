package com.app.dao;

import static com.app.utils.DBUtils.closeConnection;
import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Candidate;
import com.app.entities.User;

public class AdminDaoImpl implements AdminDao {

	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public AdminDaoImpl() throws SQLException {
		
		//get connection
		cn = openConnection();
		
		// Top two candidates having max votes.
		pst1 = cn.prepareStatement("select * from candidates order by votes desc limit 2");

		// Votes analysis (political party-wise)
		pst2 = cn.prepareStatement("select party, sum(votes) as votes_party_wise from candidates group by party");

		// delete voter details
		pst3 = cn.prepareStatement("delete from users where id = ?");

		// user details(not admin) born between dates
		pst4 = cn.prepareStatement("select * from users where role='voter' and dob between ? and ?");
	}

	public List<Candidate> top2() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		try (ResultSet rs1 = pst1.executeQuery()) {
			while (rs1.next()) {
				candidates.add(new Candidate(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getInt(4)));
			}
		}
		return candidates;
	}

	public List<String> voteAnalysis() throws SQLException {
		List<String> candidateGroup = new ArrayList<>();
		try (ResultSet rs2 = pst2.executeQuery()) {
			while (rs2.next()) {
				candidateGroup.add(rs2.getString(1) + "  " + rs2.getInt(2));
			}
		}
		return candidateGroup;
	}

	@Override
	public String deleteVoterDetails(int voterId) throws SQLException {
		pst3.setInt(1, voterId);
		int rows = pst3.executeUpdate();
		if (rows != 1)
			return "Deletion Unsuccessful!!! Non-existing Voter Id";
		return "Deletion Successful !!!";
	}
	
	@Override
	public List<User> getUserDetails(Date begin, Date end) throws SQLException {
		// 0. create empty list
		List<User> users = new ArrayList<>();

		// 1. set IN params
		pst4.setDate(1, begin);
		pst4.setDate(2, end);

		// 2 . exec -- exec query
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8)));
		}
		return users;// dao rets populated list of users to the caller
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
		}
		if (pst2 != null) {
			pst2.close();
		}
		if (pst3 != null) {
			pst3.close();
		}
		if (pst4 != null) {
			pst4.close();
		}
		closeConnection();
	}
}
