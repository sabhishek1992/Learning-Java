class Point{
	int x;
	int y;
	Integer z;
}

public class _1PrimitiveAndNonPrimitives {

	public static void main(String[] args) {
		
		Point p1 = new Point();
		
		Point p2 = p1;
		
		System.out.println(p1.x);
		System.out.println(p2.y);
		System.out.println(p2.z);
		
		
		  int x; Integer y;
		  
//		  System.out.println(x); //compile-time error, initialize x
//		  System.out.println(y); //compile-time error, initialize y
		 
	}
}
