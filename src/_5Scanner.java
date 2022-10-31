import java.util.Scanner;

public class _5Scanner {

	//throws here unlike BufferedReader
	
	 static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 String s = sc.nextLine();
		 System.out.println("You entered string s : "+s);
		 
		 int z = sc.nextInt();
		 System.out.println("You entered integer z : "+z );
		 
		 float f = sc.nextFloat();
		 System.out.println("You entered float f : "+f);
	}
}
