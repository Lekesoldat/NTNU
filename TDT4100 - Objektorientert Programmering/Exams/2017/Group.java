/**
 * A group (of people) dining together, and should be seated at the same table.
 * We currently only need to handle the size.
 */
public class Group {
  private int guestCount = 0;
  /**
  * Initializes this Group with the provided guest count
  */
  public Group(int guestCount) {
    this.guestCount = guestCount;
  }

  public int getGuestCount() {
    return this.guestCount;
  }

  
}