package Stack;

import java.util.Stack;
import java.util.Arrays;

public class StockSpan {

  public static void main(String args[]){
    int stockPrices[] = new int[]{100, 80, 60, 70, 60, 75, 85}; 
    int[] stockSpan = calculateSpan(stockPrices, stockPrices.length);
    System.out.println("Span of stocks: "+ Arrays.toString(stockSpan));
  }
  
  /* Solution 1: using stack
   * 
   * Storing each price of stack and comparing it with top element of existing stack
   */
  public static int[] calculateSpan(int price[], int n)
  {
    int[] stockSpan = new int[n];
    Stack<Integer> stack = new Stack<Integer>();
    
    for(int i=0; i<n; i++){
        int span = 1;
        while(!stack.empty() && price[stack.peek()] <= price[i]){
            span += stockSpan[stack.pop()];
        }
        stockSpan[i] = span;
        stack.push(i);
    }
    return stockSpan;
  }
}
