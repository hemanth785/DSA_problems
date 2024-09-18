/*
 * Link: https://leetcode.com/problems/design-add-and-search-words-data-structure
 */

public class A_05_WordSearchWithPattern {
  static TrieNode root;

  static class TrieNode {
    TrieNode childNodes[] = new TrieNode[26];
    boolean endOfWord = false;
  }

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';

      if (cur.childNodes[index] == null) {
        cur.childNodes[index] = new TrieNode();
      }
      cur = cur.childNodes[index];
    }
    cur.endOfWord = true;
  }

  public boolean search(String word) {
    TrieNode cur = root;
    return searchChar(word, 0, cur);
  }

  public boolean searchChar(String word, int i, TrieNode cur) {// incase of complete length
    if (i >= word.length()) {
      return cur.endOfWord;
    }
    char ch = word.charAt(i);
    if (ch != '.') {
      int index = ch - 'a';
      if (cur.childNodes[index] == null) {
        return false;
      }
      return searchChar(word, i + 1, cur.childNodes[index]);
    } else {
      //if we found any '.' in search string, then we have to check for all 26 possibilities at that position
      for (int index = 0; index < 26; index++) {
        if (cur.childNodes[index] != null) {
          if (searchChar(word, i + 1, cur.childNodes[index])) {
            return true;
          }
        }

      }
      return false;
    }

  }
}
