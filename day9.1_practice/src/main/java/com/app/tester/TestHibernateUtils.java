package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

public class TestHibernateUtils {

	public static void main(String[] args) {
		try (SessionFactory sf=getFactory()){
			
			System.out.println("hibernate is up and running"+sf);
		}catch(Exception e) {
			e.printStackTrace();
		}
 
	}

}
