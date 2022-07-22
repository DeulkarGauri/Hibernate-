package com.demo.program;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerClass {
//	int id ;
	//private static SessionFactory factory = null;
	
	public static void main(String[] args) {
	System.out.println("this is my runner class");
	

	EmployeeClass e1 = new EmployeeClass(101, "Gauri", "Deulkar", 1000);
	EmployeeClass e2 = new EmployeeClass(102, "Sakshi", "Deulkar", 2000);
	EmployeeClass e3 = new EmployeeClass(103, "Samrudhi", "Deulkar", 3000);
	EmployeeClass e4 = new EmployeeClass(104, "Manasvi", "Deulkar", 4000);
	
	org.hibernate.Transaction tx = null;
	org.hibernate.Session session = null;
	org.hibernate.SessionFactory factory = null;
	//int e1_id = 0;
	try {
		factory =new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		session = factory.openSession();
		 tx = session.beginTransaction();
		int id_e1 = (Integer) session.save(e1);
		int id_e2 = (Integer) session.save(e2);
		int id_e3 = (Integer) session.save(e3);
		int id_e4 = (Integer) session.save(e4);
		tx.commit();
		System.out.println("id is :- "+e1.getId());
// Stream<EmployeeClass> str = session.createQuery("from EmployeeClass").stream(); 
// str.forEach(a->System.out.println(a.getId()));
		//EmployeeClass e_new = session.get(EmployeeClass.class, e1_id);
		
		//System.out.println("e1 name is ...........> "+ e1.getName());
		//System.out.println("e2 name is ...........> "+ e2.getName());
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		session.close();
		factory.close();
	}
	System.out.println("outside try block....");
	
}
}
