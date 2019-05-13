package Legesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sykehus {
  private List<Avdeling> avdelinger = new ArrayList<>();
  private List<KapasitetLytter> lyttere = new ArrayList<>();
  private List<Helsearbeider> helsepersonell = new ArrayList<>(
    List.of(
      new Lege("Hans", "Hansen"),
      new Lege("Klara", "Klok")
    )
  );

  public void leggTilAvdeling(Avdeling ... avd) {
    for (Avdeling avdeling : avd) {
      avdelinger.add(avdeling);
    }
  }

  public void leggTilLytter(KapasitetLytter kp) {
    lyttere.add(kp);
  }

  public void fjernLytter(KapasitetLytter kp) {
    lyttere.remove(kp);
  }

  public void invokeKapasitetEndret() {
    lyttere.forEach(kp -> kp.kapasitetEndret(this));
  }

  public boolean leggInnPasient(Pasient p) {
    for (Avdeling avd : avdelinger) {
      if (avd.getPrioritetsNivå() == p.hentPrioritet() ) {
        if (avd.plasserISeng(p)) {
          invokeKapasitetEndret();
          return true;
        }
      }
    }
    return false;
  }

  public boolean skrivUtPasient(Pasient p) {
    for (Avdeling avd : avdelinger) {
      if (avd.fjernFraSeng(p)) {
        invokeKapasitetEndret();
        return true;
      }
    }
    return false;
  }

  public List<Helsearbeider> getHelsepersonell() {
    return helsepersonell;
  }

  public List<Avdeling> getAvdelinger() {
    return avdelinger;
  }

  @Override
  public String toString() {
    return
      new StringBuilder()
      .append(Farge.gul("- - - - - - - - - - Sykehus start - - - - - - - - - -") + "\n")
      .append(Farge.groenn("Alt helsepersonell: ") + "\n")
      .append(
        helsepersonell
        .stream()
        .map(h -> (h.getTittel() + ": " + h.getNavn()))
        .collect(Collectors.joining("\n"))
      )
      .append(Farge.groenn("\n\nAvdelinger: ") + "\n")
      .append(avdelinger.stream().map(Avdeling::toString).collect(Collectors.joining("\n\n")))
      .append(Farge.gul("\n- - - - - - - - - - Sykehus slutt - - - - - - - - - -") + "\n")
      .toString();
  }
}