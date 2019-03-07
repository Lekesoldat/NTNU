package inheritance;

/**
 * PassengerCar
 */
public class PassengerCar extends TrainCar {
  private final int passengerWeight = 80;
  private int passengers;

  public PassengerCar(int emptyWeight, int passengers) {
    super(emptyWeight);
    super.setTotalWeight(emptyWeight + passengers * passengerWeight);

    this.passengers = passengers;
  }

  @Override
  public int getPassengerCount() {
    return this.passengers;
  }

  public void setPassengerCount(int n) {
    this.passengers = n;
    super.setTotalWeight(super.getDeadWeight() + n * this.passengerWeight);
  }
}