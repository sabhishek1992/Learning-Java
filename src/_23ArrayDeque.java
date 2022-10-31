import java.util.ArrayDeque;
import java.util.Deque;


class MyDeque{
	
	private Deque<Integer> deque;
	
	public MyDeque() {
		super();
		deque = new ArrayDeque<>();
	}

	//Implement DS supports following operation in O(1) time
	protected void insertMax(int i) throws Exception {
		if(deque.peekLast().intValue() >= i) {
			throw new Exception("i : "+i+" is not the maximum");
		}
		deque.offerLast(i);
	}

	protected  void insertMin(int i) throws Exception {
		if(!deque.isEmpty() && deque.peekFirst().intValue() <= i) {
			throw new Exception("i : "+i+" is not the minimum");
		}
		deque.offerFirst(i);
	}
	
	protected  Integer getMin() {
		return deque.peekFirst();
	}
	
	protected  Integer getMax() {
		return deque.peekLast();
	}
	
	protected  Integer extractMin() throws Exception {
		
		if(deque.isEmpty()) {
			throw new Exception("No element to extract");
		}
		
		return deque.pollFirst();
	}
	
	protected  Integer extractMax() throws Exception {
		if(deque.isEmpty()) {
			throw new Exception("No element to extract");
		}
		return deque.pollLast();
	}

	
}

public class _23ArrayDeque {

	public static void main1(String[] args) throws Exception {
		
		MyDeque dq = new MyDeque();
		
		
		// All operations are O(1)
		dq.insertMin(5);
		dq.insertMax(10);
		
		//After this value minimum then 5, maximum then 10 can only be inserted
		
		dq.insertMin(3);
		dq.insertMax(15);
		dq.insertMin(2);
		
		//After this value minimum then 2, maximum then 15 can only be inserted
		
		System.out.print(dq.getMin()+" ");
		System.out.print(dq.getMax()+" ");
		dq.insertMin(1);
		System.out.print(dq.getMin()+" ");
		dq.insertMax(20);
		System.out.print(dq.getMax()+" ");
	}
	
	//Maximum in all subarrays of size k
		//Naive Solution : O(n*n)
	public static void main2(String[] args) {
		int[] arr = {10,8,5,12,15,7,6};
		int k = 3;
		
		int[] auxArr = new int[arr.length-k+1];
		
		for(int i = 0 ; i < arr.length-k+1 ; i++) {
			int max = arr[i];
			for(int j = i+1; j < i+k ; j++) {// runs for k-1 times
				if(arr[j] > max) {
					max = arr[j];
				}
			}
			auxArr[i] = max;
		}
		
		for (int i : auxArr) {
			
			System.out.print(i+" ");
		}
	}
	
	//Maximum in all subarrays of size k
	//Efficient Solution : O(n)
	//Auxiliary deque space : O(n)
	public static void main(String[] args) {
		
//		int[] arr = {10,8,5,12,15,7,6};
		int[] arr = {20,40,30,10,35};
		int k = 3;
		
		//add indexes
		Deque<Integer> dq = new ArrayDeque<>();
		
		//initialize : add first element
		
		
		//insert max at first, min at last
		int j = 0;//approach k
		for (int i = 0 ; i < arr.length;i++) {
			if(dq.isEmpty()) {
				dq.offerFirst(i);
			}
			else if(arr[dq.peekFirst().intValue()] >= arr[i]){
				//i is less-eq then peek
				dq.offerLast(i);
			}else { // i is grt than peek
				while(!dq.isEmpty()) {
					dq.pollFirst();
				}
				
				dq.offerFirst(i);
			}
			j++;
			if(j>=k) {//get peekfirst from dq
				System.out.print(arr[dq.peekFirst().intValue()]+" ");
				if(dq.peekFirst().intValue() <= i-k+1) {
					dq.pollFirst();
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
