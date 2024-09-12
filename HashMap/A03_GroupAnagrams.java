package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/group-anagrams/
 */
public class A03_GroupAnagrams {
  /*
   * Approach: Using sort and hashMap
   * - For each string, sort it and check if sorted string(key) exists in hashMap
   *     - If exists add the original string to hashMap
   * - After processing all string, loop through hash map to get the grouped anagram strings
   */
  
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] charArr = str.toCharArray();
      Arrays.sort(charArr);
      String sortedStr = new String(charArr);

      if (!map.containsKey(sortedStr)) {
        map.put(sortedStr, new ArrayList<>());
      }
      map.get(sortedStr).add(str);
    }

    List<List<String>> result = new ArrayList<>();

    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      result.add(entry.getValue());
    }

    return result;
  }
}
