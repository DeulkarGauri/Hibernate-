package com.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Items {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="Item_ID")
	private String itemId;
	
	@Column(name="Item_Total")
	private double itemTotal;
	
	@Column(name="Item_QTY")
	private int quantity;
	
	@ManyToOne @JoinColumn(name="cart_id",nullable = false)
	private Cart cart;
	
	//hibernate requires no-args constructor
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
