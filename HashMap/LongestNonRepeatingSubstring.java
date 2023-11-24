package HashMap;

import java.util.HashMap;
import java.util.Map;

/*
 * link: https://workat.tech/problem-solving/practice/longest-substring-without-repeat
 */
public class LongestNonRepeatingSubstring {
  
  /*
   * Approach: Using map to store previous occurance of charector
   * Steps:
   *   - Initialize an array to store the previous occurrence of all the characters.
   *   - Initialize the start point to 0.
   *   - Traverse the array fromi = 0 to i = n and for every character check the index of the previous occurrence of the character. If the previous occurrence is greater than or equal to start, then update start to previous occurrence + 1.
   *   - Store the current index of the character in the array as the previous occurrence.
   *   - Update the maximum value of longest substring to max(longest substring, i - start + 1).
   * 
   * Time: O(n), space: O(n)
   */
  int longestSubstringWithoutRepeat(String s) {
		if(s.equals("")){
            return 0;
    }
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();
		
		int startIndex = 0;
		int maxLen = 0;
		for(int i=0; i<n; i++){
			char ch = s.charAt(i);
			if(map.containsKey(ch)){
				maxLen = Math.max(i-startIndex, maxLen);
				
				if(map.get(ch)+1 > startIndex){
					startIndex = map.get(ch)+1;
				}
			}
            
			map.put(ch, i);
		}
    maxLen = Math.max(n-startIndex, maxLen);

		return maxLen == 0 ? n-startIndex : maxLen;
	}
}
