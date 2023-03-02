public class FinancialEvent{
    private int freq;
    private String date;
    private String task;
    
    public FinancialEvent(int f, String d, String t){
        this.freq = f;
        this.date = d;
        this.task = t;
    }

    public boolean sameDate(String currdate, String date1){
        String[] splitcurrdate = currdate.split("/");
        String[] splitdate1 = date1.split("/");

        if((splitcurrdate[0]).equals(splitdate1[0]) && (splitcurrdate[1]).equals(splitdate1[1]) && (splitcurrdate[2]).equals(splitdate1[2])){
            return true;
        }
        return false;
    }

    public String toString(){
        return this.date + ": "; 
    }

    public static void main(String[] args){
        FinancialEvent t = new FinancialEvent
    }
}