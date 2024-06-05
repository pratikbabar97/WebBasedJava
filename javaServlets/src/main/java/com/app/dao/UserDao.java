package com.app.dao;

import java.sql.SQLException;

import com.app.entities.User;

public interface UserDao {
//add a method for user's signin
	User signIn(String email, String password) throws SQLException;

	// add a method for voter reg.
	int voterRegistration(User newVoter) throws SQLException;

	// update password
	String changePassword(String email, String oldPwd, String newPwd) throws SQLException;

	// add a method to update voting status
	String updateVotingStatus(int voterId) throws SQLException;

}
