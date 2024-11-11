

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://www.naukri.com/code360/problems/longest-substring-with-at-most-two-distinct-characters_3125863
 */
public class A15_LongestSubstringWIthAtMostTwoDistinctChars {
  /*
   * Approach: Using Hashmap
   * - Use hashmap to store the count of chars, while checking for condition hashMap.size() <= 2
   */
  public static int lengthOfLongestSubstring(String s) {
		int n = s.length();

		Map<Character, Integer> map = new HashMap<>();

		int l=0;
		int r=0;

		int longestLen = 0;

		while(l<=r && r<n){
			if(map.size() <= 2){
				longestLen = Math.max(longestLen, r-l);

				char rChar = s.charAt(r);
				map.put(rChar, map.getOrDefault(rChar, 0)+1);
				r++;
			} else {
				char lChar = s.charAt(l);
				if(map.get(lChar) == 1){
					map.remove(lChar);
				} else {
					map.put(lChar, map.get(lChar)-1);
				}
				l++;
			}
		}
		if(map.size() <= 2){
			longestLen = Math.max(longestLen, r-l);
		}

		return longestLen;
	}
}
