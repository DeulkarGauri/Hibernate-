package HibernateProject.Hibernate.ex.usingAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyRunnerClass {

	public static void main(String[] args) {
		
		System.out.println("Runner class started here..... ");
		
//		Configuration cfg = new Configuration();*before
//		
//		cfg.configure("hibernate.cfg.xml");*before
//		
//		SessionFactory factory = cfg.buildSessionFactory();*before
		
		
		//creating an object of student class
		
		Student s1 = new Student(9, "Pranali", "Banglore");
		
		org.hibernate.Transaction tx = null;
		org.hibernate.Session session = null;
		org.hibernate.SessionFactory factory = null;
		
		//System.out.println(s1);*before
/*	before from video
 * 	Session session = factory.openSession();
Transaction  tx = session.beginTransaction();
		session.save(s1);
		tx.commit();
		*/
		try {
			factory =new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			 tx = session.beginTransaction();
			 session.save(s1);
			int id_s1 = (Integer) session.save(s1);
			System.out.println("session saved ");
			Student s_new = session.get(Student.class,id_s1);
			System.out.println("s1 name is ....."+s_new.getName());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		System.out.println("outside try block....");
		
//		System.out.println("my factory is .."+factory); *before
//		
//		System.out.println(factory.isClosed());*before
		System.out.println("Runner class ended here....... ");
	}
}
