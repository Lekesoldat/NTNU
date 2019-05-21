public class Course {
  private String code;
  private double credits = 0;
  private int year;


  public Course(String code) {

  }

  public int getYear() {  ... }

  public char getSemester() { ... }

  /**
   * Gets the time this Course is given, in the format <semester><year>
   * E.g. if the semester is 'S' and the year is 2016,
   * it should return S2016.
   */
  public String getTime() { ... }

  /**
   * Sets the time that this Course is taught. The format is the semester
   * (char) followed by the year. The year may be shortened to two digits;
   * if it is below 50 then 2000 should be added, otherwise 1900.
   * E.g. S16 means Spring 2016, while F86 means Fall 1986.
   * @param time The time in the format <semester><year>
   * @throws IllegalArgumentException if the format is incorrect
   */
  public void setTime(String time) {
          ...
  }
}