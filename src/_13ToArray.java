import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13ToArray {
	public static void main(String[] args) {
		
		List<String> strList = new ArrayList<>();
		strList.add("abhi");
		strList.add("vikas");
		strList.add("aish");
		
//		String[] s = new String[strList.size()] ;
//		s = strList.toArray(s);
		
		//new String[0] : zero size array.
		//new array will be created by toArray method.
		String[] s = strList.toArray(new String[0]);
		
		for (String string : s) {
			System.out.println(string);
		}
		
		List<String> newList = Arrays.asList(s);
		
		s[1] = "vikash";
		s[2] = "aishwarya";
		s[0] = "abhishek";
		
		System.out.println(newList);
	}
}
