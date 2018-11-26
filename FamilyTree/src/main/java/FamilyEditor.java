import java.util.HashSet;
import java.util.Set;

public class FamilyEditor {
	private Set<Person> people;

	public FamilyEditor() {
		people = new HashSet<Person>();
	}

	public Set<Person> getFamily() {
		return people;
	}

	public Person personFinder(String name) {
		Person per = new Person(name, true);
		for (Person person : people) {
			if (per.equals(person)) {
				return person;
			}
		}
		return null;
	}

	public void addRelation(String childName, String parentName) throws RelationNotAllowedException {
		Person child = personFinder(childName);
		Person parent = personFinder(parentName);

		if (child == null) {
			child = new Person(childName, false);
			people.add(child);
		}
		if (parent == null) {
			parent = new Person(parentName, true);
			people.add(parent);
		}

		if (parent.canAddChildWithoutBreakingRules(child)) {
			child.setParentOnly(false);
			parent.addChild(child);
		} else {
			if (parent.getChildren().contains(child)) {
				throw new RelationNotAllowedException(String.format(
						"Msg: %s is already a child of %s!", child.getName(), parent.getName()));
			}
			if (parent.isThisPersonMyAncestor(child)) {
				throw new RelationNotAllowedException(String.format(
						"Msg: Trying to make cyclic relation with %s and %s!", child.getName(), parent.getName()));
			}
			if (parent.equals(child)) {
				throw new RelationNotAllowedException(String.format(
						"Msg: %s cannot be its parent or child!", parent.getName()));
			}
		}
	}
}
