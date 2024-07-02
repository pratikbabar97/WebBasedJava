package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDaoImpl;
import com.app.entities.Users;
import com.app.entities.UserRole;

public class getUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf=getFactory();Scanner sc= new Scanner(System.in)){
			System.out.println("enter the userid to get the details");
	
			
			
	 		UserDaoImpl userDao= new UserDaoImpl();
			System.out.println(userDao.getUserDtails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
