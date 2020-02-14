package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private String name;
	private String email;
	private Date birthday;
	private double baseSalary;
	private Department department;
	
	public Seller() {
	}
	
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
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Id number = " + Id + " \nName = " + name + " \nEmail = " + email + " \nBirthday = " + birthday + " \nBaseSalary = "
				+ baseSalary + " \nDepartment=" + department ;
	}

	
	

}
