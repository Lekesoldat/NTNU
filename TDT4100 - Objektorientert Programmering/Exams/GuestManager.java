/**
 * Handles guests arriving at and departing from a Diner.
 */
public class GuestManager ... {
  
  public GuestManager(Diner diner) {
         ...
  }
  
  /**
  * Handles arriving groups, by either seating them immediately
  * (if possible) or putting them in queue. Those enqueued will
  * be seated when the Diner's (change in) capacity allows.
  * @param group
  */
  public void groupArrived(Group group) {
         ...
  }

  /**
  * Handles departing groups, by removing their seating.
  * @param tableNum the table where the group was seated
  */
  public void groupDeparted(int tableNum) {
         ...
  }

  ...
}