public class Motorcycle extends Vehicle{
    
    public Motorcycle(String type, String model, int mpg) {
        super(type, model, mpg, false, 2);
    }

    public String noise(){
        return "errrrm";
    }

}