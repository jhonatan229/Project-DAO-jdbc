package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SellerDao sellerDao = DaoFactory.createdSellerDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// TEST searchabyDepartment
		List<Seller> seller = sellerDao.searchByDepartment(new Department(1, "Computers"));

		seller.forEach(System.out::println);

		System.out.println("\n===========================\n");
		// TEST searchabyDepartment
		List<Seller> seller2 = sellerDao.findAll();

		seller2.forEach(System.out::println);

		// test insert seller
		Seller sel = new Seller(null, "maria", "jhonatan@outlook.com", sdf.parse("21/05/2000"), 2700.00,
				new Department(2, null));
		sellerDao.insert(sel);
		System.out.println("NEW SELLER, new id is: " + sel.getId());

	}

}
