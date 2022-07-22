package com.runnar;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.Configuration;

import com.pojo.Cart;
import com.pojo.Item;

public class Hibernate_ManyTo_Many_Mapping {
	
public static void main(String[] args) {
		System.out.println("this is runner class...");
		System.out.println("program starts here...");
		
		Item iphone = new Item();//1 object 
		iphone.setPrice(100); 
		iphone.setDescription("iPhone");
		
		Item ipod = new Item();//2 object
		ipod.setPrice(50); 
		ipod.setDescription("iPod");
		
		Set<Item> items = new HashSet<Item>();
		items.add(iphone);
		items.add(ipod);
		
		Cart cart = new Cart(); // first
		cart.setItems(items);
		cart.setTotal(150);
		
		Cart cart1 = new Cart(); // second
		
		Set<Item> items1 = new HashSet<Item>();
		items1.add(iphone);
		cart1.setItems(items1);
		cart1.setTotal(100);
		System.out.println("After setting value..");
		
		 org.hibernate.Transaction tx = null;
			org.hibernate.Session session = null;
			org.hibernate.SessionFactory Factory = null;
			try {
				Factory =new Configuration().configure("Hibernate.config.xml").buildSessionFactory();
				session = Factory.openSession();
				 tx = session.beginTransaction();
		
				 session.save(cart);
					session.save(cart1);
					System.out.println("Before committing transaction");
					tx.commit();
					Factory.close();
					
					System.out.println("Cart ID="+cart.getId());
					System.out.println("Cart1 ID="+cart1.getId());
					System.out.println("Item1 ID="+iphone.getId());
					System.out.println("Item2 ID="+ipod.getId());
					
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						if(Factory != null && !Factory.isClosed()) 
							
							Factory.close();
					}
					
				
		

}
}