public class Exam1{
    public static void main(String[] args){
        int midnum = args.length/4;
        int count = 0;
        Midshipman[] boxers = new Midshipman[midnum];
        for(int i = 0; i < midnum; i++){
            double tempspeed = Double.parseDouble(args[count]);    
            count++;
            double tempstrength = Double.parseDouble(args[count]);
            count++;
            double tempintel = Double.parseDouble(args[count]);
            count++;
            double tempheart = Double.parseDouble(args[count]);
            count++; 
            Midshipman tempmid = new Midshipman(tempspeed,tempstrength,tempintel,tempheart);
            boxers[i] = tempmid;                         
        }
        Midshipman best = boxers[0];
        for(int j = 1; j < midnum; j++){
            if(best.getAbility() < boxers[j].getAbility()){
                best = boxers[j];      
            }
        }

        System.out.println(best.toString());
         
    }
}