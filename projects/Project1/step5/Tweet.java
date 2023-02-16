public class Tweet{
    private String nt;
    private String nuser;
    private String[] ndate;
    public Tweet(String newtext, String newuser, String newdate){
        this.nt = newtext;
        this.nuser = newuser;
        this.ndate = newdate.split("-");
    }

    public String getnt(){
        return this.nt;
    }
    public String toString(){
        return this.nt + "\t" + '[' + this.nuser + ']' + "\t" + Integer.parseInt(this.ndate[1]) + '/' + Integer.parseInt(this.ndate[2]) + '/' + Integer.parseInt(this.ndate[0]);
    }

    public boolean containsKeyword(String keyword){
        String [] sentenceSplit= this.nt.split(" ");
        int size = sentenceSplit.length;
        for(int i = 0; i < size; i++){
            String oneword = sentenceSplit[i].toLowerCase();
            if(oneword.contains(keyword.toLowerCase())){
                return true;
            }         
        }
        return false;
    }

    public boolean containsDate(String date){
        String[] splitdate = date.split("-");
        return ((Integer.parseInt(this.ndate[0]) == Integer.parseInt(splitdate[0])) && (Integer.parseInt(this.ndate[1]) == Integer.parseInt(splitdate[1])) && (Integer.parseInt(this.ndate[2]) == Integer.parseInt(splitdate[2])));
    }

    public static void main(String[] args){
        Tweet test = new Tweet("hi what are you doing", "aed28", "1-30-2013");
        System.out.println(test.toString());

        if(test.containsKeyword("what")){
            System.out.println("true");
        }
    }
}