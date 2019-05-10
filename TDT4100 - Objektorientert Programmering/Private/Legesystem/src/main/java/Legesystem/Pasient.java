package Legesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * En pasient arver fra {@code Person}, og er en klasse som holder styr på utskrevne resepter.
 * Implementerer den interfacet {@code Prioritet}.
 * @see Person
 * @see Prioritet
 */
public class Pasient extends Person implements Prioritet {
  private List<Resept> resepter = new ArrayList<>();
  private int prioritet = -1;
  private Lege fastLege = null;

  /**
   * Instansierer en ny pasient.
   * @param fornavn
   * @param etternavn
   */
  public Pasient(String fornavn, String etternavn) {
    super(fornavn, etternavn);
  }

  public void leggTilResept(Resept r) {
    resepter.add(r);
  }

  public void fjernResept(Resept r) {
    resepter.remove(r);
  }

  public void setPrioritet(int prioritet) {
    this.prioritet = prioritet;
  }

  public void setFastlege(Lege fastlege) {
    this.fastLege = fastlege;
  }

  @Override
  public String toString() {
    return 
    new StringBuilder(super.toString())
    .append(Farge.gul("Pasient-data:") + "\n")
    .append("Fastlege: " + this.fastLege.getNavn() + "\n")
    .append(Farge.groenn("Resepter: ") + "\n")
    .append(
      resepter
      .stream()
      .map(Resept::toString)
      .collect(Collectors.joining("\n"))
    )
    .toString();
  }

  @Override
  public int hentPrioritet() {
    return this.prioritet;
  }
}