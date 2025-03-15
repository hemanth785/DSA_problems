package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Link: https://leetcode.com/problems/longest-string-chain/
 */

public class A29_Longest_String_chain {
  /*
   * Approach: DP
   * - insert all the words in HashSet
   * - For each word, call recursive function dfs, 
   * - inside the function dfs, for the current word, try removing each charector and call for next recursive call
   * - inside the recursive call, first check if that word is exists in HashMap
   * - if it exists, remove each charector from this word and try for next word in chain
   */
  public int longestStrChain(String[] words) {
    Set<String> wordSet = new HashSet<>(Arrays.asList(words));
    Map<String, Integer> memo = new HashMap<>();

    int maxChain = 0;
    for (String word : words) {
      maxChain = Math.max(maxChain, dfs(word, wordSet, memo));
    }

    return maxChain;
  }

  private int dfs(String word, Set<String> wordSet, Map<String, Integer> memo) {
    if (!wordSet.contains(word)) {
      return 0;
    }

    if (memo.containsKey(word)) {
      return memo.get(word);
    }

    int maxChain = 1;
    for (int i = 0; i<word.length(); i++) {
      String nextWord = word.substring(0, i) + word.substring(i + 1); //create next word by removing each character
      maxChain = Math.max(maxChain, 1 + dfs(nextWord, wordSet, memo));
    }

    memo.put(word, maxChain);
    return maxChain;
  }
}
