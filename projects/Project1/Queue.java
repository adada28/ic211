import java.util.*;

/** 
  * This class deals with the Queue. This is where Queue are edited based 
  * on user input in Serach.java. The Queue is linked list make of a node 
  * with Tweet (data) and another Node (next).
  *
  * Attened MGSP with 2/C Reimann on Feb 12, 2023 to help with debugging and organizing 
  * my filterForKeyword method
  * @author Dada, Ayoo
  */
public class Queue{
    private int tweetAmt = 0;
    Node head;
    Node tail;

/**
  * Node class with a node constructor that sets data and next values
  * 
 */
    private class Node {
    public Tweet data;
    public Node next;
    public Node(Tweet d, Node n) {
        data = d;
        next = n;
    }
    }

/**
   * adds Tweet s to the back of the queue
   * @param Tweet s which is the data value in the queue 
   * @return void
   */
  public void enqueue(Tweet s) {
    Node temp = new Node(s, null);

    if(this.head == null){
        this.head = temp;
        this.tail = this.head;
    }
    else{
        this.tail.next = temp;
        this.tail = this.tail.next;
        
    }
    this.tweetAmt++;
  }
  
  /**
   * Removes and returns Tweet from the front of the queue
   * @return Tweet with new head to take away original front 
   */
  public Tweet dequeue() {
    Tweet temp;
    temp = this.head.data;
    this.head = this.head.next; 
    this.tweetAmt--;
    return temp;
  }

  /**
   * Checks if a Queue is empty
   * @return true if Queue is empty and false if not
   */
  public boolean empty() {
    return (this.head == null);
  }

  public void printAll(){
    Node curr = this.head;
    while(curr != null){
        System.out.println(curr.data.toString());
        curr = curr.next;
    }
  }

/**
  * Method that traverses through Queue and sees if it contains a user 
  * given String (keyword).
  * @param string keyword that the user inputs from Search.java
  * @return New Queue with Nodes that only contain the keyword 
  */
  public Queue filterForKeyword(String keyword){
    Queue keyQ = new Queue();
    Node curr = this.head;
    while(curr != null){
      
      if(curr.data.containsKeyword(keyword)){
        keyQ.enqueue(curr.data);
      }
      curr = curr.next;
    }
    return keyQ;
  }

/**
  * Method that traverses through the Queue and sees if it does not contains a user 
  * given String (keyword).
  * @param string keyword that the user inputs from Search.java
  * @return New Queue with Nodes that do not contain the keyword 
  */
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

/**
  * Method that traverses through and see if a Tweet was posted on user 
  * given date (date).
  * @param string date that the user inputs from Search.java
  * @return New Queue with Nodes that only contain Tweets from inputted date 
  */
  public Queue filterForDate(String date){
    Queue dateQ = new Queue();
    Node curr = this.head;
    while(curr != null){
      if(curr.data.containsDate(date)){
        dateQ.enqueue(curr.data);
      }
      curr = curr.next;
    }
    return dateQ;
  }

/**
  * @return int of the size of Queue which is needed in Search.java program
  */
  public int length(){
    return this.tweetAmt;
  }

}