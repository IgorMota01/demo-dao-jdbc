package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.CreateSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("--- TESTE II -- Busca por departamento");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("--- TESTE III: Busca completa ---");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("--- TESTE 4: Seller insert ---");
		Seller newSeller = new Seller(null, "Igor", "igor@email.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserido ! Nova ID: " + newSeller.getId());
		
		System.out.println("--- TESTE 5: Atualizando dados ---");
		seller = sellerDao.findById(1);
		seller.setName("Lorrany Victoria");
		sellerDao.update(seller);
		System.out.println("Update Completo");
		
		System.out.println("--- TESTE 6: Deletando linha ----");
		System.out.print("Enter a id for delete: ");
		int id = sc.nextInt();
		sellerDao.deletedById(id);
		System.out.println("Delete completed");
		
		
		sc.close();
	}
}
