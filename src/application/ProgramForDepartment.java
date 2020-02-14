package application;

import model.dao.DaoFactory;
import model.daom.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class ProgramForDepartment {

	public static void main(String[] args) {
		
		DepartmentDaoJDBC  departmentDao = (DepartmentDaoJDBC) DaoFactory.createdDepartmentDao();
		
		Department dep = new Department(10, "OFFICE");
		
		//test update
		departmentDao.update(new Department(2, "video Games"));
		System.out.println("update sucessful");
		
		//test isert!
		departmentDao.insert(dep);
		System.out.println("insert succesful" );
		
		

	}

}
