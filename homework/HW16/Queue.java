import java.util.*;

public class Queue {
  String[] arr = new String[1024];
  private int head = 0;  
  private int tail = 0;

  public void enqueue(String s) {
    if( arr[head] == null ) {
      arr[head] = s;
    } else {
      this.tail++;
      arr[tail] = s;
    }
  }

  public String dequeue() {
    String t = arr[head];
    this.head++;

    if( arr[head] == null ) {
      tail = head;
    }
    return t;
  }

  public boolean empty() {
    return arr[head] == null;
  }

  public Iter iterator() {
    return new Iter(arr,head);
  }

  protected class Iter {
    private String[] arr;
    private int curr;
    public Iter(String[] arr, int start) {
      this.arr = arr;
      curr = start;
    }

    public boolean hasNext() {
      return arr[curr] != null;
    }

    public String next() {
      String s = arr[curr];
      curr++;
      return s;
    }
  }

}