package inheritance;

/**
 * CargoCar
 */
public class CargoCar extends TrainCar{
  private int cargoWeight;
  
  public CargoCar(int emptyWeight, int cargoWeight) {
    super(emptyWeight);
    super.setTotalWeight(emptyWeight + cargoWeight);
    this.cargoWeight = cargoWeight;
  }

  public void setCargoWeight(int n) {
    this.cargoWeight = n;
    super.setTotalWeight(super.getDeadWeight() + n);
  }

  @Override
  public int getCargoWeight() {
    return this.cargoWeight;
  }
}