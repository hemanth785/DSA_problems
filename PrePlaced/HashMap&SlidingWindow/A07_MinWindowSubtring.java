

import java.util.HashMap;

/*
 * Link: https://leetcode.com/problems/minimum-window-substring/
 */
public class A07_MinWindowSubtring {
  /*
   * Approach: Using int[128] and sliding window with l, r
   * - charCount stores how many more of each char we still need in the window
   * - requiredCount = total chars still needed to satisfy t
   * - Step 1: Build first window using first t.length() chars of s
   * - Step 2: Shrink while valid, then expand one char at a time and shrink again
   *
   * Time: O(n), Space: O(1)
   */
  public String minWindow2(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    int[] charCount = new int[128];
    for (char c : t.toCharArray()) {
      charCount[c]++;
    }

    int k = t.length();
    int requiredCount = k;
    int l = 0;
    int r = 0;
    int minWindowLen = Integer.MAX_VALUE;
    int start = 0;

    // Step 1: build first window [0 .. k-1]
    for (r = 0; r < k; r++) {
      if (charCount[s.charAt(r)] > 0) {
        requiredCount--;
      }
      charCount[s.charAt(r)]--; //this decrements the count of the character in the window (even if the character is not in t string)
    }

    // Step 2: shrink while valid, expand while r < s.length(), then shrink once more
    while (r < s.length()) {
      while (requiredCount == 0) { //while the window contains all the characters in 't' string
        if (r - l < minWindowLen) {
          minWindowLen = r - l;
          start = l;
        }

        //now, remove the leftmost character from the window
        if (charCount[s.charAt(l)] >= 0) {  //if character is present in t string
          requiredCount++;
        }
        charCount[s.charAt(l)]++;
        l++;
      }

      if (charCount[s.charAt(r)] > 0) { //add the rightmost character to the window
        requiredCount--;
      }
      charCount[s.charAt(r)]--;
      r++;
    }

    // r reached end — shrink the last valid window if any
    while (requiredCount == 0) {
      if (r - l < minWindowLen) {
        minWindowLen = r - l;
        start = l;
      }

      if (charCount[s.charAt(l)] >= 0) {
        requiredCount++;
      }
      charCount[s.charAt(l)]++;
      l++;
    }

    return minWindowLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindowLen);
  }

  /*
   * Approach: Use HashMap and Sliding window approach
   * - create 2 maps, s_map and t_map & populate both map with chars from t string, 
   *    - t_map with proper count of chars
   *    - s_map with count of 0
   * - get tCharCount, which is count of distinct chars in t string
   * - initilize l and r pointers as 0
   * - run a while loop, until r<n
   *    - if matchCount != tCharCount, then move r pointer and update count in s_map and also check for matchCount
   *    - else if matchCount == tCharCount, 
   *        - First check, if subtring b/w l and r poiter is lesser length than already stored and update it
   *        - move l pointer and update count in s_map and also check for matchCount
   * - After exiting the while loop, again run a while loop with condition whether matchCount == tCharCount, which checking for lesser length substring
   * 
   * Note: One thing to note is that, matchCount will increment only once when 's_map char count' crosses 't_map char count', once its crosses we are not updating count
   *        and we decrement it only when 's_map char count' become lesser than 't_map char count'
   */
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    HashMap<Character, Integer> t_map = new HashMap<>();
    HashMap<Character, Integer> s_map = new HashMap<>();

    int n = s.length();

    for (char ch : t.toCharArray()) {
      //update proper count of each chars in t_map
      t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);

      //initialize s map with matching chars with t string as '0' (s_map contains only chars from t string)
      if (s_map.get(ch) == null) {
        s_map.put(ch, 0);
      }
    }

    int tCharCount = t_map.size();

    int l = 0;
    int r = 0;

    int matchCount = 0;
    int resStringLength = Integer.MAX_VALUE;
    String resString = "";

    while (r < n) {
      if (matchCount != tCharCount) {
        // add char from right
        char r_ch = s.charAt(r);
        if (s_map.get(r_ch) != null) {
          s_map.put(r_ch, s_map.get(r_ch) + 1);

          if (s_map.get(r_ch).equals(t_map.get(r_ch))) { // Using equals() instead of ==, because Integer is of type object
            matchCount++;
          }
        }
        r++;

      } else {

        //consider current substring for result
        String newResString = s.substring(l, r);
        if (newResString.length() < resStringLength) {
          resString = newResString;
          resStringLength = newResString.length();
        }

        // remove char from left
        char l_ch = s.charAt(l);
        if (s_map.get(l_ch) != null) {
          s_map.put(l_ch, s_map.get(l_ch) - 1);

          if (s_map.get(l_ch) + 1 == t_map.get(l_ch)) {
            matchCount--;
          }
        }
        l++;
      }
    }

    // -- Repeat else block --
    // this is required once rightPointer reached end and matchCount still equal to
    // char count, while incrementing leftPointer
    while (matchCount == tCharCount) {
      String newResString = s.substring(l, r);
      if (newResString.length() < resStringLength) {
        resString = newResString;
        resStringLength = newResString.length();
      }

      // remove char from left
      char l_ch = s.charAt(l);
      if (s_map.get(l_ch) != null) {
        s_map.put(l_ch, s_map.get(l_ch) - 1);

        if (s_map.get(l_ch) + 1 == t_map.get(l_ch)) {
          matchCount--;
        }
      }
      l++;
    }

    return resString;
  }
}
