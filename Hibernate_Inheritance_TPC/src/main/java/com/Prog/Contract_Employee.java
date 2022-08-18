package com.Prog;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_Contract_EMP")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id")),
		@AttributeOverride(name = "name", column = @Column(name = "name")) })


public class Contract_Employee extends Employee {
	@Column(name = "per_hour_day")
	private int per_hour_day;

	@Column(name = "duration")
	private String duration;

	public int getPer_hour_day() {
		return per_hour_day;
	}

	public void setPer_hour_day(int per_hour_day) {
		this.per_hour_day = per_hour_day;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
