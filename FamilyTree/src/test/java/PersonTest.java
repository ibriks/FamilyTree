import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void newPersonUsingString() {
		Person ana = new Person("Ana", true);
		assertEquals("Ana", ana.getName());
		assertEquals(true, ana.isParentOnly());
	}

	@Test
	public void usingEqualsToCompareNames() {
		Person ana = new Person("Ana", true);
		Person ana2 = ana;
		Person ana3 = null;
		ana2.setParentOnly(false);
		assertEquals(true, ana.equals(ana2));

		Person ivana = new Person("Ivana", true);
		assertEquals(false, ana.equals(ivana));
		assertEquals(false, ana.equals("Ana"));
		assertEquals(false, ana.equals(ana3));

	}

	@Test
	public void addingChildToPerson() {
		Person ivan = new Person("Ivan", true);
		Person adam = new Person("Adam", false);
		Person stjepan = new Person("Stjepan", false);
		ivan.addChild(adam);
		adam.addChild(stjepan);
		assertEquals(true, ivan.getChildren().contains(adam));
		assertEquals(true, adam.getChildren().contains(stjepan));
		assertEquals(false, ivan.getChildren().contains(stjepan));
	}

	@Test
	public void breakingTheRules() {
		Person ivan = new Person("Ivan", true);
		Person adam = new Person("Adam", false);
		Person stjepan = new Person("Stjepan", false);
		ivan.addChild(adam);
		adam.addChild(stjepan);
		ivan.canAddChildWithoutBreakingRules(adam);
		assertEquals(false, ivan.canAddChildWithoutBreakingRules(adam));
		assertEquals(false, ivan.canAddChildWithoutBreakingRules(ivan));
		assertEquals(false, stjepan.canAddChildWithoutBreakingRules(ivan));
		assertEquals(true, ivan.canAddChildWithoutBreakingRules(stjepan));
	}

}
