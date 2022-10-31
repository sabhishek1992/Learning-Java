import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class _18ListIterator {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,20,30,40,50);
		ListIterator<Integer> it = list.listIterator();
		//allows the programmer to traverse the list in either direction, 
		//modify the list during iteration, 
		//and obtain the iterator's current position in the list.
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.print(it.nextIndex());//5 : no error
		System.out.println();
		ListIterator<Integer> itReverse = list.listIterator(list.size()-1);
		while(itReverse.hasPrevious()) {
			System.out.print(itReverse.previous() + " ");
		}
		System.out.println();
		ListIterator<Integer> it1 = list.listIterator(list.size()-1);
		while(it1.hasPrevious()) {
			int x = it1.previous();
			it1.set(x*2);//sets last item returned by next(), previous()
		}
		
		System.out.println(it1.previousIndex()); //-1 : no error
		
		System.out.println(list);
		
	}
}
