package com.app.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.app.entities.User;

public interface UserDao {
	
	//method for user to sign in
User signIn(String email, String password ) throws SQLException;

//method to get user details born between thse dates
List<User> getUserDetails(Date begin,Date end) throws SQLException;

//methd for voter registration
String voterRegistrtion(User newVoter) throws SQLException;


//change password usring email verification
String changePassword(String email,String oldPWD,String newPwd) throws SQLException;

//delete voter details
String deleteVoterDetails(int voterId) throws SQLException;


//method to update voting status
 
String updateVotingStatus( int voterId) throws SQLException;


}