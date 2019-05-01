package src;
public class Medicament {
  private static int medCount = 0;
  private final int medicamentID;

  private String name;
  private Double price;

  public Medicament(String name, double price) {
    this.name = name;
    this.price = price;
    this.medicamentID = medCount++;
  }
  
  public String getName() {
    return this.name;
  }

  public Double getPrice() {
    return this.price;
  }

  public int getMedID() {
    return this.medicamentID;
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("Medicament ID: " + this.medicamentID + "\n")
      .append("Name: " + this.name + "\n")
      .append("Price: " + this.price + "\n")
      .toString();
  }
}