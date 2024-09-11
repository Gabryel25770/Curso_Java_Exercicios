package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			Map<String, Integer> candidates = new LinkedHashMap<>();
			String line = br.readLine();
			
			while(line != null) {
				String[] line_sep = line.split(",");
				String key = line_sep[0];
				Integer value = Integer.parseInt(line_sep[1]);
				
				if(candidates.containsKey(key)) {
					candidates.put(key, candidates.get(key) + value);
				}else {
					candidates.put(key, value);
				}
				
				line = br.readLine();
			}
			
			for(String key: candidates.keySet()) {
				System.out.println(key + ": " + candidates.get(key));
			}
			
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
