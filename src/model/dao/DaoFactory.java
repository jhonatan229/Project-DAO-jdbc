package model.dao;

import db.DB;
import model.daom.impl.DepartmentDaoJDBC;
import model.daom.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createdSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createdDepartmentDao() {
		return new DepartmentDaoJDBC();
	}

}
