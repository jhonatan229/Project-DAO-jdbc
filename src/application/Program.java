package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createdSellerDao();
		
		List<Seller> seller = sellerDao.searchByDepartment(new Department(1, "Computers"));
		
		seller.forEach(System.out::println);

		
	}

}
