package Legesystem;

public class BlaaResept extends Resept {

  public BlaaResept(Lege lege, Pasient pasient, Legemiddel legemiddel, Double pris, int reit) {
    super(lege, pasient, legemiddel, pris, reit);
  }

  @Override
  public String getType() {
    return Farge.blaa("Blå");
  }

  @Override
  public Double getPris() {
    // Antar blåresept gir 70% avslag
    return this.pris * 0.3;
  }

  @Override
  public String toString() {
    return
     new StringBuilder()
     .append("Type: " + this.getType() + "\n")
     .append(super.toString())
     .toString();
  }
}