package src;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class DoctorsOffice {
  List<Medicament> meds = new ArrayList<>(
    List.of(
      new Medicament("Heroin", 13.37),
      new Medicament("Xanax", 100.11),
      new Medicament("Weed", 4.20),
      new Medicament("GHB", 1000.0),
      new Medicament("Opatanol", 55.0)
    ));

  public void saveMedicaments(String path) {
    try (PrintWriter pw = new PrintWriter(new File(path))) {
      meds.forEach(m -> pw.println(
        String.format(
          "%s,%s",
          m.getName(),
          m.getPrice().toString()
        )
      ));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readMedicaments(String path) {
    try (Scanner scanner = new Scanner(new File(path))) {
      meds.clear();

      scanner.useDelimiter(",|\n");
      while (scanner.hasNext()) {
        meds.add(new Medicament(scanner.next(), Double.parseDouble(scanner.next())));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    String path = "./meds.txt";

    DoctorsOffice office = new DoctorsOffice();
    Doctor doc = new Doctor("Dr. Haug", 46);
    Patient magnus = new Patient("Magnus", 21);
    Patient andreas = new Patient("Andreas", 21);

    Prescription heroin = new Prescription(doc, magnus, office.meds.get(0), 5);
    Prescription xanax = new Prescription(doc, magnus, office.meds.get(1), 3);
    Prescription hasjisj = new Prescription(doc, magnus, office.meds.get(2), -1);
    Prescription gbh = new Prescription(doc, andreas, office.meds.get(3), -1);
    Prescription opatanol = new Prescription(doc, andreas, office.meds.get(4), -1);



    System.out.println(doc.allString());
    System.out.println("------------------------\n");
    System.out.println(magnus.allString());
    System.out.println("------------------------\n");
    System.out.println(andreas.allString());

    System.out.println(heroin);
    System.out.println(opatanol);
  }
}