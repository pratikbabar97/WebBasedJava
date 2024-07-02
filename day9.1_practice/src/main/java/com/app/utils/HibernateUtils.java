package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration; 


public class HibernateUtils {
	//sessionFactory instance variable
      private static SessionFactory factory;
      //how to ensure creation of singleton instance of the session factory:-Eager singleton pattern ?
      
      static {
    	  System.out.println("in static initilizers block");
    	  //need configuration object with its configure method to map the cfg.xml file data in key and value pair inside the Configuration object and  then call the factory method
    	  
    	  //this is also called as BOOTSTRAPING of hibernate framework and building Session factory 
    	  factory= new Configuration().configure().buildSessionFactory();
      }
      
       
      //getter for SF(session factory)

	public static SessionFactory getFactory() {
		return factory;
	}
      

} 


