import java.io.FileNotFoundException;

public class _7FinalKeyword {

	public static void main(String[] args) {
		final int x; // not initialized, allocated stack memory
		x=100;
		System.out.println(x);
		
		final Integer X; //// not initialized, allocated stack memory
		X=null;
		System.out.println(X);
		
		Person p1 = new Person();
		System.out.println(p1);
		
		Person p2 = new Person(200);
		System.out.println(p2);
		
		
		//reference variable
		final StringBuffer sb = new StringBuffer("Geeks");
		sb.append("forGeeks");
		System.out.println(sb);
		
	}
	
}

class Person{
	//x : instance variable, every instance will have individual copy
	//x : final variable, can't change value, 
	//if x is not initialized, compile-time error as it is final
	//default value=0 would have been assigned if it was not final
	private final int x;

	//	{x = 100;} // initializer-block
	
	//Better to initialize inside constructor
	
	//final and there for all instances of class
	//can be accessed w/o creating instances
	private static final int MAX ;
	
	static {MAX=100;}//static-initializer-block
	
	public int getX() {
		return x;
	}

	public Person(int x) {
		super();
		this.x = x;
	}

	public Person() {
		super();
		this.x = 100;
	}
	
	@Override
	public String toString() {
		return "Person [x=" + x + "]";
	}
}


