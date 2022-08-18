package com.prog;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "Students")

/***
 * This is my pojo classs we enable an second level cache using annotation
 * 
 * @Entity 
 * @Cacheable
 *  @Cache(usage=CacheConcurrencyStrategy.READ_ONLY) it define 
 *  the concurrency strategy
 *  Read-only means caching will work for read only operation.
 *  
 * 
 ***/
public class Student {

	@Id
	@Column(name = "Roll_number")
	private int roll_num;
	@Column(name = "Student_name")
	private String name;
	@Column(name = "City")
	private String city;

	// no-arg constructor
	public Student() {

	}

	// parameterized constructor
	public Student(int roll_num, String name, String city) {
		super();
		this.roll_num = roll_num;
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [roll_num=" + roll_num + ", name=" + name + ", city=" + city + "]";
	}

	public int getRoll_num() {
		return roll_num;
	}

	public void setRoll_num(int roll_num) {
		this.roll_num = roll_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
