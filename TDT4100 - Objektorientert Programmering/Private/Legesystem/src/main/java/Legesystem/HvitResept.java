package Legesystem;

public class HvitResept extends Resept {

  public HvitResept(Lege lege, Pasient pasient, Legemiddel legemiddel, Double pris, int reit) {
    super(lege, pasient, legemiddel, pris, reit);
  }

  @Override
  public String getType() {
    return Farge.hvit("Hvit");
  }

  @Override
  public Double getPris() {
    return this.pris;
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