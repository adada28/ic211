public class Midshipman{
    public String alpha;
    public String lastn;
    public String firstn;
    private double speed;
    private double strength;
    private double intelligence;
    private double heart;

    public Midshipman(String al, String last, String first, double s, double strong, double intel, double h){
        this.alpha = al;
        this.lastn = last;
        this.firstn = first;
        this.speed = s;
        this.strength = strong;
        this.intelligence = intel;
        this.heart = h;
    }

    public double getAbility(){
        return ((this.speed * 0.3) + (this.strength * 0.2) + (this.intelligence * 0.4) + (this.heart * 0.1));
    } 
    
    public String toString(){
        return "Winner: " + this.alpha + ": " + this.lastn + ", " + this.firstn;
    }

    public boolean willBeat(Midshipman x){
        if(this.getAbility() > x.getAbility()){
            return true;
        }
        
        return false;
    } 
}