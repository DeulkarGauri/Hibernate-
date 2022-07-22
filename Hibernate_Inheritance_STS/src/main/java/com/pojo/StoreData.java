package com.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {

		System.out.println("main method starts here....");

	SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Payment p = new Payment();
		p.setAmount(5100);

		card c = new card();
		c.setAmount(1000);
		c.setCard_no(33558882);
		c.setCard_type("VISA");

		Cheque chq = new Cheque();
		chq.setAmount(11100);
		chq.setCheque_no(010036);
		chq.setCheque_type("ORDER");

		session.persist(p);
		session.persist(c);
		session.persist(chq);
//		session.save(p);
//		session.save(c);
//		session.save(chq);
		tx.commit();
		session.close();
		factory.close();

		
		System.out.println("successfully added");
	}

}