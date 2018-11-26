import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileParser {
	
	private FileParser() {}
	
	public static FamilyEditor parseFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner inFile = new Scanner(new FileReader(file));
		
		FamilyEditor family = new FamilyEditor();

		while (inFile.hasNext()) {
			String childName = inFile.next();
	    	String parentName = inFile.next();	
	    	
	    	family.addRelation(childName, parentName);
		}
		
	    inFile.close();
	    return family;
	}
}
