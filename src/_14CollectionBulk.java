import java.util.ArrayList;
import java.util.List;

public class _14CollectionBulk {
	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(15);
		list.add(30);
		list.add(19);
		list.removeIf(x -> (x%2==0));
	}
}
