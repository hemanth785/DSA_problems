package PrePlaced.Stack_Queue_Heap.Stack_Queue;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 *
 * Input: 2 1 5 6 2 3
 *
 * Output: 10
 *
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */
public class A10_HistogramProblem {

  /*
   * Solution 1: Bruteforce
   * While iterating over each element in given array,
   * find the continuous number of left and right elements which has equal or grater height thatn current histogram
   * then compute area using : current_height * (left contaguos histograms + right contagious hostograms);
   *
   * Time: O(n^2), Space: O(1)
   */

  /*
   * Solution 2: Efficient-using Stack & Pre calculating left and right smaller elements for each item
   * for each element,
   *  - find the left and right immediate smaller elements in separate array
   *
   * Then calculate area for each histogram using formula
   *    area = curHistoHeight * (nextSmallItemIndex - prevSmallItemIndex - 1);
   *
   * Time: O(n), Space: O(n)
   */
  
  public int largestRectangleArea1(int[] heights) {
    if(heights.length == 0){
      return heights[0];
    }
    int n = heights.length;

    int nextSmallItem[] = new int[n];
    int prevSmallItem[] = new int[n];

    Arrays.fill(nextSmallItem, n);
    Arrays.fill(prevSmallItem, -1);

    //find next small elements for each item
    Stack<Integer> stack = new Stack<>();
    for(int i=0; i<n; i++){
      while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
        nextSmallItem[stack.pop()] = i;
      }
      stack.push(i);
    }

    //find prev small elements for each item
    stack = new Stack<>();
    for(int i=n-1; i>=0; i--){
      while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
        prevSmallItem[stack.pop()] = i;
      }
      stack.push(i);
    }
    
    //calculate area
    int maxArea = 0;
    for(int i=0; i<n; i++){
      int area = heights[i] * (nextSmallItem[i] - prevSmallItem[i] -1);
      maxArea = Math.max(area, maxArea);
    }

    return maxArea;
  }

  /*
   * Solution 3: Most efficient - Without pre calculating next and prev smaller elements
   * - We know that, while traversing left to right, we can get the prevSmallItem for each item, 
   *    but we have to figure out, how can we find next small item
   * 
   * - One technique we can use is, instead of calculating area for each histogram while traversing each item,
   *    - we can calculate area while removing the item from stack
   * 
   * Steps:
   * - keep adding item to stack, while checking condition, if curHeight is less than stack.top() item height
   * - If above condition satisfies, then we know that - for stack top item, current item is the next small item
   * - prev small item for stack top item is, next item in the stack
   * 
   * Since we are getting both next small and prev small for each item, then we can calculate area using formula
   *    curHistoHeight = stack.pop()
   *    area = curHistoHeight * (nextSmallItemIndex - prevSmallItemIndex - 1);
   * 
   * Note: we need to run our loop till, size n, instead of n-1
   */
  public int largestRectangleArea2(int[] heights) {
    if(heights.length == 0){
      return heights[0];
    }

    int n = heights.length;
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();

    stack.push(0);

    for(int i=1; i<=n; i++){
      while(!stack.isEmpty() && (i==n || heights[i] < heights[stack.peek()])){
        int cur = stack.pop();

        int nextSmallIndex = i;
        int prevSmallIndex = stack.isEmpty() ? -1 : stack.peek();
        int area = heights[cur] * (nextSmallIndex - prevSmallIndex - 1);

        maxArea = Math.max(maxArea, area);
      }

      stack.push(i);
    }

    return maxArea;
  }
}
