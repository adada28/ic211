import java.util.*;

public class Queue{
    private int tweetamt = 0;
    Node head;
    Node tail;

    private class Node {
    public Tweet data;
    public Node next;
    public Node(Tweet d, Node n) {
        data = d;
        next = n;
    }
    }

/**
   * adds s to the back of the queue
   */
   
  public void enqueue(Tweet s) {
    Node temp = new Node(s, null);

    if(this.head == null){
        this.head = temp;
        this.tail = this.head;
    }
    else{
        //this.printAll();
        this.tail.next = temp;
        this.tail = this.tail.next;
        
    }
    this.tweetamt++;

  }
  
  /**
   * removes and returns string from the front of the queue
   */
  public Tweet dequeue() {
    Tweet temp;
    temp = this.head.data;
    this.head = this.head.next; 
    this.tweetamt--;
    return temp;
  }

  /**
   * returns true if the queue is empty
   */
  public boolean empty() {
    return (this.head == null);
  }

  public void printAll(){
    Node curr = this.head;
    while(curr != null){
        //Tweet nextup = this.dequeue();
        System.out.println(curr.data.toString());
        curr = curr.next;
    }
  }

  public Queue filterForKeyword(String keyword){
    Queue keyQ = new Queue();
    Node curr = this.head;
    //String tweetstr = Q.head.data.getnt();
    while(curr != null){
      
      if(curr.data.containsKeyword(keyword)){
        //System.out.println(curr.data.toString());
        keyQ.enqueue(curr.data);
        
      }
      //Q.head = Q.head.next;
      curr = curr.next;
    }

    return keyQ;

  }

    public Queue filterForNotKeyword(String keyword){
    Queue notkeyQ = new Queue();
    Node curr2 = this.head;
    while(curr2 != null){
      if(!(curr2.data.containsKeyword(keyword))){
        notkeyQ.enqueue(curr2.data); 
      }
      curr2 = curr2.next;
    }
    return notkeyQ;    
  }

  public int length(){
    return this.tweetamt;
  }

}