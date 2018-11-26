import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;

public class FileParser {

	private FileParser() {
	}

	public static Set<Person> parseFile(String path) throws FileNotFoundException, RelationNotAllowedException {
		File file = new File(path);
		Scanner inFile = new Scanner(new FileReader(file));

		FamilyEditor family = new FamilyEditor();

		while (inFile.hasNext()) {
			String childName = inFile.next();
			String parentName = inFile.next();
			
			try {
				family.addRelation(childName, parentName);
			} catch (RelationNotAllowedException e) {
				System.err.println(e);
			}
		
		}

		inFile.close();
		return family.getFamily();
	}
}
