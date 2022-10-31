import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Student1{
	int roll;
	int marks;
	String name;
	
	public int getRoll() {
		return roll;
	}
	public int getMarks() {
		return marks;
	}
	public String getName() {
		return name;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student1(int roll, int marks, String name) {
		super();
		this.roll = roll;
		this.marks = marks;
		this.name = name;
	}
	public Student1() {
		super();
	}
	@Override
	public String toString() {
		return "Student1 [roll=" + roll + ", marks=" + marks + ", name=" + name + "]";
	}
	
}

public class _17Streams {
	
	public static void main1(String[] args) {
		//collect method : used to collect data somewhere
		Student1[] studArr = {
				new Student1(10, 90, "abhi"),
				new Student1(11, 90, "vikki"),
				new Student1(12, 40, "hari")};
		
		Map<Integer, String> map = Arrays.stream(studArr)
									.collect(Collectors.toMap(Student1::getRoll, Student1::getName));
		System.out.println(map);
		
		//groupingBy : marks, values as list of students
		Map<Integer, List<Student1>> m =
		Arrays.stream(studArr)
		.collect(Collectors.groupingBy(Student1::getMarks));
		
		System.out.println(m);
	}
	
	
	public static void main2(String[] args) {
		//find average marks of students
		Student1[] studArr = {
				new Student1(10, 90, "abhi"),
				new Student1(10, 60, "vikki"),
				new Student1(10, 40, "hari")};
		
		//mapToInt : converts Stream->IntStream, because we have to average
		//average method is not present in Stream.
		
		double avgMarks = 
		Arrays.stream(studArr)
		.mapToInt(x -> x.getMarks()) 
		.average().getAsDouble();
		
		System.out.println(avgMarks);
	}
	

	public static void main(String[] args) {
		
		//primitve
		int[] arr = {1,2,3,4,4};
		
		int sum = Arrays.stream(arr).sum();
		//max,min returns variable of OptionalInt classes.
		//Because if no value we can't assign null to max variable.
		int max = Arrays.stream(arr).max().getAsInt();
		
		int min = Arrays.stream(arr).reduce((x,y) -> Integer.min(x, y)).getAsInt();
		
		double avg = Arrays.stream(arr).average().getAsDouble();
		
		System.out.println(max+" "+min+" "+avg);
		
//		print(10,5);
		
		String arrStr[] = {"abc","cde","acd","aec","xyz"};
		printStrings(arrStr);
	}
	
	//print first n natural number with given digit d
	
	public static void print(int n,Integer d) {
		//way to create infinite stream
		//first param : seed
		//second param : unary operator
		Stream.iterate(1, x->x+1)
		.filter(x -> x.toString().contains(d.toString()))
		.limit(n)// terminal operation can be called only n times.
		.forEach(x -> System.out.print(x+" "));
	}
	
	//print strings that begin with 'a' and ends with 'c' in lexicographic order.
	//lexicographic order : means sorted in dictionary order.
	public static void printStrings(String[] arrStr) {
		Arrays.stream(arrStr)
		.filter(x -> (x.startsWith("a") && x.endsWith("c")))
		.sorted()
		.forEach(x -> System.out.print(x+" "));
	}
}
