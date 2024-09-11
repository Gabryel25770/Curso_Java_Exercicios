package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		Set<Integer> setC = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int nA = sc.nextInt();
		
		for(int i = 0; i < nA; i++) {
			int num = sc.nextInt();
			setA.add(num);
		}
		
		System.out.print("How many students for course B? ");
		int nB = sc.nextInt();
		
		for(int i = 0; i < nB; i++) {
			int num = sc.nextInt();
			setB.add(num);
		}
		
		System.out.print("How many students for course C? ");
		int nC = sc.nextInt();
		
		for(int i = 0; i < nC; i++) {
			int num = sc.nextInt();
			setC.add(num);
		}
		
		Set<Integer> setD = new TreeSet<>(setA);
		setD.addAll(setB);
		
		Set<Integer> setE = new TreeSet<>(setD);
		setE.addAll(setC);
		
		System.out.print("Total students: " + setE.size());
		
		sc.close();
	}

}
