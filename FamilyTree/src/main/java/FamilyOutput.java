import java.util.Set;

public class FamilyOutput {
	
	private FamilyOutput() {}
	
	public static void output(Set<Person> people) {
		for (Person person : people) {
    		if (person.isParentOnly()) print(person, 0);
    	}
	}
	
	private static void print(Person person, int n) {
		for (int i = 0; i<n; i++) System.out.print("    ");
		System.out.println(person.getName());
		if (!person.getChildren().isEmpty()) {
			for (Person child : person.getChildren()) {
				print(child, n+1);
			}
		}
	}
}
