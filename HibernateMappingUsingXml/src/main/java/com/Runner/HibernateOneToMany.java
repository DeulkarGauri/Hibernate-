package com.Runner;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.cfg.Configuration;

import com.Pojo.Cart;
import com.Pojo.Items;

public class HibernateOneToMany {
	

	public static void main(String[] args) {
		System.out.println("This is Runner Class started....");
		
		System.out.println("program start here....");
		Cart c1 = new Cart();
		
		c1.setName("Sakshi");
		
		Cart c2 = new Cart();
		c1.setName("Shweta");
		
		Items item1 = new Items("sugar", 10, 1, c1);
		Items item2 = new Items("rice", 20, 2, c1);
		Items item3 = new Items("oil", 20, 2, c1);
		Items item4 = new Items("Tea", 20, 2, c1);
		
		
		Items item5 = new Items("choclate", 10, 1, c2);
		Items item6 = new Items("Biscuits", 20, 2, c2);
		Items item7 = new Items("maggie", 20, 2, c2);
		Items item8 = new Items("wafers", 20, 2, c2);
		
		Set<Items> itemSet = new HashSet<Items>();
		itemSet.add(item1);
		itemSet.add(item2);
		itemSet.add(item3);
		itemSet.add(item4);
		
		itemSet.add(item5);
		itemSet.add(item6);
		itemSet.add(item7);
		itemSet.add(item8);
		System.out.println("my set is ...."+item1.getId());
		System.out.println("my set is......"+item5.getId());
		c1.setItems(itemSet);
	    c1.setTotal(10*2  + 10*2);
	    
	    
	    
	    System.out.println("after total...");
	    org.hibernate.Transaction tx = null;
		org.hibernate.Session session = null;
		org.hibernate.SessionFactory Factory = null;
	
//	try {
//		System.out.println("Inside try block");
//		Factory = new Configuration().configure("Hibernate.config.xml").buildSessionFactory();
//		System.out.println("step 1");
//		session = Factory.openSession();
		try {
			Factory =new Configuration().configure("Hibernate.config.xml").buildSessionFactory();
			session = Factory.openSession();
			 tx = session.beginTransaction();
		
		 session.persist(c1);
		 session.save(item1);
		 session.save(item2);
		 session.save(item3);
		 session.save(item4);
		 session.save(c2);
		 session.save(item5);
		 session.save(item6);
		 session.save(item7);
		 session.save(item8);
		 tx.commit();
		 
		 System.out.println(" firsr cart id :----> "+c1.getId());
		 System.out.println("second cart id :-----> "+c2.getId());
		// System.out.println("item1 ID="+item1);
		 
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	finally{
		if ( session != null ) {
			
            session.close();
        }
      if ( Factory != null ) {
        	
            Factory.close();
        }
      
	}
System.out.println("end..........");
	
	}
}