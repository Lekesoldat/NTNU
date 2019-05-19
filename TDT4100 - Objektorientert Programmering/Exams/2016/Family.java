import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Family {
  private List<Person> family = new ArrayList<>();

  /**
   * Adds a Person as a new family member
   * 
   * @param person the Person to add
   */
  public void addMember(Person person) {
    if (!family.contains(person)) {
      family.add(person);
    }
  }

  /**
   * Finds a member with the given name
   * 
   * @param name
   * @return the Person in this Family with the provided name
   */

  public Person findMember(String name) {
    return family.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
  }

  /**
  * Writes the contents of this Family to the OutputStream,
  * so it can be reconstructed using load.
  * @param out
  */
  public void save(OutputStream out) throws IOException {
    try (PrintWriter pw = new PrintWriter(out)) {
      pw.println("# Members");
      family.forEach(p ->
        pw.println(
          String.format(
            "%s %s",
            p.getGender(),
            p.getName()
          )
        )
      );

      pw.println("# Relations");
      for (Person person : family) {
        // Check for children
        if (person.iterator().hasNext()) {
          pw.print(person.getName());

          for (Person child : person) {
            pw.print(" " + child.getName());
          }
          pw.println();
        }
      }
    }
  }

  /**
  * Helper method that splits a line into a list of tokens,
  * either words or quoted names (quotes are removed).
  * @param line – the string to tokenize
  */
  private List<String> tokenize(String line) {
    ... no need to implement this method ...
  }

  /**
  * Loads contents from the provided InputStream into this Family.
  * @param in
  */
  public void load(InputStream in) throws IOException {
    try (Scanner scanner = new Scanner(in)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        if (line.trim().length() == 0 || line.startsWith("#")) {
          continue;
        }

        List<String> tokens = tokenize(line);
        Gender gender = Gender.valueOf(tokens.get(0));

        // Person-line
        if (gender != null) {
          Person newPerson = new Person(tokens.get(1));
          newPerson.setGender(gender);
          family.add(newPerson);
        } 
        
        // Relation-line
        else {
          Person ancestor = findMember(tokens.get(0));
          tokens.stream().skip(1).forEach(p -> ancestor.addChild(new Person(p)));
        }
      }
    }
  }
}