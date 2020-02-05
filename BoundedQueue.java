package ASB180015;
import java.util.*;

public class BoundedQueue<T> {
    Object[] queue;
    int size;  //size of Array
    int qsize; //number of elements in Queue
    int front; //front of queue
    int rear;  //end of queue

    public BoundedQueue( int size ){
        this.queue = new Object[size];
        this.size = size;
        qsize = 0;
        front = -1;
        rear =-1;
    }

    //add a new element at the end of the queue
    public boolean offer (T x){
        if (size == qsize)
            return false;
        else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = x;
            qsize++;
            return true;
        }
    }
      // To return element from front and delete from queue
    @SuppressWarnings("unchecked")
    public T poll(){
        if (isEmpty()) {
            return null;
        }
        else {
            T val = (T) queue[front];
            front = (front + 1) % size;
            qsize--;
            return val;
        }
    }
    public int size(){
          return qsize;
    }

    public boolean isEmpty(){
        return qsize == 0;
    }
    public void clear(){
        qsize =0;
        front =-1;
        rear =-1;
    }

    @SuppressWarnings("unchecked")
    void toArray(T[] a)
    {
        if(qsize == 0)
            System.out.println("Queue is empty");
        if (a.length >= qsize)  // check if user supplied array length is greater than qsize.
        {
            if (!isEmpty())
            {
                for (int i = 0; i < qsize; i++)
                    a[i] = (T) queue[(front + i) % size];

            }
        }
        else System.out.println("User given Array is smaller than Queue size");
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(!isEmpty()) return (T) queue[front];
        else{
            return null;
        }
    }

    public void printQ()
    {
        if (!isEmpty())
        {
            for (int i = 0; i < qsize; i++)
                System.out.print( queue[(front + i) % size] + " ");
        }
        else System.out.println("Queue is Empty");
    }



    public static void main(String[] args)
    {
        BoundedQueue<Integer> queue = new BoundedQueue<>(7);
        Scanner in = new Scanner(System.in);
        System.out.println(" 1.offer  2.poll  3.peek  4.size  5.isEmpty  6.clear  7.toArray 8.printQueue");

        whileloop:
        while(in.hasNext()){
            int opt = in.nextInt();
            switch(opt){
                case 1:// offer - add element at the end of queue
                    System.out.println("Enter number to be added in the queue");
                    int x = in.nextInt();
                    if(queue.offer(x))
                    {
                     queue.printQ();
                    }
                    break;
                case 2:// poll element from the front of the queue
                    System.out.println(queue.poll());
                    break;
                case 3://  peek element at front of the queue
                    System.out.println(queue.peek());
                    break;
                case 4:// check size of the queue
                    System.out.println("Size of the queue is " + queue.size());
                    break;
                case 5:// check if queue is empty
                    System.out.println(queue.isEmpty());
                    break;
                case 6:// clear queue
                    queue.clear();
                    break;
                case 7: // return queue element with user supplied array
                    System.out.println(("Enter size of the Array"));
                     x= in.nextInt();
                    Integer[] a = new Integer[x];
                    queue.toArray(a);
                    for (Integer integer : a) {
                        if (integer != null)
                            System.out.print(integer + " ");
                    }
                     break;
                case 8:
                    queue.printQ();
                    break;
                default:
                    break whileloop;

            }
        }
    }
}