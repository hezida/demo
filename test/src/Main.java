import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		//System.out.println("hello");
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object

		String userName = "junk";
		String datetime;
		LocalDateTime dt;
		DateTimeFormatter f = DateTimeFormatter.ISO_DATE_TIME;
		File newTextFile = new File("/tmp/tempfile.txt");
		FileWriter fw = new FileWriter(newTextFile);
		
		while (!userName.equals("")) {
			System.out.println("Enter username");
		    userName = scanner.nextLine();  
		    if (userName.equals("")) {
		    	break;
		    }
		    System.out.println("Enter date&time of birth");
		    datetime = scanner.nextLine();
		    //2011-12-03T10:15:30+01:00
		    
		    dt = LocalDateTime.parse(datetime, f);
	
            fw.write(userName + '\t');
            fw.write(dt.format(f) +'\n');
		}

        fw.close();
        scanner.close();
        
        ///read from the file
        BufferedReader br = new BufferedReader(new FileReader("/tmp/tempfile.txt"));
        String line = br.readLine();

        while (line != null) {
        	System.out.println(line);
            line = br.readLine();
            
        }
        
        br.close();
	}

}
