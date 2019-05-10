package Legesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lege extends Helsearbeider {
  private List<Pasient> pasienter = new ArrayList<>();
  private List<Resept> resepter = new ArrayList<>();

  public Lege(String fornavn, String etternavn) {
    super(fornavn, etternavn);
  }

  @Override
  public String getTittel() {
    return "Fastlege";
  }

  public List<Pasient> getPasienter() {
    return pasienter;
  }

  public List<Resept> getResepter() {
    return resepter;
  }

  public void leggTilPasient(Pasient ... pasienter) {
    for (Pasient pasient : pasienter) {
      if (!this.pasienter.contains(pasient)) {
        this.pasienter.add(pasient);
        pasient.setFastlege(this);
      }
    }
  }

  public void fjernPasient(Pasient p) {
    if (pasienter.contains(p)) {
      pasienter.remove(p);
      p.setFastlege(null);
    }
  }

  public void leggTilResept(Resept r) {
    resepter.add(r);
  }

  @Override
  public String toString() {
    return 
      new StringBuilder(super.toString())
      .append(Farge.gul("Lege-data:") + "\n")
      .append("Tittel: "+ this.getTittel() + "\n")
      .append(Farge.groenn("Pasienter:") + "\n")
      .append(
        pasienter
        .stream()
        .map(p -> (p.getFornavn() + " " + p.getEtternavn()))
        .collect(Collectors.joining(", "))
        + "\n")
      .append(Farge.groenn("Resepter skrevet ut:") + "\n")
      .append(
        resepter
        .stream()
        .map(Resept::toString)
        .collect(Collectors.joining("\n"))
      )
      .append("\n")
      .toString();
  }
}