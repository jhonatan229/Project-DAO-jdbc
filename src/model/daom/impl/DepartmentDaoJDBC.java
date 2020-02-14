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

public class DepartmentDaoJDBC implements ImplementDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Department obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO Department " + "(Id, Name) " + "VALUES " + "(?, ?)",
					+Statement.RETURN_GENERATED_KEYS);

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

			} else {
				throw new DbException("unexpected error, no rows affected ");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	public void update(Department obj) {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("UPDATE department " + "SET Name = ? " + "WHERE Id = ?",
					+Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getId());

			int result = ps.executeUpdate();

			if (result < 0) {
				throw new DbException("non department was updated!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("DELETE FROM department " + "WHERE Id = ?", +Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	public Department searchById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT department.* FROM department WHERE Id = ?");

			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartmentForDep(rs);
				return dep;
			} else {
				return null;
			}
		}
		catch (SQLException e) {
			throw new db.DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}

	}

	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
