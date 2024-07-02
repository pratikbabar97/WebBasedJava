 package com.app.dao;

import com.app.entities.Users;
import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.*;
public class UserDaoImpl implements UserDao {
	  //no datamembers,no cotr , n clean up
	String message="user registration failed !!";
	@Override
	public String registerUser(Users user) {
		
		// user:state-transient 
		//get the session  from SF
 		
		Session session=getFactory().openSession();
		Session session2=getFactory().openSession();
		System.out.println(session==session2);//false
		 //begin a transc
		Transaction tx=session.beginTransaction();//db conn is pooled out and wrapped in session obj created and L1 cache created
		
		System.out.println("session is open"+session.isOpen()+"is db connected"+session.isConnected());//true true
		
		
		try {
			//org.hibernate.Session APi :public Serializable save(Object transientObjRef) throws HibernateException 
			Serializable userId = session.save(user);//user ref is added into cache:PerSistent pojo
			message="user registrated succefully with id="+userId;
			tx.commit();// upon commit :Hibernate performs:"Auto dirty checking ": by comparing state pf L1 cache with that of database : and in the end DML query(insert) will be fired 
			
			System.out.println("session is open"+session.isOpen()+"is db connected"+session.isConnected());//true true
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			
		} finally {
			if(session!=null)
				session.close();//pooled out DB connc returns to the pool and L1 cache memo cleared
			System.out.println("session is open"+session.isOpen()+"is db connected"+session.isConnected());//false false
		}

		return message;
	}
	
	
	  //no datamembers,no cotr , n clean up
		String message2="user registration failed !!";
		@Override
		public String registerUserWithGetCurrentSession(Users user) {
			
			// user:state-transient 
			//get the session  from SF
	 		
			Session session=getFactory().getCurrentSession();
		   Session session2=getFactory().getCurrentSession();
			System.out.println(session==session2);//true
			 //begin a transc
			Transaction tx=session.beginTransaction();//db conn is pooled out and wrapped in session obj created and L1 cache created
			
			System.out.println("session is open"+session.isOpen()+"is db connected"+session.isConnected());//true true
			
			
			try {
				//org.hibernate.Session APi :public Serializable save(Object transientObjRef) throws HibernateException 
				Serializable userId = session.save(user);//user ref is added into cache:PerSistent pojo
				message2="user registrated succefully with id="+userId;
				tx.commit();// upon commit :Hibernate performs:"Auto dirty checking ": by comparing state pf L1 cache with that of database : and in the end DML query(insert) will be fired 
				//pooled out DB connc returns to the pool and L1 cache memo cleared
				
				System.out.println("session is open"+session.isOpen()+"is db connected"+session.isConnected());//false false
			}catch(RuntimeException e) {
				if(tx!=null)
					tx.rollback();
				throw e;
				
			} 
				System.out.println("session is open"+session.isOpen()+"is db connected"+session.isConnected());//false false
			

			return message2;
		}
		@Override
		public Users getUserDtails(int userId) {
			Users user=null;
			//get sssion from SF :getCurrentSession
			Session session=getFactory().getCurrentSession();
			
			
			//begin transc on session
			Transaction tx = session.beginTransaction();
			try {
				//get
				//returns persistent pojo object refernce it is taken from DB and placed in L1 cache
				user=session.get(Users.class, userId);
				
				tx.commit();
				
			} catch (RuntimeException e) {
				if(tx!=null)
					tx.rollback();
				throw e;
			}
		
			return user;
		}

}