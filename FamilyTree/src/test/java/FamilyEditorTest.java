import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyEditorTest {
	
	@Test
	public void firstEntryInSet() {
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		Person Adam = null;
		Person Ivan = null;
		for (Person person : family.returnFamily()) {
			if (person.getName().equals("Adam")) {
				Adam = person;
			}
			if (person.getName().equals("Ivan")) {
				Ivan = person;
			}
		}
		assertEquals(true, family.returnFamily().contains(Adam));
		assertEquals(true, family.returnFamily().contains(Ivan));
		assertEquals(true, Ivan.getChildren().contains(Adam));
	}
	
	@Test
	public void findingPersonInSetByName() {
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		Person Adam = family.personFinder("Adam");
		Person Ivan = family.personFinder("Ivan");
		assertEquals(true, family.returnFamily().contains(Adam));
		assertEquals(true, family.returnFamily().contains(Ivan));
	}
	
	@Test
	public void newEntryNewChildAndNewParent() {
		// Building family  
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		
		//Test
		family.addRelation("Marko", "Stjepan");
		Person Marko = family.personFinder("Marko");
		Person Stjepan = family.personFinder("Stjepan");
		assertEquals(true, family.returnFamily().contains(Marko));
		assertEquals(true, family.returnFamily().contains(Stjepan));
		assertEquals(true, Stjepan.getChildren().contains(Marko));
	}
	
	@Test
	public void newEntryNewChildAndParentFromSet() {
		// Building family  
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		
		//Test
		family.addRelation("Robert", "Stjepan");
		Person Robert = family.personFinder("Robert");
		Person Stjepan = family.personFinder("Stjepan");
		Person Marko = family.personFinder("Marko");
		assertEquals(true, family.returnFamily().contains(Robert));
		assertEquals(true, Stjepan.getChildren().contains(Robert));
		assertEquals(true, Stjepan.getChildren().contains(Marko));
	}
	
	@Test
	public void newEntryChildFromSetAndNewParent() {
		// Building family  
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		family.addRelation("Robert", "Stjepan");
		
		//Test
		family.addRelation("Robert", "Josip");
		Person Robert = family.personFinder("Robert");
		Person Josip = family.personFinder("Josip");
		Person Stjepan = family.personFinder("Stjepan");
		assertEquals(true, family.returnFamily().contains(Josip));
		assertEquals(true, Josip.getChildren().contains(Robert));
		assertEquals(true, Stjepan.getChildren().contains(Robert));
	}
	
	@Test
	public void newEntryChildAndParentFromSet() {
		// Building family  
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		family.addRelation("Robert", "Stjepan");
		family.addRelation("Robert", "Josip");
		
		//Test
		family.addRelation("Stjepan", "Adam");
		Person Stjepan = family.personFinder("Stjepan");
		Person Adam = family.personFinder("Adam");
		assertEquals(true, Adam.getChildren().contains(Stjepan));
	}
	
	@Test	//(expected=RelationNotAllowedException.class)
	public void newEntryCyclicRelation() {
		// Building family  
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		family.addRelation("Robert", "Stjepan");
		family.addRelation("Stjepan", "Adam");
	
		//Test
		family.addRelation("Adam", "Robert");
		Person Adam = family.personFinder("Adam");
		Person Robert = family.personFinder("Robert");
		assertEquals(false, Robert.getChildren().contains(Adam));
	}
	
	@Test	//(expected=RelationNotAllowedException.class)
	public void newEntryRepeatedRelation() {
		// Building family  
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
	
		//Test
		family.addRelation("Adam", "Ivan");
		Person Adam = family.personFinder("Adam");
		Person Ivan = family.personFinder("Ivan");
		assertEquals(2, family.returnFamily().size());
		assertEquals(true, Ivan.getChildren().contains(Adam));
		assertEquals(1, Ivan.getChildren().size());
	}
	
	@Test
	public void newEntrySameName() {
		// Building family  
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
	
		//Test
		family.addRelation("Adam", "Adam");
		Person Adam = family.personFinder("Adam");
		Person Ivan = family.personFinder("Ivan");
		assertEquals(2, family.returnFamily().size());
		assertEquals(true, Ivan.getChildren().contains(Adam));
		assertEquals(1, Ivan.getChildren().size());
		assertEquals(0, Adam.getChildren().size());
	}

}
