package com.demo.program;

public class EmployeeClass {
  private int id;
  private String Name;
  private String Surname;
  private int Salary;
 
  
  public EmployeeClass(int id, String name, String surname, int salary) {
	super();
	this.id = id;
	Name = name;
	Surname = surname;
	Salary = salary;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getSurname() {
	return Surname;
}
public void setSurname(String surname) {
	Surname = surname;
}
public int getSalary() {
	return Salary;
}
public void setSalary(int salary) {
	Salary = salary;
}

  
}
