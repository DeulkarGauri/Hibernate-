package com.Pojo;

public class Items {

	private long id;
	private String itemId;
	private double itemTotal;
	private int quantity;
	
	private Cart cart;
	
	//hibernate requries no-args constructor
	public Items() {
		}

	public Items(String itemId, double Total, int quantity, Cart cart) {
		super();
		this.itemId = itemId;
		this.itemTotal = Total;
		this.quantity = quantity;
		this.cart = cart;
	}

//	public Items(String itemId2, int total, int quantity2, Cart c1) {
//		// TODO Auto-generated constructor stub
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
}
