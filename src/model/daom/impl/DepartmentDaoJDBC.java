package model.daom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ImplementDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements ImplementDao{

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	

	public void insert(Department obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO Department " + 
					"(Id, Name) " + 
					"VALUES " + 
					"(?, ?)",
					 + Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);

				}
				DB.closeResultSet(rs);
				
			}
			else {
				throw new DbException("unexpected error, no rows affected ");
			}
					
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

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
