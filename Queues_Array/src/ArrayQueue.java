import java.util.Scanner;

interface IQueue {
    /*** Inserts an item at the queue front.*/
    public void enqueue(Object item);
    /*** Removes the object at the queue rear and returnsit.*/
    public Object dequeue();
    /*** Tests if this queue is empty.*/
    public boolean isEmpty();
    /*** Returns the number of elements in the queue*/
    public int size();
}

public class ArrayQueue implements IQueue {
    int size = 100;
    int [] arrQueue = new int[size];
    int [] holderQueue = new int [size];
   int f = -1;
   int r = -1;
   int count = 0;


   public void enqueue (Object item){
       if (count == size -1) {
           System.out.println("Error");
       }
       else{
           if (count == 0)
               f = r = 0;
           arrQueue[r] = (Integer) item;
           r = (r+1)%size;
           count ++;
       }
   }
    public Object dequeue(){
       if (count != 0){
           int target = arrQueue[f];
           f =  (f+1)%size;
           count --;
           return target;
       }
       else
           return null;
   }

    public boolean isEmpty(){
       return (f == r);
    }

    public int size(){
       return ( (size - f + r)%size );
    }

    public void show(){
       int i = 0;
       int currentSize = size();
       if (currentSize == 0)
           System.out.println("[]");
       else{
           for (i = currentSize-1; i >= 0; i--){
               holderQueue[i] = (int)dequeue();
           }
           System.out.print("[");
           for (i = currentSize-1; i > 0; i--){
               System.out.print(holderQueue[currentSize-1-i] + ", ");
           }
           System.out.print(holderQueue[currentSize-1-i]);
           System.out.println("]");
       }
    }

    public static void main(String[] args) {
       ArrayQueue obj = new ArrayQueue();
        Scanner myScan = new Scanner(System.in);
        String input = myScan.nextLine();//Takes the input from user in the defined format
        String in = input.substring(1, input.lastIndexOf(']'));
        //If the input is [], then it skips the next steps, leaving an empty list
        if (input.equals("[]"))
        {
        }
        else {//If the list is not empty, it processes it to build the list
            String[] array = in.split(", ");
            int[] integerArray = new int[array.length];

            for (int i = 0; i < array.length; i++) {
                integerArray[i] = Integer.parseInt(array[i]);
            }
            for (int i = array.length - 1; i >= 0; i--) {
                obj.enqueue(integerArray[i]);
            }
        }
        String command = myScan.next();
        switch (command) {
            case "enqueue":
                int element = myScan.nextInt();
                obj.enqueue(element);
                obj.show();
                break;
            case "dequeue":
                if(obj.dequeue() != null)
                    obj.show();
                else
                    System.out.println("Error");
                break;
            case "isEmpty":
                if (obj.isEmpty())
                    System.out.println("True");
                else
                    System.out.println("False");
                break;
            case "size":
                System.out.println(obj.size());
                break;
            default:
                System.out.println("Error");
        }

    }
}