package PrePlaced.Trie;

/*
 * Link: https://leetcode.com/problems/word-break/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_04_WordBreak {

  /*
   * Approach 1: This problem can be solved using the DP.
   */
  public boolean wordBreak(String str, List<String> wordDict) {
    int n = str.length();
    Set<String> wordSet = new HashSet<>(wordDict);
    Boolean dp[] = new Boolean[n];
    Arrays.fill(dp, null);
    return isWordPresentRecursive(str, wordSet, 0, n, dp);
  }

  public Boolean isWordPresentRecursive(String s, Set<String> wordSet, int l, int n, Boolean[] dp) {
    if(l >= n) {
      return true;
    }

    if(dp[l] != null) {
      return dp[l];
    }
    for(int i=l; i<n; i++) {
      if(
        wordSet.contains(s.substring(l, i+1)) && 
        isWordPresentRecursive(s, wordSet, i + 1, n, dp)
      ){
        //returning here also necessary because, as soon as we find its present, no need to continue loop again
        dp[l] = true;
        return true;
      }
    }
    dp[l] = false;
    return false;
  }

  /*
   * Approach 2: Instead of using Set for searching stirng, we can also use Trie
   * In both the cases time complexity would be almost same, but trie uses little less space than set in some cases
   */

  private static final int ALPHABET_COUNT = 26;

  public boolean wordBreak2(String s, List<String> wordDict) {
    int n = s.length();

    //initialize and create trie
    TrieNode root = new TrieNode();
    for (String word : wordDict) {
      insert(root, word);
    }
    Boolean dp[] = new Boolean[n];
    Arrays.fill(dp, null);
    return isWordPresent(s, root, 0, n, dp);
  }

  public Boolean isWordPresent(String s, TrieNode root, int l, int n, Boolean[] dp){
    if(l >= n) {
      return true;
    }

    if(dp[l] != null) {
      return dp[l];
    }
    for(int r = l+1; r <= n; r++) {
      String subStr = s.substring(l, r);
      boolean foundInTrie = search(root, subStr);  //instead of set, trie is used here for searching substring

      if(foundInTrie && isWordPresent(s, root, r, n, dp)){    
        dp[l] = true;   //returning here also necessary because, as soon as we find its present, no need to continue loop again
        return true;
      }
    }
    dp[l] = false;
    return false;
  }

  public static class TrieNode {
    TrieNode[] childNodes = new TrieNode[ALPHABET_COUNT];
    boolean isEndOfWord = false;

    TrieNode() {
      for (int i = 0; i < ALPHABET_COUNT; i++) {
        childNodes[i] = null;
      }
    }
  }

  public static void insert(TrieNode root, String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char charector = word.charAt(i);
      int index = charector - 'a';
      if (cur.childNodes[index] == null) {
        cur.childNodes[index] = new TrieNode();
      }

      cur = cur.childNodes[index];
    }
    cur.isEndOfWord = true;
  }

  public static boolean search(TrieNode root, String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      // if any charector of string does not exists in trie, we can confirm that word does not exists
      if (cur.childNodes[index] == null) {
        return false;
      }
      cur = cur.childNodes[index];
    }
    //if all chars exists, one that confirms the existance of word is flag 'endOfWord'
    return cur.isEndOfWord;
  }
}



/*
 * Not working code:
 * 
 * public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        
        //initialize and create trie
        root = new TrieNode();
        for(String word: wordDict){
            insert(root, word);
        }

        Boolean dp[][] = new Boolean[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], null);
        }
        
        return isWordPresent(s, root, 0, n, "", dp);
    }

    public Boolean isWordPresent(String s, TrieNode cur, int l, int n, String curWord, Boolean[][] dp){
        if (l >= n) {
            System.out.println("i am here: "+curWord.length()+", curWord: "+curWord+", l: "+l);
            return curWord.length() == 0;
        }

        if(dp[l][curWord.length()] != null) {
            return dp[l][curWord.length()];
        }

        char ch = s.charAt(l);
        int index = ch - 'a';
        if(cur.childNodes[index] == null){
            return false;
        }
        curWord = curWord + ch;
        cur = cur.childNodes[index];

        if(cur.isEndOfWord){
            if(isWordPresent(s, root, l+1, n, "", dp)){
                dp[l][curWord.length()] = true;
                return true;
            }
        } 
        dp[l][curWord.length()] = isWordPresent(s, cur, l+1, n, curWord, dp);
        return dp[l][curWord.length()];
    }
 */

