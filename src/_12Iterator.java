import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class _12Iterator {

	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<>();
		c.add(10);c.add(15);c.add(20);
		
		
		removeByCond(c);
		
		//forEach is available in Iterable interface
		c.forEach(x -> System.out.println(x));
		
	}

	
	private static void removeEven(Collection<Integer> c) {
		 Iterator<Integer> iterator = c.iterator();
		 
		 while(iterator.hasNext()) {
			 int x = iterator.next();
			 if(x%2==0)
				 	iterator.remove();
		 }
	}
	//remove : removes items returned by next() call
	private static void removeByCond(Collection<?> c) {
		Iterator<?> it = c.iterator();
		while(it.hasNext()) {
			if(cond(it.next())==true) {
				it.remove();
			}
		}
	}

	private static boolean cond(Object next) {
		int x = Integer.parseInt(next.toString());
		if(x%2==0) return true;
		return false;
	}
}
