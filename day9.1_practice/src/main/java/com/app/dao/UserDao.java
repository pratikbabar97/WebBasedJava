package com.app.dao;

import com.app.entities.Users;

public interface UserDao {
	String registerUser(Users user);
	String registerUserWithGetCurrentSession(Users user);
	//add method to fetch user details from supplied user id
	Users getUserDtails(int userId);
}
	