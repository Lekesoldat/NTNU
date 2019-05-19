import java.util.Arrays;
import java.util.List;

class Person {
  public String name;
  public int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;

  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name + " (" + this.age + ")";
  }
}

public class MoreStreams {
  private static List<Person> people = Arrays.asList(
    new Person("Andreas", 21),
    new Person("Anhkha", 20),
    new Person("Johanne", 23),
    new Person("Magnus", 21),
    new Person("Peter", 23),
    new Person("Marius", 23),
    new Person("Ingrid", 20),
    new Person("Hilde", 20),
    new Person("Dorbell", 55)
  );

  public static void main(String[] args) {
    int sumOfAllAges = people.stream().mapToInt(Person::getAge).sum();
    System.out.println("Sum of all ages: " + sumOfAllAges);

    people.forEach(p -> p.setName(p.getName().toUpperCase()));
    System.err.println("All names capitalized: " + people);

    people.forEach(p -> p.setName(p.getName().substring(0,1) + p.getName().substring(1).toLowerCase()));
    System.err.println("All names with capital first letter again: " + people);

    System.out.print("People starting with 'M' and above 21 y/o: ");
    people.stream()
      .filter(p -> (p.getName().charAt(0) == 'M'))
      .filter(p -> p.getAge() > 21)
      .forEach(System.out::println);

    System.out.print("Peter in list: " + people.stream().anyMatch(p -> p.getName().equals("Peter")));
  }
}
