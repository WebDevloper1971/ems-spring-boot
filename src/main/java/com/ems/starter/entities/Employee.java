package com.ems.starter.entities;

import jakarta.persistence.*;

@Entity
@Table(name="EMP_SYSTEM")
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	private String name;
	private String address;
	private String email;
	private String phno;
	private int salary;
	private String img;



	public Employee() {
		super();
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phno=" + phno
				+ ", salary=" + salary + "]";
	}

	@Transient
	public String getImagePath(){
		if(img.isEmpty() || img.isBlank()){
			return null;
		}
		return "/employee-images/" + img;
	}
}
