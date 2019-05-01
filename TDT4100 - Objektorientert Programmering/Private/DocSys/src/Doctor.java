package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Doctor extends Person {
  private static int docCounter = 0;
  
  private final int docID;
  private Collection<Prescription> prescribed = new ArrayList<>();

  public Doctor(String name, int age) {
    super(name, age);
    this.docID = docCounter++;
  }

  public void addPrescription(Prescription p) {
    if (prescribed.contains(p)) {
      throw new IllegalArgumentException(this.getName() + " has already prescribed " + p.getMedicament().getName());
    }

    prescribed.add(p);
  }

  @Override
  public String allString() {
    return new StringBuilder(super.toString())
      .append("Doctor ID: " + this.docID + "\n")
      .append("Name: " + this.getName() + "\n")
      .append(
        "Prescribed medicaments: " + prescribed.stream()
          .map(p -> p.getMedicament().getName())
          .sorted()
          .collect(Collectors.joining(", ")) + "\n"
      )
      .toString();
  }
}