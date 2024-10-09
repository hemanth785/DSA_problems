package PrePlaced.Stack_Queue_Heap.Stack_Queue;

import java.util.Stack;

/*
 * Link: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 */
public class A06_Next_greater_element_on_right {
  public static long[] nextLargerElement(long[] arr, int n)
    { 
        long nextGreater[] = new long[n];
        for(int i=0; i<n; i++){
            nextGreater[i] = -1;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                nextGreater[stack.pop()] = arr[i];
            }
            
            stack.push(i);
        }
        
        return nextGreater;
    } 
}
