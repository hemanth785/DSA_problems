package PrePlaced.Stack_Queue_Heap.Stack_Queue;

public class A02_StackFromLL {
  public static class Node {
    int data;
    Node next = null;

    Node() { }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
  }
  public static class Stack {
    int size = 0;
    Node top = null;

    void push(int item){
      Node node = new Node(item);
      if(top == null){
        top = node;
      } else {
        node.next = top;
        top = node;
      }
      size++;
    }

    int pop(){
      Node popItem = top;
      top = top.next;
      size--;
      return popItem.data;
    }

    int peek(){
      return top.data;
    }

    int getSize(){
      return size;
    }
  }

  public static void main(String args[]){
    Stack stack = new Stack();
    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println("Size of stack: "+stack.getSize());
    System.out.println("peek: "+stack.peek());
    System.out.println("pop: "+stack.pop());
    System.out.println("peek: "+stack.peek());
    System.out.println("Size of stack: "+stack.getSize());
  }
}
