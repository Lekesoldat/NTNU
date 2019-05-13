package Legesystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Saksbehandler implements KapasitetLytter {
  private List<Pasient> pasientKoe = new ArrayList<>();
  private Sykehus sykehus;


  public Saksbehandler(Sykehus sykehus) {
    this.sykehus = sykehus;
    sykehus.leggTilLytter(this);
  }

  public void pasientAnkommet(Pasient p) {
    if (!sykehus.leggInnPasient(p)) {
      pasientKoe.add(p);
    }
  }

  public void pasientForlatt(Pasient p) {
    sykehus.skrivUtPasient(p);
  }

  @Override
  public void kapasitetEndret(Sykehus sykehus) {
    Collection<Pasient> midlertidigKoe = new ArrayList<>(pasientKoe);
    pasientKoe.clear();

    Iterator<Pasient> it = midlertidigKoe.iterator();

    while (it.hasNext()) {
      Pasient aktuellPasient = it.next();

      if(sykehus.leggInnPasient(aktuellPasient)) {
        it.remove();
      }
    }
    pasientKoe.addAll(midlertidigKoe);
  }

  public void printKoe() {
    System.out.println("Fortsatt i kø: ");
    for (Pasient p : pasientKoe) {
      System.out.println(p.getNavn() + ", " + p.hentPrioritet());
    }
  }

  @Override
  public String toString() {
    return 
      new StringBuilder()
      .append(Farge.gul("- - - - - - - - - - Saksbehandler start - - - - - - - - - -") + "\n")
      .append(Farge.groenn("Pasienter på avdeling: ") + "\n")
      .append(sykehus.getAvdelinger().stream().map(Avdeling::toString).collect(Collectors.joining("\n\n")) + "\n\n")
      .append(Farge.blaa("Resterende kø: ") + "\n")
      .append(
        pasientKoe
        .stream()
        .map(p -> String.format("%s (%s)", p.getNavn(), p.hentPrioritet()))
        .collect(Collectors.joining("\n"))
      )
      .append(Farge.gul("\n- - - - - - - - - - Saksbehandler slutt - - - - - - - - - -") + "\n")
      .toString();
  }
}