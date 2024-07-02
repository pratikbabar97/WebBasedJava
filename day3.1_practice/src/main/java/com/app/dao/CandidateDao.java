package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.Candidates;

public interface CandidateDao {
	// method to get candidates list
	List<Candidates> getAllCandidates() throws SQLException;

     ///method to increment the votes of candidates
	String incrementCandidateVotes(int candidateId) throws SQLException;
}
