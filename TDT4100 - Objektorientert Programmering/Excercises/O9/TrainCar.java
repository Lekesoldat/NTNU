package inheritance;

public class TrainCar {
  protected int totalWeight, deadWeight;

  public TrainCar(int deadWeight) {
    this.deadWeight = deadWeight;
    this.totalWeight = deadWeight;
  }

  /**
   * @param totalWeight the totalWeight to set
   */
  protected void setTotalWeight(int totalWeight) {
    this.totalWeight = totalWeight;
  }

  /**
   * @param deadWeight the deadWeight to set
   */
  public void setDeadWeight(int deadWeight) {
    this.deadWeight = deadWeight;
  }
  
  /**
   * @return the deadWeight
   */
  protected int getDeadWeight() {
    return deadWeight;
  }

  /**
   * @return the totalWeight
   */
  protected int getTotalWeight() {
    return totalWeight;
  }

  
  protected int getPassengerCount() {
    return 0;
  }

  protected int getCargoWeight() {
    return 0;
  }
}