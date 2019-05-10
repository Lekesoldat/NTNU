
/**
 * Interface for listening to changes in Diner capacity
 */
public interface CapacityListener {
  /**
  * Called to inform that a Diner has changed capacity
  * @param diner
  */
  public void capacityChanged(Diner diner);
}