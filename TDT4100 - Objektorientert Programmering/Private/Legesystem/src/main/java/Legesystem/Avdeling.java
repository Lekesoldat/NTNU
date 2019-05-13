package Legesystem;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Avdeling {
  private static int avdelingTeller = 0;
  private final int avdelingsID;
  private int prioritetsNivå;

  private Pasient[] senger;
  
  public Avdeling(int antallPlasser, int prioritetsNivå) {
    this.prioritetsNivå = prioritetsNivå;
    senger = new Pasient[antallPlasser];

    this.avdelingsID = avdelingTeller++;
  }

  public int getPrioritetsNivå() {
    return prioritetsNivå;
  }

  public int getAvdelingsID() {
    return avdelingsID;
  }

  public boolean pasientPaaRom(Pasient p) {
    return Arrays.asList(senger).contains(p);
  }

  public boolean plasserISeng(Pasient p) {
    for (int i = 0; i < senger.length; i++) {
      if (senger[i] == null) {
        senger[i] = p;
        return true;
      }
    }
    return false;
  }

  public boolean fjernFraSeng(Pasient p) {
    if (!pasientPaaRom(p)) {
      return false;
    }
    
    senger[Arrays.asList(senger).indexOf(p)] = null;
    return true;
  }

  @Override
  public String toString() {
    return 
      new StringBuilder()
      .append(Farge.rod("Prioritetsnivå: ") + this.prioritetsNivå + "\n")
      .append(
        IntStream
        .range(0, senger.length)
        .mapToObj(
          i -> "Seng nummer: " + i + " er okkupert av: " + ((senger[i] == null) ? "ingen." : (senger[i].getNavn() + ", " + senger[i].hentPrioritet()))
        )
        .collect(Collectors.joining("\n"))
      )
      .toString();
  }
}