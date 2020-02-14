package model.daom.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.ImplementDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements ImplementDao{

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Department searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Department> searchByDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

}
