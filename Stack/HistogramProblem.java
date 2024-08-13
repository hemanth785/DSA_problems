package Stack;

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
public class HistogramProblem {

  /*
   * Solution 1: Bruteforce
   * While iterating over each element in given array,
   * find the continuous number of left and right elements which has equal or grater height thatn current histogram
   * then compute area using : current_height * (left contaguos histograms + right contagious hostograms);
   *
   * Time: O(n^2), Space: O(1)
   */

  /*
   * Solution 2: Efficient-using Stack,  (Pre calculating left and right contagious histogram count)
   * for each element,
   *  find the left and right contagious or continuous immidiate greater or equal heights in separate array
   *
   * then while calculating the area of histogram, use those contagious hieght histograms also
   *
   * Time: O(n), Space: O(n)
   */
  
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int leftCont[] = new int[n];
    int rightCont[] = new int[n];

    Stack<Integer> stack = new Stack<>();
    int prevCount = 0;

    //create left contagious array
    for(int i=0; i<n; i++){
      int curHeight = heights[i];
      int res = 1;

      while(!stack.isEmpty() && curHeight <= heights[stack.peek()]){
        res += leftCont[stack.pop()];
      }
      
      stack.push(i);
      leftCont[i] = res;
    }

    stack = new Stack<>();
    //create right contagious array
    for(int i=n-1; i>=0; i--){
      int curHeight = heights[i];
      int res = 1;

      while(!stack.isEmpty() && curHeight <= heights[stack.peek()]){
          res += rightCont[stack.pop()];
      }

      stack.push(i);
      rightCont[i] = res;
    }

    int maxArea = 0;
    //calculate area for each histogram
    for(int i=0; i<n; i++){
      int area = (leftCont[i] + rightCont[i] - 1) * heights[i];
      maxArea = Math.max(maxArea, area);
    }

    return maxArea;
  }
}
