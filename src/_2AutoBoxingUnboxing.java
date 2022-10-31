
public class _2AutoBoxingUnboxing {

	public static void main(String[] args) {
		Integer x = 400;
		Integer y = 400;
		
		if(x==y) {
			System.out.println("Same");
		}else {
			System.out.println("Not Same");
		}
		
		int z = 400;
		int a = 400;
		
		if(z==a) {
			System.out.println("Same");
		}else {
			System.out.println("Not Same");
		}
		
		Integer b = 400;
		Integer c = b;
		
		if(b==c) {
			System.out.println("Same");
		}else {
			System.out.println("Not Same");
		}
		
		Integer d = z;
		Integer e = z;
		
		if(d==e) {
			System.out.println("Same");
		}else {
			System.out.println("Not Same");
		}
	}
}
