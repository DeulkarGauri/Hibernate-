package com.Prog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {
		System.out.println("Main Method Starts Here...");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("Shweta Thakare");
		
		Employee e4 = new Employee();
		e4.setName("manva patil");
		

		Regular_Employee e2 = new Regular_Employee();
		e2.setName("sakshi deulkar ");
		e2.setSalary(10000);
		e2.setBonus(1000);

		Contract_Employee e3 = new Contract_Employee();
		e3.setName("Shweta Bambal");
		e3.setPer_hour_day(1000);
		e3.setDuration("16 hours");

		session.persist(e1);
		session.persist(e4);
		session.persist(e2);
		session.persist(e3);

		tx.commit();
		session.close();
		System.out.println("\n Data Stored Sucessfully");

		System.out.println("Here Program Ends....");

	}
}
