package com.prog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello Students.....!!!!");

		SessionFactory factory = new Configuration().configure("Hibernate.config.xml").buildSessionFactory();

		Student st1 = new Student(11, "Manawa", "Pune");
		Student st2 = new Student(12, "Pihu", "Mumbai");

		// opening an session to get object
		Session session1 = factory.openSession();
		System.out.println(session1.get(Student.class, 11));

		Transaction tx = session1.beginTransaction();
		// session1.save(st1);
		session1.save(st2);
		tx.commit();
		session1.close();

		// opening an second session to get second object
		Session session2 = factory.openSession();
		// System.out.println(session1.get(Student.class, 11));

		System.out.println(session2.get(Student.class, 12));

		session2.close();

	}
}
