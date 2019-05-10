package Legesystem;

import java.util.Random;


public abstract class Person { 
  private static int personTeller = 0;
  private final int personNummer;

  private String fornavn;
  private String etternavn;
  private final int alder;

  public Person(String fornavn, String etternavn) {
    this.fornavn = fornavn;
    this.etternavn = etternavn;
    this.personNummer = personTeller++;
    this.alder = new Random().nextInt(100);
  }

  public String getFornavn() {
    return this.fornavn;
  }

  public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
  }

  public String getEtternavn() {
    return this.etternavn;
  }

  public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
  }

  public String getNavn() {
    return this.fornavn + " " + this.etternavn;
  }

  public int getAlder() {
    return this.alder;
  }

  public int getPersonNummer() {
    return this.personNummer;
  }

  public static int getPersonTeller() {
    return personTeller;
  }

  @Override
  public String toString() {
    return 
      new StringBuilder()
      .append(Farge.gul("Person-data:") + "\n")
      .append("Personnummer: " + this.personNummer + "\n")
      .append("Navn, alder: " + this.fornavn + " " + this.etternavn + ", " + this.alder + "\n")
      .append("\n")
      .toString();
  }
}