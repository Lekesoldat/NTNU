/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Legesystem;

public class App {
  public String getGreeting() {
    return "Hello world.";
  }

  public static void main(String[] args) {
    // Pasienter
    Pasient pasient1 = new Pasient("Ola", "Nordmann");
    Pasient pasient2 = new Pasient("Hong", "Pjong");
    Pasient pasient3 = new Pasient("Ali", "Bang");
    Pasient pasient4 = new Pasient("Martin", "Mongo");
    
    // Legemidler
    Legemiddel legemiddel1 = new Legemiddel("Heroin", 30.0);
    Legemiddel legemiddel2 = new Legemiddel("Xanax", 4.5);
    Legemiddel legemiddel3 = new Legemiddel("2CB", 100.0);
    Legemiddel legemiddel4 = new Legemiddel("Amfetamin", 43.4);
    Legemiddel legemiddel5 = new Legemiddel("Paracetamol", 51.5);
    Legemiddel legemiddel6 = new Legemiddel("Nesespray", 15.0);

    // Leger
    Lege lege1 = new Lege("Hans", "Hansen");
    Lege lege2 = new Lege("Klara", "Bruhn");

    // Blåresepter
    Resept blaaResept1 = new BlaaResept(lege1, pasient1, legemiddel1, 555.0, 3);
    Resept blaaResept2 = new BlaaResept(lege1, pasient1, legemiddel2, 100.0, 5);
    Resept blaaResept3 = new BlaaResept(lege2, pasient3, legemiddel2, 4.20, 10);
    Resept blaaResept4 = new BlaaResept(lege2, pasient3, legemiddel3, 50.0, 10);
    Resept blaaResept5 = new BlaaResept(lege2, pasient4, legemiddel4, 11.1, 1);

    // Hvite resepter
    Resept hvitResept1 = new HvitResept(lege2, pasient1, legemiddel5, 5.0, 100);
    Resept hvitResept2 = new HvitResept(lege2, pasient2, legemiddel6, 90.0, 5);
    
    lege1.leggTilPasient(pasient1, pasient2, pasient3, pasient4);
  
    System.out.println(lege1);
    System.out.println(" - - - - - - - - - - - - - - \n");
    System.out.println(pasient1);
  }
}
