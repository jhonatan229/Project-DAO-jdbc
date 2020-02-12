package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {


		Department dep = new Department(2, "office");
		Seller seller = new Seller(2, "jhow", "jhow@hotmail.com",new Date(), 2200.00, dep);

		System.out.println(seller);
	}

}
