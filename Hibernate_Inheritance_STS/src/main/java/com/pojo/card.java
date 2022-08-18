package com.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="S_card")
public class card extends Payment{

	@Column(name="card_no")
	private int card_no;
	
	@Column(name="card_type")
	private String card_type;
	
	
	public int getCard_no() {
		return card_no;
	}
	public void setCard_no(int card_no) {
		this.card_no = card_no;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	
	
	
}
