package interfaces;

/**
 * Person1
 */
public class Person1 implements Named {
  private String givenName, familyName;

  public Person1(String givenName, String familyName) {
    this.givenName = givenName;
    this.familyName = familyName;
  }

  @Override
  public void setGivenName(String s) {
    this.givenName = s;
  }

  @Override
  public String getGivenName() {
    return this.givenName;
  }

  @Override
  public void setFamilyName(String s) {
    this.familyName = s;
  }

  @Override
  public String getFamilyName() {
    return this.familyName;
  }

  @Override
  public void setFullName(String s) {
    String[] parts = s.split(" ");
    this.givenName = parts[0];
    this.familyName = parts[1];
  }

  @Override
  public String getFullName() {
    return this.givenName + " " + this.familyName;
  }
}