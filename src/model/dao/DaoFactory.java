package model.dao;

import db.DB;
import model.daom.impl.DepartmentDaoJDBC;
import model.daom.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static ImplementDao createdSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static ImplementDao createdDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
	
}
