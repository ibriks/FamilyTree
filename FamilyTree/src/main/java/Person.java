import java.util.HashSet;
import java.util.Set;

public class Person {
	private String name;
	private Set<Person> children;
	private boolean parentOnly;
	
	public Person(String str, boolean parOnly) { 
		name = str; 
		children = new HashSet<Person>();
		parentOnly = parOnly;
	}
	public String getName() {
		return name;
	}
	public boolean isParentOnly() {
		return parentOnly;
	}
	public Set<Person> getChildren(){
		return children;
	}
	public void setParentOnly(boolean parOnly) {
		parentOnly = parOnly;
	}
	
	@Override 
	public boolean equals(Object other) {
	    boolean result = false;
	    if (other instanceof Person) {
	        Person that = (Person) other;
	        if (name.equals(that.name)) {
	        	result = true;
	        }
	    }
	    return result;
	}
	
	@Override 
	public int hashCode() {
        return name.length();
    }
	
	public boolean canAddChildWithoutBreakingRules(Person child) {
		if (!children.contains(child) && !this.isThisPersonMyAncestor(child) && !this.equals(child)) {
			return true;
		}
		return false;
	}
	public void addChild(Person child) {
			children.add(child);
	}
	public boolean isThisPersonMyAncestor(Person child) {
		boolean rel = false;
		Set<Person> setOfChildren = child.children;
		if (!setOfChildren.isEmpty()) {
			for (Person person : setOfChildren) {
				if (this.equals(person)) {					
					rel = true;
					break;
				}
				else {
					rel = this.isThisPersonMyAncestor(person);
					if (rel) break;
				}
			}
		}
		return rel;
	}

}