import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class _20Stack {

	//ArrayDeque : good for single threaded environment
	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<>();
		ArrayDeque<Integer> s = new ArrayDeque<Integer>();
		
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(null);//null pointer exception
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		
		System.out.println(s.size());
		System.out.println(s.isEmpty());
			
	}
	
	public static void main3(String[] args) {
		
		List<Integer> list = Arrays.asList(10,20,30,40,50,60);
//		reverse(list);
		reverseUsingStack(list);
		System.out.println(list);
	}
	
	//reverse using Stack class : O(n) time complexity
	//O(n) auxilary space of Stack is required
	//Useful when we don't have random access
	//Items are in LinkedList, TreeSet
	private static void reverseUsingStack(List<Integer> list) {
		Stack<Integer> s = new Stack<>();
		
		for (Integer x : list) {
			s.push(x); // O(1) operation
		}
		
		for (int i = 0; i < list.size(); i++) {
			list.set(i, s.pop()); // O(1) operation
		}
	}
	
	//reverse order of items : O(n) time complexity
	//O(1) auxiliary space as we are just swapping
	//We have random access in Arrays
	private static void reverse(List<Integer> list) {
		
//		Collections.reverse(list);
		int start = 0;
		int end = list.size()-1;
		
		//= : odd items , > : even items
		while(start<end) {
			int temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			start++;
			end--;
		}
	}
	
	public static void main2(String[] args) {
		String s = "())";
		checkForBalance(s.toCharArray());
		
		System.out.println(balancedParenthesis(s.toCharArray()));
		
	}
	
	//O(n) time complexity
	//auxiliary space : O(n) : ArrayDeque , if all closing brackets are there
	private static boolean balancedParenthesis(char[] charArray) {
		Deque<Character> stack = new ArrayDeque<>();
		
		int i = 0;
		for (;i<charArray.length ;i++) {
			Character character = charArray[i];
			
			if(character.equals('{') || character.equals('(')
					|| character.equals('[')) {
				stack.push(character);
			}else {
				if(stack.isEmpty()) {
					return false;
				}
				else if(! isMatching(stack.peek(),character)) {
					return false;
				}
				else {
					stack.pop();
				}
			}
		}
		return (stack.isEmpty()==true);
	}
	
	
	private static boolean isMatching(Character c, Character character) {
		if((c.equals('{') && character.equals('}')) ||
					(c.equals('(') && character.equals(')')) ||
					(c.equals('[') && character.equals(']'))) {
			return true;
		}
		return false;
	}

	//check for balanced parenthesis
	//last open bracket closes first
	//only 6 possible input characters
	//{}()[]
	private static void checkForBalance(char[] charArray) {
		Deque<Character> stack = new ArrayDeque<>();

		int i = 0;
		for (;i<charArray.length ;i++) {
			Character character = charArray[i];
			
			if(character.equals('{') || character.equals('(')
					|| character.equals('[')) {
				stack.push(character);
			}else {
				Character c = stack.pop();
				if((c.equals('{') && character.equals('}')) ||
					(c.equals('(') && character.equals(')')) ||
					(c.equals('[') && character.equals(']'))) {
					//OK condition
				}else {
					System.out.println("Do not match c :"+c + ", character :"+character);
					break; //brackets do not match
				}
			}
		}
		
		if(i>=charArray.length) {
			System.out.println("Balanced Parenthesis");
		}
		
		for (Character character : stack) {
			System.out.print(character + ", ");
		}
}
	
	public static void main4(String[] args) {
		int[] array = {60,10,20,40,35,30,50,70,65}; 
			//{18,12,13,14,11,16}; 
			//{13,15,12,14,16,8,6,4,10,30}; 
			//{30,20,25,28,27,29};
//		array_span(array);
		
//		span_approach_2(array);
		
		span_with_stack(array);
		System.out.println();
		span_with_stack_approach_2(array);
	}
	
	//Every element goes to stack exactly once, and comes out at-most once
	//2*n operation we are doing
	//O(n) time complexity
	//Auxiliary space : O(n) for stack. 
	//Auxiliary space : O(1) if element are sorted in increasing order.
	private static void span_with_stack_approach_2(int[] array) {
		Deque<Integer> stack = new ArrayDeque<>();
		
		int[] span = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			while(!stack.isEmpty() && array[stack.peek().intValue()] <= array[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				span[i] = i+1;
			}else {
				span[i] = i -  stack.peek().intValue();
			}
			stack.push(i);
		}
		
		for (int i : span) {
			System.out.print(i+" ");
		}
	}
	
	private static void span_with_stack(int[] array) {
		Deque<Integer[]> stack = new ArrayDeque<>();
		
		int[] span = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			if(stack.isEmpty()) {
				span[i] = i+1;
			}
			else if(stack.peek()[0].intValue() > array[i]) {
				//small element can sit on top of large in stack
				span[i] = 1;
			}
			else { //<=
				
				while(!stack.isEmpty() && stack.peek()[0].intValue() <= array[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					span[i] = i+1;
				}else {
					span[i] = i -  stack.peek()[1].intValue();
				}
			}
			stack.push(new Integer[] {array[i],i});
		}
		
		for (int i : span) {
			System.out.print(i+" ");
		}
		
	}
	

	//O(n*n) time complexity
	//Auxiliary space : O(1)
	private static void span_approach_2(int[] array){
		
		for(int i = 0 ; i < array.length ; i++) {
			
			int span = 1;
			
			for(int j = i-1 ; j > 0 && array[j] <= array[i] ; j--) {
				span++;
			}
			
			System.out.print(span+" ");
			
		}
	}
	
	
	//O(n*n) time complexity
	private static void array_span(int[] array) {

		int[] span = new int[array.length];
		
		for(int i = 0 ; i < array.length ; i++) {
			
			if(i == 0 ) {
				span[i]= 1;
			}
			else if(array[i-1] > array[i]){
				
				span[i] = 1;
			}else {
				int count = 1;
				int k = i;
				while(k>0 && array[k-1] <= array[i]) {
					count++;
					k--;
				}
				span[i] = count;
			}
		}
		
		for (int i : span) {
			System.out.print(i+" ");
		}
	}
	
	
	public static void main5(String[] args) {
		int[] array = {15,10,18,12,4,6,2,8};
		previousGreaterElem(array);
		System.out.println();
		previousGrtElem_approach_2(array);
		System.out.println();
		previousGrtElem_with_stack(array);
	}
	
	
	//O(n) : time complexity, atmost 2*n operation on stack. 
	//Time complexity is actual Theta(n). i.e. in avg case.
	//Auxiliary space : O(n)
	private static void previousGrtElem_with_stack(int[] array) {
		Deque<Integer> stack = new ArrayDeque<>();
		
		int[] preGrtElemArray = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			
			if(stack.isEmpty()) {
				preGrtElemArray[i] = -1;
			}
			else if(stack.peek().intValue() > array[i]){
				preGrtElemArray[i] = stack.peek().intValue();
				
			}else {
				while(!stack.isEmpty() && stack.peek().intValue() <= array[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					preGrtElemArray[i] = -1;
				}else {
					preGrtElemArray[i] = stack.peek().intValue();
				}
			}
			stack.push(array[i]);
		}
		for (int i : preGrtElemArray) {
			System.out.print(i + " ");
		}
	}
	
	
	
	
	//O(n*n) : time complexity
	//O(n) : if values are sorted in increasing order.
	//O(1) : auxiliary space
	private static void previousGrtElem_approach_2(int[] array) {
		
		int[] preGrtElemArray = new int[array.length];
		
		int defaultVal = -1;
		
		for (int i = 0; i < array.length; i++) {
			
			preGrtElemArray[i] = defaultVal;
			
			for (int j = i-1; j >= 0 ; j--) {
				if(array[j] > array[i]) {
					preGrtElemArray[i] = array[j];
					break;
				}
			}
		}
		
		for (int i : preGrtElemArray) {
			System.out.print(i + " ");
		}
	}
	
	private static void previousGreaterElem(int[] array) {
		
		int[] preGrtElemArray = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			
			if(i==0) {
				preGrtElemArray[i] = -1;
			}
			else if(array[i-1] > array[i]) {
				preGrtElemArray[i] = array[i-1];
				
			}else {
				int j = i-1;
				while(j>=0 && array[j] <= array[i]) {
					j--;
				}
				if(j<0) {
					preGrtElemArray[i] = -1;
					
				}else {
					preGrtElemArray[i] = array[j];
				}
			}
		}
		
		for (int i : preGrtElemArray) {
			System.out.print(i + " ");
		}
	}
	
	
	//this approach do not work
	//when we will pop(5), min is 6 and not 10
	public static void main6(String[] args) {
		Deque<Integer> mainStack = new ArrayDeque<Integer>();
		
		Integer min = null;
		
		min = pushWithMin(mainStack,6,min);
		min = pushWithMin(mainStack,10,min);
		System.out.print(min+" ");
		min = pushWithMin(mainStack,5,min);
		System.out.print(min+" ");
//		mainStack.popWithMin();
		System.out.print(min+" ");
		mainStack.pop();
		System.out.print(min+" ");
		
		
	}

	//this approach do not work
	private static Integer pushWithMin(Deque<Integer> mainStack,Integer val,Integer min) {
		mainStack.push(val); 
		if(mainStack.isEmpty()) {
			return val;
		}
		else if(val < min){
			return val;
		}
		return min;
	}
	
	private static void push(Deque<Integer> m_Stack, Deque<Integer> a_Stack, Integer i){
		
		m_Stack.push(i);
		
		if(a_Stack.isEmpty() || a_Stack.peek().intValue() >= i) {
			a_Stack.push(i);
		}
	}
	
	private static void pop(Deque<Integer> m_Stack, Deque<Integer> a_Stack){
		
		if( a_Stack.peek().intValue() == m_Stack.peek().intValue()) {
			a_Stack.pop();
		}
		m_Stack.pop();
	}
	
	private static Deque<Integer> m_Stack = new ArrayDeque<Integer>();
	
	private static Deque<Integer> a_Stack = new ArrayDeque<Integer>();
	
	
	//Auxiliary space : O(n)
	//getMin() : O(1) time complexity
	//push() : O(1) time complexity
	//pop() : O(1) time complexity
	public static void main1(String[] args) {
		
		push(m_Stack,a_Stack,20);
		
		push(m_Stack,a_Stack,6);
		
		push(m_Stack,a_Stack,10);
		
		System.out.println("min : "+a_Stack.peek());//6
		
		push(m_Stack,a_Stack,5);
		
		System.out.println("min : "+a_Stack.peek());//5
		
		pop(m_Stack, a_Stack);//5
		
		System.out.println("min : "+a_Stack.peek());//6
		
		pop(m_Stack, a_Stack);//10
		
		System.out.println("min : "+a_Stack.peek());//6
		
		pop(m_Stack, a_Stack);//6
		
		System.out.println("min : "+a_Stack.peek());//20
		
		pop(m_Stack, a_Stack);//20
		
		System.out.println("min : "+a_Stack.peek());//null
	}
	
	
}
