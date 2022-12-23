import java.util.Scanner;

public class Queue {
    // Initialize linked list used to implement queue
    SingleLinkedList myList = new SingleLinkedList(null);

    public static void main(String[] args) throws Exception {
        Queue myQueue = new Queue();
        Scanner scan = new Scanner(System.in);
        // Get input array as a string from the user
        String arrList = scan.nextLine();
        // Convert the String to an array of integers
        int[] intArr = myQueue.myList.stringToIntArray(arrList);
        // Convert array of integers to linked list
        myQueue.myList.arrayToList(intArr);
        
        // Put the rest of the program in try catch to print "Error" if any error happens
        try {
            String option = scan.next();
            switch (option) {
                case "enqueue":
                    // Get value to be enqueued
                    int valueToEnqueue = scan.nextInt();
                    // Enqueue the value
                    myQueue.enqueue(valueToEnqueue);
                    // display the queue
                    myQueue.myList.dispList();
                    scan.close();
                    break;

                case "dequeue":
                    break;

                case "isEmpty":
                    if (myQueue.isEmpty()) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "size":
                    break;
                
            
                default:
                    scan.close();
                    // throw runtime exception if user enters invalid command
                    throw new RuntimeException();
            }
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void enqueue(int element){
        Node newElement = new Node(element);
        myList.add(0, newElement);
    }

    public void dequeue() {
        //TODO: implement dequeue
    }

    public boolean isEmpty() {
        return (myList.size() == 0);
    }

    public int size() {
        //TODO: implement size
        return 0;
    }
}
