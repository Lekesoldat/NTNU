package Legesystem;

public abstract class Resept {
  public static int reseptTeller = 0;
  public final int reseptID;

  public final Lege lege;
  public final Pasient pasient;
  public final Legemiddel legemiddel;
  
  public int reit;
  public Double pris;

  public Resept(Lege lege, Pasient pasient, Legemiddel legemiddel, Double pris, int reit) {
    this.lege = lege;
    this.pasient = pasient;
    this.legemiddel = legemiddel;
    this.pris = pris;
    this.reit = reit;

    this.reseptID = reseptTeller++;

    lege.leggTilResept(this);
    pasient.leggTilResept(this);
  }

  public Lege getLege() {
    return lege;
  }

  public Pasient getPasient() {
    return pasient;
  }

  public Legemiddel getLegemiddel() {
    return legemiddel;
  }

  public int getReseptID() {
    return reseptID;
  }

  public abstract String getType();
  public abstract Double getPris();

  @Override
  public String toString() {
    return 
      new StringBuilder()
      .append("Resept-id: " + this.reseptID + "\n")
      .append("Legemiddel: " + Farge.rod(legemiddel.getNavn()) + ", " + legemiddel.getMengde() + "mg \n")
      .append("Pris: " + getPris() + "kr \n")
      .append("Reit: " + this.reit + "\n")
      .append("Utskrivende lege: " + lege.getNavn() + "\n")
      .append("Pasient: " + pasient.getNavn() + "\n")
      .toString();
  }
}