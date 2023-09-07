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
 * Link: https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/histogram-problem/problem
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
  public static int histo(List<Integer> arr) {
        int n = arr.size();
        int leftContMax[] = new int[n];
        int rightContMax[] = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        //create left contagious max array
        for(int i=0; i<n; i++){
            int count = 1;
            if(stack.isEmpty()){
                stack.push(i);
                leftContMax[i] = count;
                
                continue;
            }
            
            while(!stack.isEmpty() && arr.get(i) <= arr.get(stack.peek())){
                count += leftContMax[stack.pop()];
            }
            stack.push(i);
            leftContMax[i] = count;
        }
        
        //create right contagious max array
        stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            int count = 1;
            if(stack.isEmpty()){
                stack.push(i);
                rightContMax[i] = count;
                continue;
            }
            
            while(!stack.isEmpty() && arr.get(i) < arr.get(stack.peek())){
                count += rightContMax[stack.pop()];
            }
            stack.push(i);
            rightContMax[i] = count;
        }
        
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int area = arr.get(i) * (leftContMax[i] + rightContMax[i] - 1); //subtracting 1 because, in both left and right cases, we included the ith count (that become duplicate ith histogram count)
                
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
