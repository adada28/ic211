public class Plane extends Vehicle{
    private int numWheels;
    
    public Plane(String type, String model, int mpg) {
        super(type, model, mpg, true, 3);
    }

    public String noise(){
        return "woooosh";
    }
}