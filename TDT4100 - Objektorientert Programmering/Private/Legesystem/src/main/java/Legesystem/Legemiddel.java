package Legesystem;

public class Legemiddel {
  private static int legemiddelTeller = 0;
  private final int legemiddelID;
  private String navn;
  private Double mengde;

  public Legemiddel(String navn, Double mengde) {
    this.navn = navn;
    this.mengde = mengde;
    this.legemiddelID = legemiddelTeller++;
  }

  public String getNavn() {
    return this.navn;
  }

  public Double getMengde() {
    return this.mengde;
  }

  public int getLegemiddelID() {
    return legemiddelID;
  }
}