import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class _21Queue {

	public static void main1(String[] args) {
		
		//Just changing functionality/class on right-hand side
		//Code will still be working fine
		//As we are using Queue Interface.
		//We stick to the functionality mentioned by Interface, 
		//irrespective of class implementation.
		
		
//		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		
		q.offer(10);//adds element without throwing exception
		//returns false if it can't add. IN CASE OF CAPACITY BOUNDED QUEUE
		//returns true if it can add
		//ADDS ELEMENT AT END OF QUEUE
		
		q.offer(20);
		q.offer(30);
		
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		System.out.println(q);
		
		System.out.println(q.peek());// first item of queue
		//this is the element which will go out next.
		//returns null is queue is empty.
		
		
		System.out.println(q.poll());//removes first time & returns value
		// returns null if this queue is empty.
		
		
	}
	
	
	//Reverse first k items of a queue
	//Elements are already inside queue
	
	//O(n) : time complexity
	private static void reverseFirstKElem(Queue<Integer> queue, int k) {
		
		int n = queue.size();
		
		//checks for invalid inputs
		//1. k > n
		//2. k <= 0
		if(k<=0 || k > n) {
			return; // DO NOTHING
		}
		
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		//1. poll first k elements from queue and push them to stack
		for (int i = 0 ; i < k ; i++) {
			stack.push(queue.poll());
		}
		
		//2. for remaining n-k, will use it later
		
		//3. pop all elements from stack, offer it to queue
		while(!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		
		//4. poll first n-k elements from queue and offer it to queue
		for (int i = 0 ; i < n-k ; i++) {
			queue.offer(queue.poll());
		}
		
	}
	
	
	public static void main2(String[] args) {
		int[] arr = {10,20,30,40,50};
		int k = 3;
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 0; i < arr.length; i++) {
			queue.offer(arr[i]);
		}
		
		System.out.println(queue);
		reverseFirstKElem(queue,k);
		System.out.println(queue);
		
		/*
		 * Deque<Integer> stack = new ArrayDeque<>();
		 * 
		 * 
		 * int j = k; for (Integer elem : arr) { if(j>0) { stack.push(elem); j--; }else
		 * { break; } }
		 * 
		 * System.out.println(stack);
		 * 
		 * while (!stack.isEmpty()) { queue.offer(stack.pop()); }
		 * System.out.println(queue);
		 * 
		 * for (int i = k; i < arr.length; i++) { queue.offer(arr[i]); }
		 */		
		
	}
	
	public static void main(String[] args) {
		nosWithGivenDigit(10);
		
		System.out.println(checkFor5And6(35));
		System.out.println(checkFor5And6(5));
		System.out.println(checkFor5And6(5556));
		
		levelOrderTraversal(8);
	}
	
	//O(n) time complexity solution
	//Auxiliary space : O(n)
	private static void levelOrderTraversal(int n) {
		
		List<String> list = new ArrayList<>();
		
		Queue<String> q = new ArrayDeque<>();
		q.add("5");
		q.add("6");
		
		for (int count = 0; count < n ; count++) {
			String curr = q.poll();
			list.add(curr);
			q.offer(curr+"5");
			q.offer(curr+"6");
		}
		
		System.out.println(list);
	}
		
	//Generate numbers with given digits 5,6
	
	//For n = 8, We are checking 560 nos approx
	//Very high time complexity
	private static void nosWithGivenDigit(int n) {
		
		List<Integer> list = new ArrayList<>();
		
		//1. traverse through natural nos 1,2,3,....
		
		int i = 1;
		int count = 0;
		while(count < n) {
			if(checkFor5And6(i)) {
				list.add(i);
				System.out.println("adding : "+i);
				count++;
			}
			i++;
		}
		
		
		//2. if a number contains only digit 5 & 6, add to list,
		//increment count variable
		
		//3. Stopping condition : count = n
		
		System.out.println(list);
	}


	private static boolean checkFor5And6(int i) {
		
		String numberAsStr = String.valueOf(i);
		char[] charArray = numberAsStr.toCharArray();
		
		for (char c : charArray) {
			if(c=='5' || c=='6') {
				//ok check for other characters
			}else {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
