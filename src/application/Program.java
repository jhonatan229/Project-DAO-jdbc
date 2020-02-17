package application;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

import model.dao.DaoFactory;
import model.daom.impl.DepartmentDaoJDBC;
import model.daom.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;
import model.util.Decisions;
import model.util.ReadText;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		File file = new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\options.txt");
		SellerDaoJDBC sellerDao = (SellerDaoJDBC) DaoFactory.createdSellerDao();
		DepartmentDaoJDBC departmentDao = (DepartmentDaoJDBC) DaoFactory.createdDepartmentDao();

		int control = 5;
		while (control == 5) {
			System.out.println(ReadText.readerAText(file));

			int awnser = sc.nextInt();

			System.out.println(Decisions.awnserForFirstLayer(awnser));

			if (awnser == 1) {
				int AwnserForQestion1 = sc.nextInt();
				Decisions.awnserForSecondLayer(AwnserForQestion1);
				sc.nextLine();
				if (AwnserForQestion1 == 1) {
					List<Department> depart = departmentDao.findAll();
					for (Department d : depart) {
						System.out.println(d.showList());
					}
					System.out.print("nome: ");
					String name = sc.nextLine();
					System.out.print("email: ");
					String email = sc.nextLine();
					System.out.print("data de nacimento: ");
					Date date = sdf.parse(sc.next());
					System.out.print("base salarial: ");
					Double baseSalary = sc.nextDouble();
					System.out.print("departamento: ");
					Integer departmentId = sc.nextInt();
					Seller sel = new Seller(null, name, email, date, baseSalary, new Department(departmentId, null));
					sellerDao.insert(sel);
					System.out.println("vendedor adicionado com o sucesso! ");
				} else if (AwnserForQestion1 == 2) {
					List<Department> depart = departmentDao.findAll();
					for (Department d : depart) {
						System.out.println(d.showList());
					}
					System.out.print("id");
					int id = sc.nextInt();
					System.out.print("Department");
					String nameDepartment = sc.next();
					Department dep = new Department(id, nameDepartment);
					departmentDao.insert(dep);

				} else {

					continue;
				}
			}
			if(awnser == 2) {
				int awnserForQuestion2 = sc.nextInt();
				Decisions.AwnserForThirdLayer(awnserForQuestion2);
				if (awnserForQuestion2 == 1) {
					System.out.print("id: ");
					int id = sc.nextInt();
					System.out.print("Agora diga as mudanças que serão feitas, começando por: \nNome: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("email: ");
					String email = sc.nextLine();
					System.out.print("data de nacimento: ");
					Date date = sdf.parse(sc.next());
					System.out.print("base salarial: ");
					Double baseSalary = sc.nextDouble();
					System.out.print("departamento: ");
					Integer departmentId = sc.nextInt();
					Seller sel = new Seller(id, name, email, date, baseSalary, new Department(departmentId, null));
					sellerDao.update(sel);
					System.out.println("mudança feita com sucesso!!");
				}
				else if (awnserForQuestion2 == 2) {
					int id = sc.nextInt();
					sellerDao.deleteById(id);
					System.out.println("vendedor apagado com sucesso!");
				}
				else {
					continue;
				}
			}

			if (awnser == 4) {
				List<Seller> seller2 = sellerDao.findAll();
				seller2.forEach(System.out::println);
			}

		}

		sc.close();
	}

}
