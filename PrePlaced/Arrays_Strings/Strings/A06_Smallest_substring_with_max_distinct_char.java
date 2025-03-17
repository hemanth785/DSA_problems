package Arrays_Strings.Strings;

/*
 * Link: https://www.geeksforgeeks.org/length-smallest-sub-string-consisting-maximum-distinct-characters/
 */
public class A06_Smallest_substring_with_max_distinct_char {
  /*
   * Approach: Using Hashmap to keep the count of each chars along with sliding window
   * 
   * we know that:
   * - when sub-string’s contains all distinct characters, then dist char count is equal to substring length
   * - Maintain a window of characters. Whenever the window contains all characters of given string, 
   *    we shrink the window from left side to remove extra characters and then compare its length with smallest window found so far.
   */
}
