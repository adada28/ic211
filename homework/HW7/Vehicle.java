public class Vehicle {
  private String type;  // truck, car, motorcycle, plane
  private String model;
  private int mpg, numWheels;
  private boolean canfly;

  public Vehicle(String type, String model, int mpg, boolean canfly, int numWheels) {
    this.type = type;
    this.model = model;
    this.mpg = mpg;
    this.canfly = canfly;
    this.numWheels = numWheels;
  }

  public boolean doesItFly() { return canfly; }

  public String noise() {
      return noise();
  }

  public String toString() {
    return model + " " + noise() + " does" + (doesItFly() ? "" : " not") + " fly with " + numWheels + " wheels.";
  }
}
