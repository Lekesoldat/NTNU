package Legesystem;

public abstract class Helsearbeider extends Person {
  // Starter på høyere tall for enklere å skille mellom fnr og id
  private static int helseArbeiderTeller = 55;
  private final int helseArbeiderID;

  public Helsearbeider(String fornavn, String etternavn) {
    super(fornavn, etternavn);
    this.helseArbeiderID = helseArbeiderTeller++;
  }

  public int getHelseArbeiderID() {
    return this.helseArbeiderID;
  }

  public abstract String getTittel();

  @Override
  public String toString() {
    return 
      new StringBuilder(super.toString())
      .append(Farge.gul("Helsearbeider-data:") + "\n")
      .append("HelsearbeiderID: " + this.helseArbeiderID + "\n")
      .append("\n")
      .toString();
  }
}