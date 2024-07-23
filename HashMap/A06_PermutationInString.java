/*
 * Link: https://leetcode.com/problems/permutation-in-string/
 */

import java.util.HashMap;
import java.util.Map;

public class A06_PermutationInString {
  /*
   * Approach: Using HashMap and sliding window
   * - create 2 hashmap and put values from a-z with count as 0
   * - Iterate over 2 strings, from 0 to k(size of 1st string- smaller), while pushing each character count ot respective map
   * - now calculate the matchCount by comparing each char count from both the maps
   * - Now create a window form l=0 to r=k,
   * - Now shift window while re-calculating the match count.
   * - if at any stage match count becomes 26, then return true
   * - else return false
   */
  
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    int k = s1.length();
    int n = s2.length();

    for (char ch = 'a'; ch <= 'z'; ch++) {
      map1.put(ch, 0);
      map2.put(ch, 0);
    }

    for (int i = 0; i < k; i++) {
      char ch1 = s1.charAt(i);
      map1.put(ch1, map1.get(ch1) + 1);

      char ch2 = s2.charAt(i);
      map2.put(ch2, map2.get(ch2) + 1);
    }

    int matchCount = 0;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (map1.get(ch).equals(map2.get(ch))) { // Using .equls() becuase Integer from map is a object
        matchCount++;
      }
    }

    int l = 0;
    int r = k;

    while (r < n) {
      if (matchCount == 26) {
        return true;
      }

      // add the next item to the window
      char rch = s2.charAt(r);
      map2.put(rch, map2.get(rch) + 1);

      if (map1.get(rch).equals(map2.get(rch))) { // Using .equls() becuase Integer from map is a object
        matchCount++;
      } else if (map1.get(rch) + 1 == map2.get(rch)) {
        matchCount--;
      }

      //check for match
      if (matchCount == 26) {
        return true;
      }

      // remove prev item from window
      char lch = s2.charAt(l);
      map2.put(lch, map2.get(lch) - 1);
      if (map1.get(lch).equals(map2.get(lch))) { // Using .equls() becuase Integer from map is a object
        matchCount++;
      } else if (map2.get(lch) + 1 == map1.get(lch)) {
        matchCount--;
      }

      r++;
      l++;

    }

    return matchCount == 26;
  }
}
