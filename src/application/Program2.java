package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.CreateDepartmentDao();
		
		System.out.println("--- TESTE 1: INSERINDO DADOS ---");
		Department dep = new Department(7, "Eletrodomesticos");
		departmentDao.insert(dep);
		
		
		sc.close();
	}
}
