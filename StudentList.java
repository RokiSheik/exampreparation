import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static void main(String[] args) {

		/* Check argument count */
		//This section is for all Student
		if(args[0].equals("a")) {

			System.out.println("Loading data ...");			
			try{
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");			
				for(String j : i) { 
					System.out.println(j.trim()); 
				}
			} 
			catch (Exception e){

			} 
			System.out.println("Data Loaded.");
		}
		//This is for the Random Student Selection
		else if(args[0].equals("r")){
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				
				String i[] = r.split(",");	
				Random x = new Random();
				int y = (x.nextInt() & Integer.MAX_VALUE) % i.length;
				System.out.println(i[y].trim());
			} 
			catch (Exception e){

			} 
			System.out.println("Data Loaded.");			
		}
		//This is for the Add new Student
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter s = new BufferedWriter(new FileWriter("students.txt", true));
				String t = args[0].substring(1);
				s.write(", "+t);
				s.close();
			} 
			catch (Exception e){

			}
							
			System.out.println("Data Loaded.");	
		}
		//This is for the checked the student is in the file
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");	
				boolean done = false;
				String t = args[0].substring(1);
				
				for(int idx = 0; idx<i.length && !done; idx++) {
					if(i[idx].trim().equals(t)) {
						System.out.println("We found it!");
						done=true;
					}
				}
			} catch (Exception e){

			} 
			System.out.println("Data Loaded.");				
		}
		//This is for the count the word
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String D = s.readLine();
				char a[] = D.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char c:a) {
					if(c == ' '){
						if (!in_word) {
							count++; 
							in_word =true;	
						}
						else { 
							in_word=false;
						}			
					}
				}
				
				System.out.println(count +" word(s) found ");
			} 
			catch (Exception e){

			} 
			System.out.println("Data Loaded.");				
		}	
	}	
}