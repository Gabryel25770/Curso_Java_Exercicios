package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.LogUser;

public class Program {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			Set<LogUser> logList = new HashSet<>();
			String line = br.readLine();
			
			while(line != null) {
				String[] sep_line = line.split(" ");
				String name = sep_line[0];
				Date moment = Date.from(Instant.parse(sep_line[1]));
				
				logList.add(new LogUser(name, moment));
				
				line = br.readLine();
			}	
			
			System.out.println("Total users: " + logList.size());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}

}
