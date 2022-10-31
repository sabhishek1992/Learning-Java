import java.util.ArrayList;
import java.util.Collection;

public class _12WildCardInGenerics {
	public static void main(String[] args) {
		ArrayList<EnggStud> enggArr = new ArrayList<EnggStud>();
		enggArr.add(new EnggStud());
		enggArr.add(new EnggStud());
		printCollect(enggArr);
		
		
		ArrayList<MgmtStud> mgmtArr = new ArrayList<MgmtStud>();
		mgmtArr.add(new MgmtStud());
		mgmtArr.add(new MgmtStud());
		printCollect(mgmtArr);
	}
	
	static void printStudents(ArrayList<? extends Stud> arr) {
		for (Stud s : arr) {
			s.print();
		}
	}
	
	static void printCollect(Collection<?> arr) {
		for (Object s : arr) {
			System.out.println(s + " ");
		}
	}
}

class Stud{
	void print() {
		System.out.println("Student");
	}
}

class EnggStud extends Stud{
	void print() {
		System.out.println("EnggStudent");
	}
}

class MgmtStud extends Stud{
	void print() {
		System.out.println("MgmtStudent");
	}

	@Override
	public String toString() {
		return "MgmtStud []";
	}
}