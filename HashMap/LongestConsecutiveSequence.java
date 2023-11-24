package HashMap;

import java.util.Arrays;
import java.util.HashMap;

/*
 * link: https://workat.tech/problem-solving/practice/longest-consecutive-sequence
 */
public class LongestConsecutiveSequence {
  /*
   * Approach 1: By sorting and comparing elements
   * 
   * Time: O(n log(n)), Space: O(1)
   */
  static int longestConsecutiveSequence(int[] A) {
    if(A.length == 0){
      return 0;
    }
    Arrays.sort(A);
  
		int maxLen = 0;
		int len = 1;
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
   * Approach 2: Time efficient - Using hasmap to store the count of numbers
   * 
   * Steps:
   * Create a hashmap, say countAllElements.
   * Traverse the array and for every valid i set countAllElements[A[i]] = 1;
   * Now again traverse the array and for each element check if the previous element is present in the hashmap.
   * If the previous element is present in the hashmap then this element can not be a starting point.
   * If the previous element is not present in the hashmap then the current element must be a starting point of a consecutive sequence. 
   *    - So Count the number of elements in the current sequence from the hashmap and update the maximum value of the longest sequence.
   * 
   * Time: O(n), Space: O(n)
   */

  static int longestConsecutiveSequenceWithMap(int[] A) {
	    HashMap <Integer, Integer> countAllElements = new HashMap<Integer, Integer> ();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			countAllElements.put(A[i], 1);
		}
		int ans = 0, currentSequence = 0;
		for (int i = 0; i < n; i++) {
			if (countAllElements.get(A[i] - 1) != null) {
				continue;
			} 
			currentSequence = 0;
			int value = A[i];
			while (countAllElements.get(value) != null) {
				currentSequence++;
				value++;
			}
			ans = Math.max (ans, currentSequence);
		}
		return ans;
	}
}
