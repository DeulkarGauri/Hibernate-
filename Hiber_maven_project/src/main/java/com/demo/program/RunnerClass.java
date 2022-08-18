package com.demo.program;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class RunnerClass {
	// int id ;
	// private static SessionFactory factory = null;

	public static void main(String[] args) {
		System.out.println("this is my runner class");

		EmployeeClass e1 = new EmployeeClass(101, "Gauri", "Deulkar", 1000);
		EmployeeClass e2 = new EmployeeClass(102, "Sakshi", "Deulkar", 2000);
		EmployeeClass e3 = new EmployeeClass(103, "Samrudhi", "Deulkar", 3000);
		EmployeeClass e4 = new EmployeeClass(104, "Manasvi", "Deulkar", 4000);
		EmployeeClass e5 = new EmployeeClass(105, "jasmine", "rai", 10000);
		EmployeeClass e6 = new EmployeeClass(106, "ruchita ", "chaudhary", 20000);
		EmployeeClass e7 = new EmployeeClass(107, "aruhi", "thakare", 12000);
		EmployeeClass e8 = new EmployeeClass(108, "myra", "kale", 7000);
		EmployeeClass e9 = new EmployeeClass(109, "aastha", "gill", 4300);
		EmployeeClass e10 = new EmployeeClass(100, "mony", "roy", 40000);

		org.hibernate.Transaction tx = null;
		org.hibernate.Session session = null;
		org.hibernate.SessionFactory factory = null;
		// int e1_id = 0;
		try {
			factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
			// session = factory.getCurrentSession();
			session = factory.openSession();

			tx = session.beginTransaction();
			int id_e1 = (Integer) session.save(e1);
			int id_e2 = (Integer) session.save(e2);
			int id_e3 = (Integer) session.save(e3);
			int id_e4 = (Integer) session.save(e4);
			session.save(e5);
			session.save(e6);
			session.save(e7);
			session.save(e8);
			session.save(e9);
			session.save(e10);
			tx.commit();
			System.out.println("id is :- " + e1.getId());
			// Stream<EmployeeClass> str = session.createQuery("from EmployeeClass where
			// first_name like 's%'").stream();
			// str.forEach(a -> System.out.println("my id:-----" + a.getSalary()));

			Criteria cr = session.createCriteria(EmployeeClass.class);

//			cr.setFirstResult(3); // from this value it give the max result
//			cr.setMaxResults(2);// it give max result from which we set

			cr.setProjection(Projections.max("Salary"));// this give nax salary
			cr.setProjection(Projections.min("Salary"));   // this give minimum value
			cr.setProjection(Projections.sum("Salary"));  // this give sum of salary
			cr.setProjection(Projections.count("Salary"));  // it give the count of object which we create
			// cr.add(Restrictions.between("Salary", 1000, 5000));

			// cr.add(Restrictions.eq("Salary", 7000));
			// cr.addOrder(Order.desc("salary"));

			// cr.add(Restrictions.isEmpty("Salary"));;

			// cr.add(Restrictions.gt("EmployeeClass", 3000));
			// cr.add(Restrictions.ilike("Name", "s%"));

			// Criterion salary = Restrictions.gt("Salary", 5000);
			// Criterion name = Restrictions.ilike("Name", "_u%");
			//
			// LogicalExpression orExp= Restrictions.and(salary, name); // or expression
			// cr.add(orExp);

			// LogicalExpression anExpression = Restrictions.and(salary, name); // and
			// expression
			// cr.add(anExpression);
			List<EmployeeClass> Result = cr.list();

			System.out.println("\n    Name          Surname          Salary ");
			
			System.out.println(Result);
//			for (EmployeeClass result : Result) {
//				System.out.println(result.getName() + "    \t" + result.getSurname() + "    \t" + result.getSalary());
//
//			}

			// List<EmployeeClass> lt = cr.list();
			// System.out.println(" Name Surname Salary ");
			//
			// for (EmployeeClass result : lt) {
			//
			// System.out.println(result.getName()+" \t"+result.getSurname()+"
			// \t"+result.getSalary());
			// }

			// str.forEach(a->System.out.println("my id:-----"+a.getSurname()));
			// str.forEach(a->System.out.println("my id:-----"+a.getSalary()));
			// EmployeeClass e_new = session.get(EmployeeClass.class, e1_id);

			System.out.println("\n **This name can retrive from database  **");
			System.out.println("e1 name is ...........> " + e1.getName());
			System.out.println("e2 name is ...........> " + e2.getName());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		System.out.println("outside try block....");

	}
}
