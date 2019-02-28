package Midtsemesterforelesning;

public class Location {
  private int x, y, id;
  private static int idCounter;

  public Location(int x, int y, int maxX, int maxY) {
    this.id = idCounter++;

    // Y in bounds
    if (isBetween(x, 0, maxX)) {
      this.x = x;
    } else {
      throw new IllegalArgumentException("x must be between 0 and maxX");
    } 

    // Y in bounds
    if (isBetween(y, 0, maxY)) {
      this.x = y;
    } else {
      throw new IllegalArgumentException("y must be between 0 and maxY");
    }

    // Positive numbers
    if (isPositive(x) && isPositive(y)) {
      this.x = x;
      this.y = y;
    } else {
      this.x = 0;
      this.y = 0;
    }
  }

  // Public methods
  public void up() {
    this.y -= 1;
  }

  public void down() {
    this.y += 1;
  }
  
  public void left() {
    this.x -= 1;
  }
  
  public void right() {
    this.x += 1;
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }

  public int getID() {
    return this.id;
  }

  public boolean isPositive(int number) {
    return number >= 0;
  }

  public boolean isBetween(int number, int lower, int upper) {
    return number >= lower && number <= upper;
  }

  public static boolean isLocation(Location l) {
    return l instanceof Location;
  }
  
  @Override
  public String toString() {
    return String.format("(%d, %d)", this.x, this.y);
  }
}