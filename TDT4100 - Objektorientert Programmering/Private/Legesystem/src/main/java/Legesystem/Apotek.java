package Legesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Apotek {
  private List<Legemiddel> legemiddelbank = new ArrayList<>(
    List.of(
      new Legemiddel("Heroin", 30.0),
      new Legemiddel("Xanax", 4.5),
      new Legemiddel("2CB", 100.0),
      new Legemiddel("Amfetamin", 43.4),
      new Legemiddel("Paracetamol", 51.5),
      new Legemiddel("Nesespray", 15.0)
    )
  );
  private List<Resept> resepter = new ArrayList<>();
  
  public void leggTilLegemiddel(Legemiddel l) {
    if (!legemiddelbank.contains(l)) {
      legemiddelbank.add(l);
    }
  }

  public void leggTilResept(Resept ... r) {
    for (Resept resept : r) {
      if (!resepter.contains(resept)) {
        resepter.add(resept);
      }
    }
  }

  /**
   * @return the legemiddelbank
   */
  public List<Legemiddel> getLegemiddelbank() {
    return legemiddelbank;
  }

  /**
   * @return the resepter
   */
  public List<Resept> getResepter() {
    return resepter;
  }

  @Override
  public String toString() {
    return 
      new StringBuilder()
      .append(Farge.gul("Apotek:") + "\n")
      .append(Farge.groenn("Alle legemidler: ") + "\n")
      .append(
        legemiddelbank
        .stream()
        .map(Legemiddel::getNavn)
        .collect(Collectors.joining(", "))
        .toString()
      )
      .append("\n" + Farge.groenn("Alle resepter: ") + "\n")
      .append(
        resepter
        .stream()
        .map(Resept::toString)
        .collect(Collectors.joining("\n"))
      )
      .toString();
  }

}