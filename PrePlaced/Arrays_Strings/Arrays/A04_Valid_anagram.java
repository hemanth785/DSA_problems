package PrePlaced.Arrays_Strings.Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/valid-anagram/
 */
public class A04_Valid_anagram {
  /*
   * Approach 1: Sorting both the strings
   * 
   * Time: O(m log(m)) + O(n log(n))     Space: O(1)
   */

  /*
   * Approach 2: Using hashmap
   *  
   * Time: O(n+m), Space: O(n)
   */
  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()){
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();

    for(int i=0; i<s.length(); i++){
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0)+1);
    }

    for(int i=0; i<t.length(); i++){
      char ch = t.charAt(i);
      
      if(!map.containsKey(ch)){
        return false;
      }

      if(map.get(ch) == 1){
        map.remove(ch);
      } else {
        map.put(ch, map.get(ch)-1);
      }
    }

    return map.size() == 0;
  }
}
