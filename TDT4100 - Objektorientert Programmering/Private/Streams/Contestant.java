public class Contestant {
  private String firstName;
  private Double time;

  public Contestant(String fName, Double time) {
    this.firstName = fName;
    this.time = time;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param time the time to set
   */
  public void setTime(Double time) {
    this.time = time;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the time
   */
  public Double getTime() {
    return time;
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.getTime();

  }
}