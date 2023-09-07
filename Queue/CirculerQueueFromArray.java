package Queue;

/*
 * Implement circular queue using array datastructure
 * 
 * Solution: As we know, for queue, item will be added from one end and and removed from another end
 * When implementing Circular queue, we should be able add and remove element continuosly, if queue size reaches max
 * 
 * For that, the front and rear index always will be modulo of size of queue
 * 
 * */
public class CirculerQueueFromArray {

  public static class Queue {
    int front = 0;
    int rear = -1;
    int size = 0;
    int capacity = 0;
    int[] arr;
    
    Queue(int capacity){
      arr = new int[capacity];
      this.capacity = capacity;
    }
    
    void enqueue(int item){
      if(size >= capacity){
        System.out.println("Queue is full");
        return;
      }
      rear = (rear+1)%capacity;
      arr[rear] = item;
      size++;
    }

    int dequeue(){
      if(size <= 0){
        System.out.println("Queue is empty");
        return -1;
      }
      int item = arr[front];
      front = (front+1)%capacity;
      size--;
      return item;
    }

    int peek(){
      if(size <= 0){
        System.out.println("Queue is empty");
        return -1;
      }
      return arr[front];
    }

    int size(){
      return size;
    }

    boolean isEmpty(){
      return size == 0;
    }
  }
  public static void main(String args[]){
    Queue queue = new Queue(3);

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    System.out.println("peek: "+queue.peek());
    System.out.println("dequeue: "+queue.dequeue());
    System.out.println("peek: "+queue.peek());

    queue.enqueue(4);
    queue.enqueue(5);

    System.out.println("peek: "+queue.peek());
    System.out.println("dequeue: "+queue.dequeue());
    System.out.println("peek: "+queue.peek());

    queue.enqueue(5);
    System.out.println("peek: "+queue.peek());
    
  }

  
}
