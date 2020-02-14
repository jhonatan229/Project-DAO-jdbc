package application;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.daom.impl.SellerDaoJDBC;
import model.entities.Seller;
import model.util.Decisions;
import model.util.ReadText;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		File file = new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\options.txt");
		SellerDaoJDBC sellerDao = (SellerDaoJDBC)DaoFactory.createdSellerDao();
		
		System.out.println(ReadText.readerAText(file));
		
		int awnser = sc.nextInt();
		
		System.out.println(Decisions.awnserForFirstQestion(awnser));
		
		if(awnser == 4) {
			List<Seller> seller2 = sellerDao.findAll();
			seller2.forEach(System.out::println);
		}
		
		
		
		
		sc.close();
	}

}
