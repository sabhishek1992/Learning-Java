import java.util.Arrays;
import java.util.List;

public class _15WaysToIterate {
	public static void main(String[] args) {
		
		List<Object> list = Arrays.asList(10,"20",4.2,30L,true);
		
		//iterate using for-each loop
		for (Object i : list) {
			System.out.print(i + " ");
		}
		
		//Consumer<? super T> action
		//Any DataType super to T or T itself can hold passed parameter.
		//Consumer Interface : 1 abstract method. It is functional interface.
		//Functional Interface received as parameter to a method.
		//Then that method can be passed with lambda expression 
		list.forEach(x -> System.out.print(x + " "));
	
		//lambda expression : does not return void.
		
		//stream : creates pipeline of functions.
		//Stream doesn't create new collection. 
		//But it creates abstraction over collection. No memory taken.
		//Performs functions in pipeline on this abstraction.
		//Terminal functions to end pipeline : count, findFirst, forEach.
		//Terminal function triggers execution.
		//For findFirst : evaluation is stopped when first item is found.
		//Pipeline evaluated in lazy way. 
		//Every item in collection goes to all intermediate filters and goes to terminal function.
		//BEST PERFORMANCE. NO EXTRACT WORK IS DONE. EFFICIENT.
		//streams can be parallelized : using parallelStream()
		list.stream()
//		.filter(x -> x > 10)
//		.filter(x -> x%2==0)
		.forEach(x -> System.out.print(x + " "));
		
	}
}
