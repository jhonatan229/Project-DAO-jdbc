package model.entities;

import java.util.Date;

public class Seller {
	
	private Integer Id;
	private String name;
	private String email;
	private Date birthday;
	private double baseSalary;
	private Department department;
	
	public Seller(Integer id, String name, String email, Date birthday, double baseSalary, Department department) {
		Id = id;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	@Override
	public String toString() {
		return "Id = " + Id + ", name = " + name + ", email = " + email + ", birthday = " + birthday + ", baseSalary = "
				+ baseSalary;
	}
	
	

}
