package PrePlaced.Stack_Queue_Heap.Stack_Queue;

public class A01_StackFromArray {
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

  public static class Stack {
    int top = -1;
    int size = 0;
    int[] arr = new int[1000];
    
    void push(int item){
      arr[++top] = item;
      size++;
    }

    int pop(){
      size--;
      return arr[top--];
    }

    int getSize(){
      return size;
    }
    int peek(){
      return arr[top];
    }
  }
}
