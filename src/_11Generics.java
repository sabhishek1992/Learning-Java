import java.util.ArrayList;

public class _11Generics {
	public static void main1(String[] args) {
		Pair_wo_generics p = new Pair_wo_generics();
		p.x = 12;
		p.y = "GFG";
		String str = (String) p.x; // Will raise ClassCastException at run-time.
		
		Pair<Integer, String> pg = new Pair<>();
		pg.x=12;
		pg.y="GFG"; 
//		String strg = (String) pg.x; // compile-time error
		//With generics we have type safety
	}
	
	public static void main2(String[] args) {
		Integer arr[] = {10,20,30,40,10,30};
		System.out.println(count(arr,10));
	}
	
	//in generic methods we need to specify datatype param
	//before returntype. Because return type can itself be generic.
	public static <T> int count(T arr[], T x) {
		int res = 0;
		for (T e : arr) {
			if(e.equals(x)) {
				res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		//parent class can refer to any of child classes.
		Student s = new EnggStudent(); 
		
		ArrayList<Student> arr1 = new ArrayList<>();
		ArrayList<EnggStudent> arr2 = new ArrayList<>();
		
		//arr1 = arr2; //compile-time error
		
		//Solution : Wildcards(? - unknown type)
		
		//Only student and its decendent's can be assigned to arr3
		ArrayList<? extends Student> arr3 = new ArrayList<>();
		ArrayList<EnggStudent> arr4 = new ArrayList<>();
		arr3 = arr4;
		
		
		//Only student and its ancestor's can be assigned to arr5
		ArrayList<? super Student> arr5 = new ArrayList<>();
		ArrayList<Object> arr6 = new ArrayList<>();
		arr5 = arr6;
	}
}

class Student{
	
}

class EnggStudent extends Student{
	
}

class Pair_wo_generics{
	Object x,y;
}

class Pair<T,S>{
	T x;
	S y;
}