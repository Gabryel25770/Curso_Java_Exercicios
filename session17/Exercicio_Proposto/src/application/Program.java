package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type the path of the file: ");
		String sourcePath = sc.nextLine();
		File path = new File(sourcePath);
		
		String parentPath = path.getParent();
		boolean newFolder = new File(parentPath + "\\out").mkdir();
		String targetPath = parentPath + "\\out\\summary.csv";
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(sourcePath))){
			String line = br.readLine();
			while (line != null) {
				String[] row = line.split(",");
				Product p = new Product(row[0], Double.valueOf(row[1]), Integer.valueOf(row[2]));
				try(BufferedWriter bw = new  BufferedWriter(new FileWriter(targetPath, true))){
					bw.write(p.toString());
					bw.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sc != null) {
				sc.close();
			}
		}
	}

}
