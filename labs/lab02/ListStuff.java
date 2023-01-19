public class ListStuff{
    // addToFront(s,Nold) returns a StringNode reference representing the list obtained by adding s to the front of list Nold
    public static StringNode addToFront(String s, StringNode Nold) {
        StringNode node = new StringNode();
        node.data = s;
        node.next = Nold;
        return node;
    }

    // listToArray(N) returns a reference to an array containing the same strings
    //as in the list N (in the order they were received)
    public static String[] listToArray(StringNode N){
        StringNode temp = N;
        int count = 0;
        while(temp.next != null){
            count++;
            temp = N.next;
        }
        String[] words = new String[count];
        for(int i = 0; i < count; i++){
            words[i] = N.data;
            N = N.next; 
        }
        return words;
    }

    public static void main(String[] args){
        StringNode N = null;      // at this point N *is* an empty list
        N = addToFront("rat",N);  // at this point N *is* the list ("rat")
        N = addToFront("dog",N);  // at this point N *is* the list ("dog","rat")
        N = addToFront("pig",N);  // at this point N *is* the list ("pig","dog","rat")
        String[] A = listToArray(N);
        for(int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }    

    }
    
}