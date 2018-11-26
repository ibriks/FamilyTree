import java.io.FileNotFoundException;

public class App {
	
	private App() {}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FamilyEditor family = FileParser.parseFile(args[0]);
	    
    	FamilyOutput.output(family.returnFamily());
	}
}

