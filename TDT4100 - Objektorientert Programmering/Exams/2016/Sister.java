import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sister implements Relation {

  @Override
  public Collection<Person> getRelativesOf(Person person) {
    List<Person> results = new ArrayList<>();
    if (person != null) {
      addSibling(person.getFather(), results, Gender.FEMALE);
      addSibling(person.getMother(), results, Gender.FEMALE);

      // Cannot be your own sibling
      results.remove(person);
    }
    return results;
  }

  private void addSibling(Person parent, List<Person> list, Gender gender) {
    if (parent != null) {
      for (Person child : parent) {
        if (child.getGender() == gender && !list.contains(child)) {
          list.add(child);
        }
      }
    }
  }
}