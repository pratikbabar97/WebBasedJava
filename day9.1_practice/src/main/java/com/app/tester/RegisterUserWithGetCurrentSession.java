package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDaoImpl;
import com.app.entities.UserRole;
import com.app.entities.Users;

public class RegisterUserWithGetCurrentSession {

	public static void main(String[] args) {
		try (SessionFactory sf=getFactory();Scanner sc= new Scanner(System.in)){
			System.out.println("enter the user details : name,  email, password, confirmPassword, userRole,regAmount, regDate(yyyy-mm-dd)");
	
			
			Users user = new Users(sc.next(),sc.next(),sc.next(),sc.next(),UserRole.valueOf(sc.next       
					                 ().toUpperCase()),sc.nextDouble(),LocalDate.parse(sc.next()));
			//create dao instance n test API
	 		UserDaoImpl userDao= new UserDaoImpl();
			System.out.println(userDao.registerUserWithGetCurrentSession(user));
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}