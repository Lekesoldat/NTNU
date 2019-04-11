import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ContestantManager
 */
public class ContestantManager {
  public List<Contestant> contestants = new ArrayList<>();

  public void addContestant(Contestant contestant) {
    if (contestant != null){
      this.contestants.add(contestant);
    }
  }

  public void sortContestantsOnTime() {
    contestants.sort((c1, c2) -> c1.getTime().compareTo(c2.getTime()));
  }

  public void writeFile(File file) throws IOException {
    try (PrintWriter pw = new PrintWriter(file)) {
      for (Contestant c : contestants) {
        pw.println(
          String.format(
            "%s %f",
            c.getFirstName(),
            c.getTime()
          )
        );
      }

      System.out.println("\u001B[33m" + "Successfully wrote to file." + "\u001B[0m");
    }
  }

  public void readFile(File file) throws IOException {
    try (Scanner scanner = new Scanner(file)) {
      contestants.clear();

      while (scanner.hasNext()) {
        contestants.add(new Contestant(scanner.next(), scanner.nextDouble()));
      }

      System.out.println("\u001B[33m" + "Successfully read from file." + "\u001B[0m");
    }
  }

  public void printData() {
    contestants
      .stream()
      .forEach(System.out::println);
  }

  public static void main(String[] args) throws IOException {
    ContestantManager manager = new ContestantManager();
    // Load
    manager.readFile(new File("../src/contestants.txt"));

    // Add more data
    manager.addContestant(new Contestant("Sigurd", 12.11));
    manager.addContestant(new Contestant("Ine", 2.00));
    manager.addContestant(new Contestant("Robert", 13.37));
    manager.addContestant(new Contestant("Kim", 100.00));

    // Print unodified data
    System.out.println("\u001B[32m" + "Initial list:" + "\u001B[0m");
    manager.printData();

    // Sort data
    System.out.println("\n\u001B[32m" + "After sort:" + "\u001B[0m");
    manager.sortContestantsOnTime();
    manager.printData();

    // Store
    manager.writeFile(new File("../src/contestants.txt"));
  }
}