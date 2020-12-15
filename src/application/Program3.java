package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Products;
import entities.enums.OrderStatus;

public class Program3 {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String namec = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client client = new Client(namec, email, birthDate);
		
		System.out.println("Enter Order Date: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order( new Date(), status, client);
		
		System.out.print("How many itens to this order: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String namep = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			Products product = new Products(namep, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			
			order.addItem(orderItem);
	
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.print(order);
		
		sc.close();

	}

}
