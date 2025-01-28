

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
 */
public class A10_Count_anagrams {
  /*
   * Approach: This logic is similar problem /HashMap/A06_PermuatationInString.java
   * 
   * There we have to just return, if pattern exists
   * Here we have to return the count
   */
  int search(String pat, String txt) {
    if (pat.length() > txt.length()) {
      return 0;
    }
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    int k = pat.length();
    int n = txt.length();
    
    int anagramsCount = 0;

    for (char ch = 'a'; ch <= 'z'; ch++) {
      map1.put(ch, 0);
      map2.put(ch, 0);
    }

    for (int i = 0; i < k; i++) {
      char ch1 = pat.charAt(i);
      map1.put(ch1, map1.get(ch1) + 1);

      char ch2 = txt.charAt(i);
      map2.put(ch2, map2.get(ch2) + 1);
    }

    int matchCount = 0;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (map1.get(ch).equals(map2.get(ch))) { // Using .equls() becuase Integer from map is a object
        matchCount++;
      }
    }

    if (matchCount == 26) {
      anagramsCount++;
    }

    int l = 0;
    int r = k;

    while (r < n) {
      // remove prev item from window
      char lch = txt.charAt(l);
      map2.put(lch, map2.get(lch) - 1);
      if (map1.get(lch).equals(map2.get(lch))) { // Using .equls() becuase Integer from map is a object
        matchCount++;
      } else if (map2.get(lch) + 1 == map1.get(lch)) {
        matchCount--;
      }

      // add the next item to the window
      char rch = txt.charAt(r);
      map2.put(rch, map2.get(rch) + 1);

      if (map1.get(rch).equals(map2.get(rch))) { // Using .equls() becuase Integer from map is a object
        matchCount++;
      } else if (map1.get(rch) + 1 == map2.get(rch)) {
        matchCount--;
      }

      //check for match
      if (matchCount == 26) {
        anagramsCount++;
      }

      r++;
      l++;
    }

    return anagramsCount;
  }
}
