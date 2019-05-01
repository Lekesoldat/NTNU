package src;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Patient extends Person {
  private static int patientCounter = 0;
  private final int patientID;

  private Collection<Prescription> prescriptions = new ArrayList<>();

  public Patient(String name, int age) {
    super(name, age);
    this.patientID = patientCounter++;
  }

  public void addPrescription(Prescription p) {
    if (prescriptions.contains(p)) {
      throw new IllegalArgumentException(this.getName() + " already has a prescription for " + p.getMedicament().getName());
    }

    prescriptions.add(p);
  }

  @Override
  public String allString() {
    return new StringBuilder(super.toString())
    .append(Colors.ANSI_GREEN + "Patient info: \n" + Colors.ANSI_RESET)
    .append("Patient ID: " + this.patientID + "\n")
    .append(
      "Prescriptions: " + prescriptions.stream()
      .map(p -> p.getMedicament().getName())
      .collect(Collectors.joining(", ")) + "\n"
    )
    .toString();
  }
}