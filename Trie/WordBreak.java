/*
 * Link: https://leetcode.com/problems/word-break/
 */

public class WordBreak {

  /*
   * Approach 1: This problem can be solved using the DP.
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    Set<String> wordSet = new HashSet<>(wordDict);
    Boolean dp[] = new Boolean[n];
    Arrays.fill(dp, null);
    return isWordPresentRecursive(s, wordSet, 0, n, dp);
  }

  public Boolean isWordPresentRecursive(String s, Set<String> wordSet, int l, int n, Boolean[] dp) {
    if (l >= n) {
      return true;
    }

    if (dp[l] != null) {
      return dp[l];
    }
    for (int i=l; i<n; i++) {
      if (
        wordSet.contains(s.substring(l, i+1)) && 
        isWordPresentRecursive(s, wordSet, i + 1, n, dp)
      ) {
        //returning here also necessary because, as soon as we find its present, no need to continue loop again
        dp[l] = true;
        return true;
      }
    }
    dp[l] = false;
    return false;
  }

  /*
   * Approach 2: Instead of set for searching stirng, we can also use Trie
   * In both the cases time complexity would be almost same, but trie uses little less space than set in some cases
   */

  private static final int ALPHABET_COUNT = 26;

  public boolean wordBreak(String s, List<String> wordDict) {
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

  public Boolean isWordPresent(
    String s,
    TrieNode root,
    int l,
    int n,
    Boolean[] dp
  ) {
    if (l >= n) {
      return true;
    }

    if (dp[l] != null) {
      return dp[l];
    }
    for (int i = l; i < n; i++) {
      if (
        // wordSet.contains(s.substring(l, i+1)) &&
        search(root, s.substring(l, i + 1)) && //instead of set, trie is used here for searching substring
        isWordPresent(s, root, i + 1, n, dp)
      ) {
        //returning here also necessary because, as soon as we find its present, no need to continue loop again
        dp[l] = true;
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
      // if any charector of string does not exists in tree, we can confirm that word does not exists
      if (cur.childNodes[index] == null) {
        return false;
      }
      cur = cur.childNodes[index];
    }
    //if all chars exists, one that confirms the existance of word is flag 'endOfWord'
    return cur.isEndOfWord;
  }
}
