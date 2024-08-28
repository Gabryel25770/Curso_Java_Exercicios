package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> lista = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numb = sc.nextInt();
		
		for(int i = 1; i<= numb; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(ch == 'c') {
				lista.add(new Product(name, price));
			}else if(ch == 'u') {
				System.out.print("Manufacture Date: ");
				LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				lista.add(new UsedProduct(name, price, data));
			}else if(ch == 'i') {
				System.out.print("Customs Fee: ");
				Double fee = sc.nextDouble();
				lista.add(new ImportedProduct(name, price, fee));
			}else {
				System.out.println("Não compreendi");
				break;
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for(Product p: lista) {
			System.out.println(p.priceTag());
		}
		
		
		
		sc.close();
	}

}
