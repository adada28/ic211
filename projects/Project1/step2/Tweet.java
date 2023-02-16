public class Tweet{
    private String nt;
    private String nuser;
    private String[] ndate;
    public Tweet(String newtext, String newuser, String newdate){
        this.nt = newtext;
        this.nuser = newuser;
        this.ndate = newdate.split("-");
    }

    public String toString(){
        return this.nt + "\t" + '[' + this.nuser + ']' + "\t" + Integer.parseInt(this.ndate[1]) + '/' + Integer.parseInt(this.ndate[2]) + '/' + Integer.parseInt(this.ndate[0]);
    }

    public static void main(String[] args){
        Tweet test = new Tweet("hi", "aed28", "1-30-2013");
        System.out.println(test.toString());
    }
}