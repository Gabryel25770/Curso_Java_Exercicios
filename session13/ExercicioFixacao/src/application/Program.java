package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nome_cliente = sc.nextLine();
		System.out.print("Email: ");
		String email_cliente = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYY): ");
		Date nascim_cliente = sdf.parse(sc.nextLine());
		
		Client c1 = new Client(nome_cliente, email_cliente, nascim_cliente);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String order_status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int quantity_items = sc.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(order_status), c1);
		
		for(int i = 1; i <= quantity_items; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String product_name = sc.nextLine();
			System.out.print("Product price: ");
			int product_price = sc.nextInt();
			System.out.print("Quantity: ");
			int quantity_products = sc.nextInt();
			
			Product product = new Product(product_name, product_price);
			
			OrderItem orderItem = new OrderItem(quantity_products, 0, product);
			orderItem.subTotal();
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}

}
