 package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.domain.Contract;
import entities.domain.Installement;
import entities.service.ContractService;
import entities.service.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new	SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		sc.nextLine();
		Date data = sdf.parse(sc.nextLine());
		System.out.print("Valor do contrato: ");
		double valor = sc.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		int nParcelas = sc.nextInt();
		
		Contract contract = new Contract(numero, data, valor);
		ContractService service = new ContractService(new PaypalService());
		
		service.processContract(contract, nParcelas);
		
		System.out.println("Parcelas:");
		for(Installement i: contract.getList()) {
			System.out.println(i);
		}
		
		
		sc.close();
	}

}
