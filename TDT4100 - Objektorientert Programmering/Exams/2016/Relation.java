import java.util.Collection;

public interface Relation {
  /*
   * Returns the Collection of Persons related to the provided Person
   * according to this Relation.
   * E.g. if this Relation corresponds to the concept of niece,
   * it should return all Persons that are nieces of person.
   */
  Collection<Person> getRelativesOf(Person person);
}