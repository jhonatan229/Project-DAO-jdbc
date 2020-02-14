package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.daom.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SellerDaoJDBC sellerDao = (SellerDaoJDBC) DaoFactory.createdSellerDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// TEST searchabyDepartment
		List<Seller> seller = ((SellerDaoJDBC) sellerDao).searchByDepartment(new Department(1, "Computers"));

		seller.forEach(System.out::println);

		System.out.println("\n===========================\n");
		// TEST searchabyDepartment
		List<Seller> seller2 = sellerDao.findAll();

		seller2.forEach(System.out::println);

		System.out.println("\n===========================\n");
		// test insert seller
		Seller sel = new Seller(null, "maria", "jhonatan@outlook.com", sdf.parse("21/05/2000"), 2700.00,
				new Department(2, null));
		sellerDao.insert(sel);
		System.out.println("NEW SELLER, new id is: " + sel.getId());

		System.out.println("\n===========================\n");
		//test update
		Seller sel2 = new Seller(7, "claudio", "claudio@outlook.com", sdf.parse("21/10/2000"), 1800.00,
				new Department(1, null));
		sellerDao.update(sel2);
		System.out.println("update succesfull");
		
		System.out.println("\n===========================\n");
		//test delete
		sellerDao.deleteById(7);
		System.out.println("seller deleted");
	}

}
