import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _24PriorityQueue {

	public static void main1(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		//default implementation - min-heap DS
		minHeap.add(10);
		minHeap.add(20);
		minHeap.add(15);
		
		System.out.print(minHeap.peek()+" ");//10
		System.out.print(minHeap.poll()+" ");//removes 10, calls heapify
		System.out.print(minHeap.peek()+" ");//15
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		maxHeap.add(10);
		maxHeap.add(20);
		maxHeap.add(15);
		
		System.out.print(maxHeap.peek()+" ");//20
		System.out.print(maxHeap.poll()+" ");//removes 20, calls heapify
		System.out.print(maxHeap.peek()+" ");//15
	}
	
	
	public static void main2(String[] args) {
		/*
		 * int[] cost = {1,12,5,111,200}; int sum = 10;
		 */
		Integer[] cost = {20,10,5,30,100};
		int sum = 35;
		System.out.println(purchaseMaxItems(cost, sum));
	}
	
	//purchasing max. no. of items from given sum
	
	//Time complexity : O(n+c*logn)
	//Auxiliary Space : O(n)
	private static Integer purchaseMaxItems(Integer cost[], int sum) {
		//We can create 1 collection from other using the constructor 
		
		//O(n)
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.asList(cost));
		
		/*
		 * for (Integer i : cost) { minHeap.add(i); }
		 */
		int remain_sum = sum; 
		int noOfItems = 0;
		//O(log n) : for poll()
		//noOfItems * log n
		while(!minHeap.isEmpty() && remain_sum >= minHeap.peek().intValue()) {
			//we can purchase more
			int costOfItem = minHeap.poll();
			remain_sum = remain_sum-costOfItem;
			
			System.out.println("Can purchase item with cost:" +costOfItem+", remaining sum : "+remain_sum);
			noOfItems++;
		}
		return noOfItems;
	}
	
	public static void main3(String[] args) {
		Integer[] arr= {5,15,10,20,8};
		int k = 3;
		printKLargestElem(arr, k);
	}
	
	//k largest elements
	//O(n) : build maxheap
	//k*O(logn) : extract k items
	//Overall time complexity : O(n) + k*O(logn)
	private static void printKLargestElem(Integer[] arr, int k) {
		
		PriorityQueue<Integer> maxHeap = 
				new PriorityQueue<Integer>(Collections.reverseOrder());
		maxHeap.addAll(Arrays.asList(arr));
		
		for(int i = 0; i < k; i++) {
			System.out.print(maxHeap.poll()+" ");
		}
		
	}
	
	public static void main4(String[] args) {
//		Integer[] arr= {5,15,10,20,8};
		Integer[] arr= {5,15,10,20,8,25,18};
		int k = 3;
		printKLargestElem_More_Eff(arr, k);
	}
	
	
	//O(k) : Build min-heap
	//for all other elem : (n-k)*2*logk
	
	//Overall Time complexity : O(k + (n-k)logk)
	
	//Here, we are assuming that, sorting order doesn't matter.
	//Because min-heap doesn't maintain sorted order.
	//We just need k largest elements
	
	private static void printKLargestElem_More_Eff(Integer[] arr, int k) {
		
		//build min-heap for first k elements
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			minHeap.offer(arr[i]);
		}
		
		//for elements from k+1, if peek < this.elem, 
		//replace it with this elem, call heapify
		for (int i = k; i < arr.length; i++) {
			if(minHeap.peek().intValue() < arr[i].intValue()) {
				minHeap.poll();//logk
				minHeap.offer(arr[i]); //logk
			}
		}
		

		//after the for-loop we get k elem in min-heap which are largest
		System.out.println(minHeap);
	}
	
	public static void main(String[] args) {
//		Integer arr[] = {10,5,20,5,10,10,30};
//		int k = 2;
		
		Integer arr[] = {20,40,30,20,30,40,60,60};
		int k = 3;
		kMostFrequentNos(arr, k);
	}
	
	//find k most frequenct no.s
	
	//Naive approach 
	//1. iterator over arr, store (elem,freq) in hashmap : O(n)
	//2. Create List from hashmap, sort it based on freq : O(nlogn)
	//3. Get top k most frequent elem. : O(k)
	//Overall time complexity : O(n+nlog+k)
	//Auxiliary space : O(n) : n distinct entries to hash map
	//Using HashMap & ArrayList
	private static void kMostFrequentNos(Integer arr[],int k) {
		Map<Integer,Integer> m = new HashMap<>();
		
		for (Integer num : arr) {
			m.put(num, m.getOrDefault(num,0)+1);
		}
		
		List<Map.Entry<Integer,Integer>> list 
		= new ArrayList<>(m.entrySet());
		
		System.out.println(list);
		
		Collections.sort(list,new MyComp());

		System.out.println(list);
		
		for (int i = 0; i < k; i++) {
			System.out.print(list.get(i).getKey()+" ");
		}
	}
	
	
	private static void kMostFreq_With_MinHeap(Integer[] arr, int k) {
		Map<Integer,Integer> m = new HashMap<>();
		
		for (Integer num : arr) {
			m.put(num, m.getOrDefault(num,0)+1);
		}
		
		//1. build minHeap using freq of first k pairs
		PriorityQueue<Map.Entry<Integer, Integer>> pq
		=new PriorityQueue<Map.Entry<Integer,Integer>>(new MyComp());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

class MyComp implements Comparator<Map.Entry<Integer, Integer>>{

	@Override
	public int compare(Entry<Integer, Integer> e1, 
			Entry<Integer, Integer> e2) {
		
		if(e1.getValue()==e2.getValue()) {
			return e1.getKey()-e2.getKey();//increasing order of keys
		}
		else {
			return e2.getValue()-e1.getValue();//decreasing order of values
		}
	}
}
