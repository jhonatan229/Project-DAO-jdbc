package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Department;
import model.entities.Seller;

public interface ImplementDao {

	void insert (Seller obj);
	void update (Seller obj);
	void deleteById (Integer id);
	

	default Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}
}
