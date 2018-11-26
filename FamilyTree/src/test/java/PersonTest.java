import static org.junit.Assert.*;


import org.junit.Test;

public class PersonTest {
 
	@Test
	public void newPersonUsingString() {		
		Person Ana = new Person("Ana", true);
		assertEquals("Ana", Ana.getName());
		assertEquals(true, Ana.isParentOnly());
	}
	
	@Test
	public void usingEqualsToCompareNames() {
		Person Ana = new Person("Ana", true);
		Person Ana2 = Ana;
		Ana2.setParentOnly(false);
		assertEquals(true, Ana.equals(Ana2));
		
		Person Ivana = new Person("Ivana", true);
		assertEquals(false, Ana.equals(Ivana));
		assertEquals(false, Ana.equals("Ana"));
	}
	
	@Test
	public void addingChildToPerson() {
		Person Ivan = new Person("Ivan", true);
		Person Adam = new Person("Adam", false);
		Person Stjepan = new Person("Stjepan", false);
		Ivan.addChild(Adam);
		Adam.addChild(Stjepan);
		assertEquals(true, Ivan.getChildren().contains(Adam));
		assertEquals(true, Adam.getChildren().contains(Stjepan));
		assertEquals(false, Ivan.getChildren().contains(Stjepan));
	}
	
	@Test
	public void breakingTheRules() {
		Person Ivan = new Person("Ivan", true);
		Person Adam = new Person("Adam", false);
		Person Stjepan = new Person("Stjepan", false);
		Ivan.addChild(Adam);
		Adam.addChild(Stjepan);
		Ivan.canAddChildWithoutBreakingRules(Adam);
		assertEquals(false, Ivan.canAddChildWithoutBreakingRules(Adam));
		assertEquals(false, Ivan.canAddChildWithoutBreakingRules(Ivan));
		assertEquals(false, Stjepan.canAddChildWithoutBreakingRules(Ivan));
		assertEquals(true, Ivan.canAddChildWithoutBreakingRules(Stjepan));
	}
			
}
