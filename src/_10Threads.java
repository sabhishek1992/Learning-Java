
//Two threads running independently : main, test
//These threads can be assigned different cores of CPU.

public class _10Threads {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Test t = new Test();
		 * 
		 * t.start(); for (int i = 0; i < 5; i++) {
		 * System.out.println("Inside main thread"); Thread.sleep(1);//1 millisecond }
		 */
		
		Thread t = new Thread(new Test1());
		t.start();
		System.out.println("Inside main thread");
	}
}

class Test1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Inside test1 thread");
	}
}

class Test extends Thread{
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Inside test thread");	
		}
	}
}