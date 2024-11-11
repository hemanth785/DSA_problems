

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://www.naukri.com/code360/problems/distinct-characters_2221410
 */
public class A16_LongestSubstringWIthAtMost_K_DistinctChars {
  /*
   * This is similar to previous problem, just that distinct charectors will be given explicitely
   */

  public static int kDistinctChars(int k, String s) {
		int n = s.length();

		Map<Character, Integer> map = new HashMap<>();

		int l=0;
		int r=0;

		int longestLen = 0;

		while(l<=r && r<n){
			if(map.size() <= k){
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
		if(map.size() <= k){
			longestLen = Math.max(longestLen, r-l);
		}

		return longestLen;
	}
}