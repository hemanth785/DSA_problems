package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

/*
 * link: https://workat.tech/problem-solving/practice/sliding-window-maximum
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */
public class SlidingWindowMax {
  public static void main(String args[]){
    int[] input = new int[]{1,3,-1,-3,5,3,6,7};
    int k = 3;

    int[] maxWindowElements = slidingWindowOptimized(input, k);

    System.out.println(Arrays.toString(maxWindowElements));
  }

  /*
   * Approach 1: Bruteforce
   * 
   * for each element in array, until n-k
   * - iterate for next k elements and find the max and put it in result 
   * 
   * Time: O(n*m), Space: O(1),  where m-size of window
   */


  /*
   * Aproach 2: Optimzed
   * Using Double end queue or Dqueue
   * 
   * Time: O(n), Space: O(n)
   * 
   * Steps:
   * 1. Add first k elements(index of elements) into dQueue from front, while removing smaller than currently adding elements int the front
   * 2. Now note the 1st max element (which will be 1st element from rear of the queue)
   * 3. Now remove elements which are at index less than l, and add next element, while removing smaller element (same as step 1)
   *   - again check for max element from rear of array (continue this until we reach end of the array)
   */
  public static int[] slidingWindowOptimized(int[] nums, int k){
    int n = nums.length;
    int maxArray[] = new int[n-k+1];

    Deque<Integer> dq = new LinkedList<Integer>();

    int l=0, r=0;

    //add to dq while removing lesser elements
    while(r<k){
      while(!dq.isEmpty() && nums[dq.getLast()] <= nums[r]){
        dq.removeLast();
      }
      dq.addLast(r);
      r++;
    }

    int i = 0; //this is to store max item
    while(r < n){
      maxArray[i] = nums[dq.getFirst()];

      //remove elements not inside window (here we are comparing indexes)
      while(!dq.isEmpty() && dq.getFirst() <= l){
        dq.removeFirst();
      }
      
      //add to dq while removing lesser elements
      while(!dq.isEmpty() && nums[dq.getLast()] <= nums[r]){
        dq.removeLast();
      }
      dq.addLast(r);

      l++;
      r++;

      i++;
    }
    //add last element
    maxArray[i] = nums[dq.getFirst()];

    return maxArray;
  }
}
