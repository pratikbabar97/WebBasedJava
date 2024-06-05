package com.app.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.app.entities.Candidate;
import com.app.entities.User;

public interface AdminDao {
	// add amethod to get Top two candidates having max votes.
	List<Candidate> top2() throws SQLException;

	// add a method to get Votes analysis (political party-wise)
	List<String> voteAnalysis() throws SQLException;

	// add a method for getting user details(not admin) born between dates
	List<User> getUserDetails(Date begin, Date end) throws SQLException;

	// add a method to delete voter details
	String deleteVoterDetails(int voterId) throws SQLException;

}
