package com.pojo;

import java.util.Set;

public class Cart {


	private long id;
	private double total;

	private Set<Item> items;
	
	//getter setter
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}


	}
	


