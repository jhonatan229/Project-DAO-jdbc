package model.dao;

import model.daom.impl.DepartmentDaoJDBC;
import model.daom.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createdSellerDao() {
		return new SellerDaoJDBC();
	}
	
	public static DepartmentDao createdDepartmentDao() {
		return new DepartmentDaoJDBC();
	}

}
