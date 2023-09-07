package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

/*
 * You are given an array of integers nums, 
 * there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
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

    int i = 0;
    while(r<n){

        // System.out.println("i:"+i+", l:"+l+", r:"+r);
        // System.out.println(dq);
        maxArray[i] = nums[dq.getFirst()];

        //remove elements not inside window
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
