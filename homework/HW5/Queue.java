import java.util.*;

public class Queue{

    Node head;
    Node tail;

    private class Node {
    public String data;
    public Node next;
    public Node(String d, Node n) {
        data = d;
        next = n;
    }
    }

/**
   * adds s to the back of the queue
   */
   
  public void enqueue(String s) {
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
  public String dequeue() {
    String temp;
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

}