public class Car extends Vehicle{
    
    public Car(String type, String model, int mpg) {
        super(type, model, mpg, false, 4);
    }

    public String noise(){
        return "vrooom";
    }

}