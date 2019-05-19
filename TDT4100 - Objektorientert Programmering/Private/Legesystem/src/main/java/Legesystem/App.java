/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Legesystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    // Instansierer sykehus, apotek og saksbehandler.
    Sykehus sykehus = new Sykehus();
    Apotek apotek = new Apotek();
    Saksbehandler saksbehandler = new Saksbehandler(sykehus);

    // Oppretter en del pasienter
    List<Pasient> pasienter = new ArrayList<>(
      List.of(
        new Pasient("Ola", "Nordmann"),
        new Pasient("Hong", "Pjong"),
        new Pasient("Ali", "Bang"),
        new Pasient("Martin", "Mongo"),
        new Pasient("Per", "Fylling"),
        new Pasient("Kasper", "Kråke"),
        new Pasient("Roy", "Nav"),
        new Pasient("Kim", "Larsen"),
        new Pasient("Sakki", "Sokk"),
        new Pasient("Reptum", "Anis"),
        new Pasient("Jhonny", "Sebra"),
        new Pasient("Kink", "Dink"),
        new Pasient("Jeg", "Kjeder Meg")
      )
    );

    // Legger til en rekke resepter
    apotek.leggTilResept(
      new BlaaResept(
        (Lege)sykehus.getHelsepersonell().get(0),
        pasienter.get(0),
        apotek.getLegemiddelbank().get(0),
        555.0,
        3
      ),
      new BlaaResept(
        (Lege)sykehus.getHelsepersonell().get(0),
        pasienter.get(0),
        apotek.getLegemiddelbank().get(2),
        100.0,
        5
      ),
      new BlaaResept(
        (Lege)sykehus.getHelsepersonell().get(1),
        pasienter.get(2),
        apotek.getLegemiddelbank().get(1),
        4.20,
        10
      ),
      new BlaaResept(
        (Lege)sykehus.getHelsepersonell().get(1),
        pasienter.get(2),
        apotek.getLegemiddelbank().get(2),
        50.0,
        10
      ),
      new BlaaResept(
        (Lege)sykehus.getHelsepersonell().get(1),
        pasienter.get(3),
        apotek.getLegemiddelbank().get(3),
        11.1,
        1
      ),
      new HvitResept(
        (Lege)sykehus.getHelsepersonell().get(1),
        pasienter.get(0),
        apotek.getLegemiddelbank().get(4),
        5.0,
        100
      ),
      new HvitResept(
        (Lege)sykehus.getHelsepersonell().get(1),
        pasienter.get(1),
        apotek.getLegemiddelbank().get(5),
        90.0,
        5
      )
    );

    // Legg til avdelinger
    sykehus.leggTilAvdeling(
      new Avdeling(5, 0), // Standard
      new Avdeling(5, 1), // Haster
      new Avdeling(5, 2), // Ikke like ille
      new Avdeling(5, 3) // Ikke like ille
    );

    // Gir pasienter tilfeldig prioritet
    for (Pasient p : pasienter) {
      p.setPrioritet(new Random().nextInt(4));
    }
    
    // Forsøer å legge til alle pasienter
    for (Pasient p : pasienter) {
      saksbehandler.pasientAnkommet(p);
    }
    
    // Printing
    System.out.println(sykehus);
    System.out.println(apotek);
    System.out.println(saksbehandler);
  }
}