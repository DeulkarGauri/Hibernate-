package com.demo.program;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class FetchData {

	public static void main(String[] args) {
		System.out.println("fetchng data....");
		
		
		SessionFactory factory =new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		EmployeeClass emp=(EmployeeClass)session.get(EmployeeClass.class, 101);
		System.out.println(emp.getId());
	}
}
