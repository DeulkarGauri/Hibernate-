package com.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="S_cheque")
public class Cheque extends Payment{

	@Column(name="cheque_no")
	private int cheque_no;
	
	@Column(name="cheque_type")
	private String cheque_type;

	public int getCheque_no() {
		return cheque_no;
	}

	public void setCheque_no(int cheque_no) {
		this.cheque_no = cheque_no;
	}

	public String getCheque_type() {
		return cheque_type;
	}

	public void setCheque_type(String cheque_type) {
		this.cheque_type = cheque_type;
	}
	
	
}
