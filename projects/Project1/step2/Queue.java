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
        this.tail.next = temp;
        this.tail = this.tail.next;
    }

  }
  
  /**
   * removes and returns string from the front of the queue
   */
  public Tweet dequeue() {
    Tweet temp;
    temp = this.head.data;
    this.head = this.head.next; 
    return temp;
  }

  /**
   * returns true if the queue is empty
   */
  public boolean empty() {
    return (this.head == null);
  }

  public void printAll(Queue Q){
    while(!Q.empty()){
        Tweet nextup = Q.dequeue();
        System.out.println(nextup.toString());
    }
  }

  public int length(){
    //int tweetamt = 0;
    if( this.head != null){
        this.tweetamt++;
    }

    return this.tweetamt;
  }

}