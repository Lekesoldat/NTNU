import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Person implements Iterable<Person> {

  private final String name;
  private Gender gender = null;
  private Person mother = null;
  private Person father = null;
  private Collection<Person> children = new ArrayList<>();

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Gender getGender() {
    return this.gender;
  }

  public Person getMother() {
    return this.mother;
  }

  public Person getFather() {
    return this.father;
  }

  /**
   * @return the number of children of this Person
   */
  public int getChildCount() {
    return children.size();
  }

  /**
   * @param child
   * @return if this Person has the provided Person as a child
   */
  public boolean hasChild(Person child) {
    return children.contains(child);
  }

  /**
   * Returns all children of this Person with the provided Gender. If gender is
   * null, all children are returned. Can be used to get all daughters or sons of
   * a person.
   * 
   * @param gender
   */
  public Collection<Person> getChildren(Gender gender) {
    return children.stream().filter(c -> c.getGender() == gender).collect(Collectors.toList());
  }

  /**
   * Adds the provided Person as a child of this Person.
   * Also sets the child's father or mother to this Person,
   * depending on this Person's gender.
   * To ensure consistency, if the provided Person already
   * has a parent of that gender,
   * it is removed as a child of that parent.
   * @param child
   */
  public void addChild(Person child) {
    if (this.getGender() == Gender.MALE) {
      if (child.father != null) {
        child.father.children.remove(child);
      }
      child.father = this;
    }

    if (this.getGender() == Gender.FEMALE) {
      if (child.mother != null) {
        child.mother.children.remove(child);
      }
      child.mother = this;
    }

    if (!children.contains(child)) {
      children.add(child);
    }
  }

  @Override
  public Iterator<Person> iterator() {
    return children.iterator();
  }
}