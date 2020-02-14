package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Department;

public interface ImplementDao {

	void deleteById (Integer id);
	
	default Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("depName"));
		return dep;
	}
	default Department instantiateDepartmentForDep(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}
}
