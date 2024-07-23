package HashMap;

import java.util.HashSet;
import java.util.Set;

/*
 * link: https://workat.tech/problem-solving/practice/longest-substring-without-repeat
 */
public class LongestNonRepeatingSubstring {
  

  /*
   * Approach: 2 pointer and Set
   * - Initialize 2 pointers, initially both starting at 0
   *    - one for marking start of substring, and another for end
   * - Start adding the chatacters to HashSet (if char is not present in the Set), while incrementing b pointer. 
   *    - while adding also calculate the size of string (this can be get by size of Hashset - since set contains only distinct items)
   * - if Set already contains char at pointer b, then keep on removing the char at pointer a, until this duplicate charactors remove
   * - Run this loop until b pointer reaches end of string
   * 
   * Time: O(n), space: O(n)
   */

  public int lengthOfLongestSubstring(String s) {
    if (s.equals("")) {
      return 0;
    }
    int n = s.length();

    Set<Character> set = new HashSet<>();
    int a = 0;
    int b = 0;
    int maxLen = 0;

    while (b < s.length()) {
      char ch = s.charAt(b);
      if (!set.contains(ch)) {
        set.add(ch);
        maxLen = Math.max(set.size(), maxLen);
        b++;
      } else {
        set.remove(s.charAt(a));
        a++;
      }
    }

    return maxLen;
  }
}
