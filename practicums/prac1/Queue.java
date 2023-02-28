
public class Queue {
  private int midamt = 0;
  private Node front, back;
  
  /**
   * adds s to the back of the queue
   */
  public void enqueue(Midshipman s) {
    Node n = new Node(s, null);
    if( front == null )
      front = back = n;
    else {
      back.next = n;
      back = n;
    }
    this.midamt++;
  }

  /**
   * removes and returns string from the front of the queue
   */
  public Midshipman dequeue() {
    if( front == null )
      return null;
    Midshipman mid = front.data;
    front = front.next;
    this.midamt--;
    return mid;
  }


  /**
   * returns true if the queue is empty
   */
  public boolean empty() {
    return front == null;
  }


  private class Node {
    public Midshipman data;
    public Node next;
    public Node(Midshipman d, Node n) {
      data = d;
      next = n;
    }
  }

  public int length(){
    return this.midamt;
  }

}
