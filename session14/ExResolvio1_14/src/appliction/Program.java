package appliction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employee_list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int emp_numb = sc.nextInt();
		
		for(int i = 1; i <= emp_numb; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			String yesNo = sc.next();
			sc.nextLine();
			System.out.print("Name: ");
			String name_employee = sc.nextLine();
			System.out.print("Hours: ");
			int hours_employee = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			Employee employee;
			
			if(yesNo.equals("y")) {
				System.out.print("Additional charge: ");
				double additional_chrage = sc.nextDouble();
				employee = new OutsourcedEmployee(name_employee, hours_employee, valuePerHour, additional_chrage);
				employee_list.add(employee);
			}else {
				employee = new Employee(name_employee, hours_employee, valuePerHour);
				employee_list.add(employee);
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for(Employee e: employee_list) {
			System.out.println(e);
		}
		
		
		
		sc.close();
	}

}
