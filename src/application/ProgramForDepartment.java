package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.daom.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class ProgramForDepartment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		DepartmentDaoJDBC  departmentDao = (DepartmentDaoJDBC) DaoFactory.createdDepartmentDao();
		
		Department dep = new Department(10, "OFFICE");
		
		//test delete
		departmentDao.deleteById(dep.getId());
		System.out.println("delete succesful");
		sc.next();
		
		//test update
		departmentDao.update(new Department(2, "video Games"));
		System.out.println("update sucessful");
		
		//test isert!
		departmentDao.insert(dep);
		System.out.println("insert succesful" );
		
	    //test search
		System.out.println("what department do you want search? ");
	    int id = sc.nextInt();
	    
	    
	    System.out.println(departmentDao.searchById(id));
	    
	    
		sc.close();

	}

}
