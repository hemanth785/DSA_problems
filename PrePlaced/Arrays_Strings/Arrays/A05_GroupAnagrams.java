package PrePlaced.Arrays_Strings.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/group-anagrams/
 */
public class A05_GroupAnagrams {
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

  /*
   * Optimized approach: Using custom Hash of each word to group strings
   * 
   * Solution link: https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
   */

  // Function to generate hash of word s
  static final int MAX_CHAR = 26;
  static String getHash(String s) {
    StringBuilder hash = new StringBuilder();
    int[] freq = new int[MAX_CHAR];
    
    // Count frequency of each character
    for (char ch : s.toCharArray()) {
        freq[ch - 'a']++;
    }

    // Append the frequency to construct the hash
    for (int i = 0; i < MAX_CHAR; i++) {
        hash.append(freq[i]);
        hash.append("$");
    }

    return hash.toString();
  }
}
