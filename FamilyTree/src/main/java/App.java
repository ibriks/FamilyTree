import java.io.FileNotFoundException;
import java.util.Set;

public class App {

	private App() {
	}

	public static void main(String[] args) throws FileNotFoundException {

		Set<Person> familyTree = FileParser.parseFile(args[0]);

		FamilyOutput.output(familyTree);
	}
}
