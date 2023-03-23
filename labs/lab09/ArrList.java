import java.util.*;
public class ArrList<T> implements Iterable<T>{
    private int size; 
    private Object arr[];
    private int numElements = 0;
    
    public ArrList(){
        this.size = 10;
        this.arr[] = new Object[size];
    }
    public void add(T d){

        this.numsElements++;
        this.size++;
    }

    public boolean remove(T d){

    }

    public Iterator<T> iterator(){

    }

    public T remove(int index){

        this.numElements--;
        thus.size--;
    }

    public T get(int index){

    }

    public int size(){
        return this.size; 
    }

    public class Iter implements Iterator<T>{

    }

}