public class Truck extends Vehicle{
    
    public Truck(String type, String model, int mpg) {
        super(type, model, mpg, false, 4);
    }

    public String noise(){
        return "bumbumbum";
    }

}