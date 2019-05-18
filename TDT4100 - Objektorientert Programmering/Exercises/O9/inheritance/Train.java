package inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * Train
 */
public class Train {
  private List<TrainCar> cars;

  public Train() {
    this.cars = new ArrayList<TrainCar>();
  }

  public void addTrainCar(TrainCar t) {
    this.cars.add(t);
  }

  public boolean contains(TrainCar t) {
    return this.cars.contains(t);
  }

  public int getTotalWeight() {
    return cars
      .stream()
      .mapToInt(TrainCar::getTotalWeight)
      .sum();
  }

  public int getPassengerCount() {
    return cars
      .stream()
      .mapToInt(TrainCar::getPassengerCount)
      .sum();
  }

  public int getCargoWeight() {
    return cars
      .stream()
      .mapToInt(TrainCar::getCargoWeight)
      .sum();
  }
}