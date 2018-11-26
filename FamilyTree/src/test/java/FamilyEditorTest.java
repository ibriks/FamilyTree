import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyEditorTest {

	@Test
	public void firstEntryInSet() {
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		Person adam = null;
		Person ivan = null;
		for (Person person : family.getFamily()) {
			if (person.getName().equals("Adam")) {
				adam = person;
			}
			if (person.getName().equals("Ivan")) {
				ivan = person;
			}
		}
		assertEquals(true, family.getFamily().contains(adam));
		assertEquals(true, family.getFamily().contains(ivan));
		assertEquals(true, ivan.getChildren().contains(adam));
	}

	@Test
	public void findingPersonInSetByName() {
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		Person adam = family.personFinder("Adam");
		Person ivan = family.personFinder("Ivan");
		assertEquals(true, family.getFamily().contains(adam));
		assertEquals(true, family.getFamily().contains(ivan));
	}

	@Test
	public void newEntryNewChildAndNewParent() {
		// Building family
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");

		// Test
		family.addRelation("Marko", "Stjepan");
		Person marko = family.personFinder("Marko");
		Person stjepan = family.personFinder("Stjepan");
		assertEquals(true, family.getFamily().contains(marko));
		assertEquals(true, family.getFamily().contains(stjepan));
		assertEquals(true, stjepan.getChildren().contains(marko));
	}

	@Test
	public void newEntryNewChildAndParentFromSet() {
		// Building family
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");

		// Test
		family.addRelation("Robert", "Stjepan");
		Person robert = family.personFinder("Robert");
		Person stjepan = family.personFinder("Stjepan");
		Person marko = family.personFinder("Marko");
		assertEquals(true, family.getFamily().contains(robert));
		assertEquals(true, stjepan.getChildren().contains(robert));
		assertEquals(true, stjepan.getChildren().contains(marko));
	}

	@Test
	public void newEntryChildFromSetAndNewParent() {
		// Building family
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		family.addRelation("Robert", "Stjepan");

		// Test
		family.addRelation("Robert", "Josip");
		Person robert = family.personFinder("Robert");
		Person josip = family.personFinder("Josip");
		Person stjepan = family.personFinder("Stjepan");
		assertEquals(true, family.getFamily().contains(josip));
		assertEquals(true, josip.getChildren().contains(robert));
		assertEquals(true, stjepan.getChildren().contains(robert));
	}

	@Test
	public void newEntryChildAndParentFromSet() {
		// Building family
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		family.addRelation("Robert", "Stjepan");
		family.addRelation("Robert", "Josip");

		// Test
		family.addRelation("Stjepan", "Adam");
		Person stjepan = family.personFinder("Stjepan");
		Person adam = family.personFinder("Adam");
		assertEquals(true, adam.getChildren().contains(stjepan));
	}

	@Test (expected=RelationNotAllowedException.class)
	public void newEntryCyclicRelation() {
		// Building family
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		family.addRelation("Robert", "Stjepan");
		family.addRelation("Stjepan", "Adam");

		// Test
		family.addRelation("Adam", "Robert");
	}

	@Test (expected=RelationNotAllowedException.class)
	public void newEntryRepeatedRelation() {
		// Building family
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");

		// Test
		family.addRelation("Adam", "Ivan");
	}

	@Test (expected=RelationNotAllowedException.class)
	public void newEntrySameName() {
		// Building family
		FamilyEditor family = new FamilyEditor();
		family.addRelation("Adam", "Ivan");

		// Test
		family.addRelation("Adam", "Adam");
	}

}
