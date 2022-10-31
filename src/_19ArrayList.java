import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _19ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10,20,40,30,20,30,10));

		System.out.println(list);
		list.set(1, 40);
		System.out.println(list.get(2));
		System.out.println(list.indexOf(10));
		System.out.println(list.lastIndexOf(20));
		list.add(0, 50);//throws UnsupportedOperation when use array.
		System.out.println(list);
		list.sort((x,y) -> x-y);
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		List<Integer> newList = list.stream().filter(x -> x<20)
				.collect(Collectors.toList());
		
		System.out.println(newList);
		
		ArrayList<Integer> sumList = new ArrayList<>(1);
		System.out.println(sumList);
	}
}
