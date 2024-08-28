package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> funcionarios = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int numb = sc.nextInt();
		
		for(int i = 1; i <=numb; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual ou company (i/c)? ");
			char ch = sc.next().charAt(0);
			
			if(ch != 'c' && ch != 'i') {
				System.out.println("I can't understand!");
				break;
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anual_income = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Health expeditures: ");
				double health_expeditures = sc.nextDouble();
				funcionarios.add(new PessoaFisica(name, anual_income, health_expeditures));
			}else {
				System.out.print("Number of employees: ");
				int numb_of_employees = sc.nextInt();
				funcionarios.add(new PessoaJuridica(name, anual_income, numb_of_employees));
			}
		}
		
		
		if(funcionarios.size() == numb) {
			System.out.println();
			System.out.println("TAXES PAID:");
			
			double sum = 0;
			for(Pessoa p: funcionarios) {
				System.out.println(p.getNome() + ": $ " + String.format("%.2f", p.imposto()));
				sum += p.imposto();
			}
			
			System.out.println();
			System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		}
		
		
		sc.close();
	}

}
