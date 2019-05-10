package Legesystem;

public class Legemiddel {

  private String navn;
  private Double mengde;

  public Legemiddel(String navn, Double mengde) {
    this.navn = navn;
    this.mengde = mengde;
  }

  public String getNavn() {
    return this.navn;
  }

  public Double getMengde() {
    return this.mengde;
  }
}