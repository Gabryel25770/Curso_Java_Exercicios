package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.InvalidAmountException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			double init_balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdraw_limit = sc.nextDouble();
			
			Account acc = new Account(number, holder, init_balance, withdraw_limit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);
			
			System.out.print("New balance: " + String.format("%.2f", acc.getBalance()));
		}catch(InvalidAmountException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		
		sc.close();
	}

}
