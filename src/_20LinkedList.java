import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _20LinkedList {

	public static void main(String[] args) {
		
		System.out.println(josephusProblem(7, 3));
		
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(30);
		removeAndPrint(list,10);
		list.add(30);
		list.add(40);
		list.add(60);
		removeAndPrint(list,30);
	}
	
	//removeAndPrint
	public static void removeAndPrint(LinkedList<Integer> list, int x) {
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			if(i.equals(x)) {
				it.remove();
			}
		}
		System.out.println(list);
	}
	
	//Josephus Problem - circular linkedlist implementation
	public static int josephusProblem(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		Iterator<Integer> it = list.iterator();
		while(list.size() > 1) {
			int count = 0;
			while(count < k) {
				while(it.hasNext() && count < k) {
					it.next();
					count++;
				}
				if(count < k) {
					it = list.iterator();
					it.next();
					count++;
				}
			}
			it.remove();
		}
		return list.peekFirst();
	}
}
