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
  //

  /**
   * Writes the contents of this Family to the OutputStream, so it can be
   * reconstructed using load.
   * 
   * @param out
   */
  public void save(OutputStream out) throws IOException {
    try (PrintWriter pw = new PrintWriter(out)) {
      /*
      # Members
      male Jonas
      female Stella
      female Karianne
      # Relations
      Jonas Stella Johanna Roger
      */
      pw.println("# Members");
      family.forEach(p -> 
        pw.println(String.format(
          "%s %s",
          p.getGender(),
          p.getName()
        ))
      );

      pw.println("# Relations");
      for (Person p : family) {
        // If the person has children
        if (p.iterator().hasNext()) {
          pw.print(p.getName());

          for (Person child : p) {
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
  private static List<String> tokenize(String line) {
    // ... no need to implement this method ...
    return null;
  }

  /**
   * Loads contents from the provided InputStream into this Family.
   * @param in
   */
  public void load(InputStream in) throws IOException {
    try (Scanner scanner = new Scanner(in)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        // Skip first line or empty lines
        if (line.trim().length() == 0 || line.startsWith("#")) {
          continue;
        }

        List<String> tokens = tokenize(line);
        Gender gender = Gender.valueOf(tokens.get(0));
        // If the line starts with a gender, - person-line
        if (gender != null) {
          Person newPerson = new Person(tokens.get(1));
          newPerson.setGender(gender);
          family.add(newPerson);
        
        // Family-tree 
        } else {
          Person ancestor = findMember(tokens.get(0));
          for (int i = 1; i < tokens.size(); i++) {
            ancestor.addChild(findMember(tokens.get(i)));
          }
        }
      }
    }
  }
}