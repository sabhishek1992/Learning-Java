import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4BufferredReader {

	public static void main(String[] args) throws IOException {
	
		//System.in : stream of i/p, gives stream of bytes
		
		//InputStreamReader : converts stream of bytes into
		// stream of characters.
		// char : 2 bytes, byte : 1 byte
		
		
		//BufferedReader : expects stream of characters 
		//to read data from 
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
				);
		
		System.out.println("Enter a string: ");
		String s = br.readLine();
		System.out.println("Entered string is : " + s);
	
		System.out.println("Enter a integer: ");
		int x = Integer.parseInt(br.readLine());
		System.out.println("Entered integer is : " + x);
		
		
		
		
		
		
		
		
		
	}
}
