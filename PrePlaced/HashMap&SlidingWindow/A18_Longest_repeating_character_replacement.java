import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class A18_Longest_repeating_character_replacement
{
  /*
   * Appraoch 1: Bruteforce 
   * - Find all the possible subtrings that satisfy condition
   */

  /*
  * Approach 2: Sliding window
  * - Start with window of size 1, while storing each charector count in hashmap
  * - At any point map size should not cross k+1 (if it is more than 1, that means we have to replace more than k chars)
  * - While increasing the window size, check for this
  *   - get the mostFrequent char from the map
  *   - subract mostFrequent from the window length to get the number of chars to be replaced
  *   - if num of chars to be replaced <= k, consider that window count for result 
  * 
  * Time: O(n * 3), Space: O(3)
  */

  /*
   * Optional: We can optimize the going through map to get the most frequent char count
   * - Whenever after inserting new char to map, compare that char count with mostFreqCharCount
   * - We dont need to decrement value of 'mostFreqCharCount', since we only consider count which is greater than the previous one for calculating result.
   */
  public int characterReplacement(String s, int k) {
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();
    int longestLen = 0;
    int mostFreqCharCount = 0;

    int l=0;
    int r=0;

    while(r<n && l<=r){
      if(map.size() <= k+1){
        char rChar = s.charAt(r);
        map.put(rChar, map.getOrDefault(rChar, 0)+1);
        r++;

        int subStrLen = r-l;

        //mostFrequenceCharCount = getMostFrequentCharCount(map);
        mostFreqCharCount = Math.max(mostFreqCharCount, map.get(rChar));

        if(subStrLen-mostFreqCharCount <= k){
          longestLen = Math.max(longestLen, subStrLen);
          
        } else {
          char lChar = s.charAt(l);
          if(map.get(lChar) == 1){
            map.remove(lChar);
          } else {
            map.put(lChar, map.get(lChar)-1);
          }
          l++;
        }
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

    return longestLen;
  }

  private int getMostFrequentCharCount(Map<Character, Integer> map){ //This is not required for most optimized solution
    int maxCount = 0;
    for(Map.Entry entry: map.entrySet()){
      maxCount = Math.max(maxCount, (int)entry.getValue());
    }
    return maxCount;
  }

  

}
