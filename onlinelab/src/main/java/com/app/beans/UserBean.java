package com.app.beans;

import com.app.dao.UserDaoImpl;

public class UserBean {
   // java bean properties:state nonstatic and nontransient data members
	//clnts conversational state(ck=lnt specifitc info)
	private String email;
	private String password;
	//DOA layer reference
	private UserDaoImpl userDao;
	 //validates user details
	private User validatedUserDetails;
	
	 
}
