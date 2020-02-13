package model.daom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
	
	    PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO seller " + 
					"(Name, Email, BirthDate, BaseSalary, DepartmentId) " + 
					"VALUES " + 
					"(?, ?, ?, ?, ?)",
					 + Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthday().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			
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

	@Override
	public void update(Seller obj) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Seller searchById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = Department.Id " + "WHERE seller.id = ?");

			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller sel = instantiateSeller(rs, dep);
				return sel;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Seller> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName " + 
        			"FROM seller INNER JOIN department " + 
        			"ON seller.DepartmentId = department.Id " 
                    + "ORDER BY Name");
			
			rs = ps.executeQuery();
			Map<Integer, Department> map = new HashMap<>();
			
			while(rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
				 dep = instantiateDepartment(rs);
				 map.put(rs.getInt("DepartmentId"), dep);
				}
				Seller sel = instantiateSeller(rs, dep);
				list.add(sel);
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
		return list;
	}
	
	@Override
	public List<Seller> searchByDepartment(Department department) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Seller> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName " + 
        			"FROM seller INNER JOIN department " + 
        			"ON seller.DepartmentId = department.Id " + 
        			"WHERE DepartmentId = ? " + 
        			"ORDER BY Name");
			
			ps.setObject(1, department.getId());
			rs = ps.executeQuery();
			Map<Integer, Department> map = new HashMap<>();
			
			while(rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
				 dep = instantiateDepartment(rs);
				 map.put(rs.getInt("DepartmentId"), dep);
				}
				Seller sel = instantiateSeller(rs, dep);
				list.add(sel);
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
		return list;
	}

	
	public Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}
	
	public Seller instantiateSeller (ResultSet rs, Department dep) throws SQLException {
		Seller sel = new Seller();
		sel.setId(rs.getInt("Id"));
		sel.setName(rs.getString("Name"));
		sel.setEmail(rs.getString("Email"));
		sel.setBirthday(rs.getDate("BirthDate"));
		sel.setBaseSalary(rs.getDouble("BaseSalary"));
		sel.setDepartment(dep);
		return sel;
	}


}
