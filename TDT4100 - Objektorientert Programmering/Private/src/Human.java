import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Lambda Comparisons
public class Human {
  private String name;
  private int age;

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }

  /**
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param age the age to set
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new StringBuilder().append(this.name + ": " + this.age).toString();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  public void sortWithoutLambda() {
    List<Human> humans = Arrays.asList(
      new Human("Godzilla", 32),
      new Human("Hilde", 20),
      new Human("Magnus", 21),
      new Human("Andreas", 21),
      new Human("Zamot", 21)
    );

    humans.sort(
      new Comparator<Human>() {
        @Override
        public int compare(Human h1, Human h2) {
          return h1.getName().compareTo(h2.getName());
        }
      }
    );

    humans.stream().forEach(System.out::println);
  }

  public void sortWithLambda() {
    List<Human> humans = new ArrayList<>(
      Arrays.asList(
        new Human("Godzilla", 32),
        new Human("Hilde", 20),
        new Human("Magnus", 21),
        new Human("Andreas", 21),
        new Human("Zamot", 21))
    );
    humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
    humans.forEach(System.out::println);
  }

  public static void main(String[] args) {
    Human human = new Human("Test", 21);
    human.sortWithoutLambda();
    human.sortWithLambda();
  }
}