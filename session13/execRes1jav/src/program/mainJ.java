package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.WorkLevel;
import entities.Worker;

public class mainJ {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String dep_name = sc.nextLine();
		
		System.out.println("Enter worker data:");
		
		System.out.print("Name: ");
		String work_name = sc.nextLine();
		System.out.print("Level: ");
		String work_level = sc.nextLine();
		System.out.print("Base salary: ");
		double work_baseSal = sc.nextDouble();
		Worker worker = new Worker(work_name, WorkLevel.valueOf(work_level), work_baseSal, new Department(dep_name));
		
		System.out.print("How many contracts to this worker? ");
		int num_con = sc.nextInt();
		
		for(int i = 1; i <= num_con; i++) {
			System.out.println("Enter contract #" + i + " data:");
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date con_date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double con_valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int con_duration = sc.nextInt();
			
			HourContract contract = new HourContract(con_date, con_valuePerHour, con_duration);
			
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String income_str = sc.next();
		System.out.println("Name:" + worker.getName());
		System.out.println("Department:" + worker.getDepartment().getName());
		int mm = Integer.parseInt(income_str.substring(0, 2));
		int yyyy = Integer.parseInt(income_str.substring(3));
		System.out.println("Income for " + income_str + ": " + String.format("%.2f", worker.income(yyyy, mm)));
		
		sc.close();
	}
}
