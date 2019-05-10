package Legesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sykehus {
  private List<Helsearbeider> helsepersonell = new ArrayList<>(
    List.of(
      new Lege("Hans", "Hansen"),
      new Lege("Klara", "Klok")
    )
  );

  private List<Pasient> pasienter = new ArrayList<>(
    List.of(
      new Pasient("Ola", "Nordmann"),
      new Pasient("Hong", "Pjong"),
      new Pasient("Ali", "Bang"),
      new Pasient("Martin", "Mongo")
    )
  );


  public List<Helsearbeider> getHelsepersonell() {
    return helsepersonell;
  }

  public List<Pasient> getPasienter() {
    return pasienter;
  }

  @Override
  public String toString() {
    return
      new StringBuilder()
      .append(Farge.gul("Sykehus") + "\n")
      .append(Farge.groenn("Alt helsepersonell: ") + "\n")
      .append(
        helsepersonell
        .stream()
        .map(h -> (h.getTittel() + ": " + h.getNavn()))
        .collect(Collectors.joining("\n"))
      )
      .append(Farge.groenn("\nAlle pasienter:") + "\n")
      .append(
        pasienter
        .stream()
        .map(Pasient::getNavn)
        .collect(Collectors.joining(", "))
      )
      .toString();
  }
}