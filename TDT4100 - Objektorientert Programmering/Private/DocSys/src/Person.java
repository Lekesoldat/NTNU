package src;
public abstract class Person {
  // Social security number
  private static int ssnCounter = 0;

  private String name;
  private int age;
  private final int ssn;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    this.ssn = ssnCounter++;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public int getSSN() {
    return this.ssn;
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append(Colors.ANSI_BLUE + "Personal info: \n" + Colors.ANSI_RESET)
      .append("SSN: " + this.ssn + "\n")
      .append("Name: " + this.name + "\n")
      .append("Age: " + this.age + "\n")
      .toString();
  }

  public abstract String allString();
}