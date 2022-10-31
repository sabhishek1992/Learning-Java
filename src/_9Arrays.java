import java.util.Arrays;
import java.util.Scanner;

public class _9Arrays {

	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {64,35,23,4,5,2,90,81};
//		bubbleSort(arr,0,arr.length-1,true);
		mergeSort(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.print(i+", ");
		}
		System.out.println();
	}
	
	static void merge(int arr[], int start, int end, int mid) {
		
		int leftArrSize = mid-start+1;
		int rightArrSize = end-mid;
		
		int L[] = new int[leftArrSize];
		int R[] = new int[rightArrSize];
		
		for (int i = 0; i < leftArrSize; i++) {
			L[i] = arr[start+i];
		}
		for (int i = 0; i < rightArrSize; i++) {
			R[i] = arr[mid+1+i];
		}
		
		int i=0,j=0;
		int k = start;
		
		while(i < leftArrSize && j < rightArrSize) {
			if(L[i]<=R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<leftArrSize) {
			arr[k] = L[i];
			k++;i++;
		}
		while(j<rightArrSize) {
			arr[k] = R[j];
			k++;j++;
		}
	}
	
	public static void mergeSort(int arr[], int start,int end) {
		
		if(start < end) {
			int mid = (start+end)/2;

			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);

			merge(arr,start,end,mid);
		}
	}
	
	public static void bubbleSort(int arr[],
			int start,int end,boolean swapped) {
		System.out.print("Inside start :"+start+" , end :"+end+" , swapped :"+swapped);
		for (int i : arr) {
			System.out.print(i+", ");
		}
		System.out.println();
		if(swapped && start < end) {
			swapped = false;
			for (int i = start; i < end; i++) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];				
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swapped = true;
				}
			}
			bubbleSort(arr,start,end-1,swapped);
		}
	}
	
	
	
	public static int linearSearch(int[] a, int x){
		
		int index = 0;
		for (int elem : a) {
			if(elem == x) {
				return index;
			}
			index++;
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] a, 
			int start,int end,int element) {
		
		if(end >=1) {
			int mid = (start+end)/2;

			if(a[mid] == element) return mid;

			if(a[mid] > element) 
				return binarySearch(a,start,mid-1,element);

			return binarySearch(a,mid+1,end,element);
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main1(String[] args) {
		int[] a = {10,20,40,30};
		
		//length is member of array
		System.out.println(a.length);
		
		int[] b ; // local-variable to main()
		b = new int[4]; //allocated memory in heap, using new
		b[1] = 23;
		b[2] = 54;
		//For b[0], b[3] value will be default i.e. 0.
		//Reason : Array are actually objects
		
		for (int i : b) {
			System.out.println(i);
		}
		
		Object[] array = {"Abhi",1.0,4,false};
		
		for (Object obj : array) {
			System.out.println(obj);
		}
	}
}
