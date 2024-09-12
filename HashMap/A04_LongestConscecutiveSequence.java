package HashMap;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class A04_LongestConscecutiveSequence {
  /*
   * Appraoch: (Naive) using sorting
   */
  public int longestConsecutive(int[] A) {
    if(A.length == 0){
        return 0;
    }
    Arrays.sort(A);
		
		int maxLen = 0;
		int len = 1;
		System.out.println(Arrays.toString(A));
		for(int i=1; i<A.length; i++){
			if(A[i] == A[i-1]+1){
				len++;
			} else if(A[i] != A[i-1]) {
				maxLen = Math.max(maxLen, len);
				len=1;
			}
		}
		maxLen = Math.max(maxLen, len);
		
		return maxLen;
  }

  /*
   * Appraoch: Using HashSet
   * - Store all elements in hashSet
   * - Loop through each item, and check if this could be starting point for sequence 
   *    - check if item-1 exists, if it exists that means this is not the starting point, so continue loop
   * - If item-1 not found in set, then start checking for each item+1 in set while keep incrementing length
   * - at each iteration, compare length with max length
   */

  public int longestConsecutive2(int[] A) {
    int n = A.length;
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      set.add(A[i]);
    }

    int maxLen = 0;

    for (int i = 0; i < n; i++) {
      int item = A[i];

      // check if lesser item exists in set
      if (!set.contains(item - 1)) {
        // start removing from set
        int len = 1;

        while (set.contains(item + 1)) {
          len++;
          item = item + 1;
        }

        maxLen = Math.max(len, maxLen);
      }
    }

    return maxLen;
  }
}
