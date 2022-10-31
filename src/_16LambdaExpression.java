import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

class Points{
	int x,y;
	Points(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class _16LambdaExpression {
	
	public static void main3(String[] args) {
		Points arr[] = { new Points(1,20), new Points(5,30), new Points(3,40) };
		Arrays.sort(arr,(p1,p2) -> p1.x-p2.x);
		
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i].x + " " + arr[i].y);
		}
	}
	
	public static void main(String[] args) {
		String a[] = {"GFG","IDE","Courses"};
		String b[] = {"gfg","ide","courses"};
		
		if(Arrays.equals(a, b)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	//Method references
	//Class-name::method-name ----> static methods
	//instance::method-name ----> non-static methods(sysout)
	public static void main2(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(10,20,7,30,40));
		list.forEach(_16LambdaExpression::printSquare);
	}
	
	public static void printSquare(Integer x) {
		System.out.println(x*x);
	}
	
	
	
	
	
	public static void main1(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(10,20,7,30,40));
		printCond(list, new MyPredicate());
		printCond(list, x -> x%2==0);
		
		list.forEach(x -> System.out.println(x));
		list.stream().filter(x->x%2==0).forEach(x->System.out.println(x));
	}
	
	static void printCond(Collection<Integer> c,Predicate<Integer> p) {
		for (Integer i : c) {
			if(p.test(i)) {
				System.out.println(i + " ");
			}
		}
	}
}
//Not a lambda expression
class MyPredicate implements Predicate<Integer>{
	@Override
	public boolean test(Integer i) {
		return (i%2==0);
	}
}
