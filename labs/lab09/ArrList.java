import java.util.*;
@SuppressWarnings("unchecked")

/**
  * The ArrList class is meant to serve as a copycat class 
  * of Java's ArrayList class.
  * Attended MGSP with 2/C Shannon Clancy for guidance 
  * @author Ayoo Dada
  */
public class ArrList<T> implements Iterable<T>{
    //initializing variables 
    private int size; 
    private Object arr[];
    private int numElements = 0;
    
    /**
      * Constructor for the ArrList
     */
    public ArrList(){
        this.size = 10;
        this.arr = new Object[size];
    }

    /**
      * Add method that adds an object to the array list
      * @param T d
      * @return void
     */
    public void add(T d){
        if(this.numElements+1 >= this.size){
            Object[] temparray = arr;
            size = size*2;
            arr = new Object[size];
            for(int i = 0; i < temparray.length; i++){
                arr[i] = temparray[i];
            } 
        }        

        arr[numElements] = d;
        numElements++;

    }

    /**
      * Removes first occurence of specified element from list, if present
      * @param T d 
      * @return true if element is in list 
     */

    public boolean remove(T d){
        for(int i = 0; i < size; i++){
            if(d.equals(arr[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator(){
        return new iterator<T>();
    }

    /**
      * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
      * @param index 
      * @return T 
      */
    public T remove(int index) throws IndexOutOfBoundsException{
        T save = (T)(arr[index]);
        if(index > numElements || index < 0){
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        if(index == numElements-1){
            numElements--;
        }
        else{
            for(int j = index; j < size; j++){
                arr[index] = arr[index+1];
            }
        }
        return save;
    }

    /**
      * Returns the element at the specified position in this list.
      * @param index 
      * @return element at specific position in list
     */
    public T get(int index){
        return (T)arr[index];
    }

    /**
      * Returns num of elements in list
      * @return int 
     */
    public int size(){
        return numElements; 
    }

   
    protected class iterator<T> implements Iterator{
        //private String[] arr;
        private int curr;
        public iterator() {
            curr = 0;
        }

        public boolean hasNext() {
            return arr[curr] != null;
        }

        public T next() {
            T temp = (T) arr[curr];
            curr++;
            return temp;
        }
    }

    public static void main (String[] args){
        ArrList<String> cars = new ArrList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        for(int i = 0; i < cars.size; i++){
            System.out.println(cars.get(i));
        }      
    }

}