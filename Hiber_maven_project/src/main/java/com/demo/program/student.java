package com.demo.program;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class student {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starts.....");
//		
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		Session session = factory.openSession();
//		session.beginTransaction();	
//		Session session = factory.openSession();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		//Get employee with id=1
EmployeeClass emp = (EmployeeClass) session.load(EmployeeClass.class, new Integer(1));
				printData(emp,1);
		System.out.println(session);
		session.close();
		
		//waiting for sometime to change the data in backend
				Thread.sleep(10000);
				

				EmployeeClass emp1 = (EmployeeClass) session.load(EmployeeClass.class, new Integer(1));
				printData(emp1,2);
				
				//Create new session
				Session newSession = factory.openSession();
				EmployeeClass emp2 = (EmployeeClass) newSession.load(EmployeeClass.class, new Integer(1));
				printData(emp2,3);
				
				//START: evict example to remove specific object from hibernate first level cache
				//Get employee with id=2, first time hence query in logs
				EmployeeClass emp3 = (EmployeeClass) session.load(EmployeeClass.class, new Integer(2));
				printData(emp3,4);
				session.evict(emp);
				System.out.println("Session Contains Employee with id=1?"+session.contains(emp));

				//since object is removed from first level cache, you will see query in logs
				EmployeeClass emp4 = (EmployeeClass) session.load(EmployeeClass.class, new Integer(1));
				printData(emp4,5);
				
				//this object is still present, so you won't see query in logs
				EmployeeClass emp5 = (EmployeeClass) session.load(EmployeeClass.class, new Integer(2));
				printData(emp5,6);
				
				//END: evict example
				
				//START: clear example to remove everything from first level cache
				session.clear();
				EmployeeClass emp6 = (EmployeeClass) session.load(EmployeeClass.class, new Integer(1));
				printData(emp6,7);
				EmployeeClass emp7 = (EmployeeClass) session.load(EmployeeClass.class, new Integer(2));
				printData(emp7,8);
				
				System.out.println("Session Contains Employee with id=2?"+session.contains(emp7));
				
				tx.commit();
				factory.close();
			}
				
	

	private static void printData(EmployeeClass emp, int count) {
		System.out.println(count+":: Name="+emp.getName()+", surname="+emp.getSurname()+" salary :- "+emp.getSalary());
	}
}
