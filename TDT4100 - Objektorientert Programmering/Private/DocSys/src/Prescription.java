package src;
public class Prescription {
  private static int prescriptionCounter = 0;
  private final int prescriptionID;

  private Doctor doctor;
  private Patient patient;
  private Medicament medicament;
  private int refill;

  public Prescription(Doctor doc, Patient pat, Medicament med, int refill) {
    this.doctor = doc;
    this.patient = pat;
    this.medicament = med;
    this.refill = refill;

    this.prescriptionID = prescriptionCounter++;

    doc.addPrescription(this);
    pat.addPrescription(this);
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public Medicament getMedicament() {
    return medicament;
  }

  public Patient getPatient() {
    return patient;
  }

  public int getPrescriptionID() {
    return prescriptionID;
  }

  public int getRefill() {
    return refill;
  }

  public boolean use() {
    if (refill > 0) {
      refill--;
      return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("ID: " + this.prescriptionID + "\n")
      .append("Doctor: " + this.doctor.getName() + "\n")
      .append("Patient: " + this.patient.getName() + "\n")
      .append("Medicament: " + this.medicament.getName() + "\n")
      .append("Uses left: " + this.refill + "\n")
      .toString();
  }
}