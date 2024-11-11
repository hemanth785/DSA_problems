package PrePlaced.Trie;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/word-search-ii/
 */

/*
 * Approach: 
 * - Build the trie with given words, 
 *    - instead of declaring endOfWord as boolean, make it as integer. (Since duplicate words can exists)
 * - Then loop though each cell in matrix, 
 *    - Check if the char at cell is in the root node of trie, 
 *    - If Yes, continue search for next char in all 4 direction of matrix, with respect to next node in trie
 *    - If we reach endOfWord, then decrement the eow value in trie and add this word to result list
 *    - At any point cur char is not matching cur node in trie, break the loop
 * - Continue this process for all cells in matrix
 * 
 * Time:  O(n*m*(total number of charectors in all words))
 *        This is the worst care complexity, when all words have totally different charectors
 */

public class A_06_WorkBreak2 {
  public int adjX[] = { 0, 1, 0, -1 };
  public int adjY[] = { 1, 0, -1, 0 };
  List<String> result;

  static TrieNode root;

  static class TrieNode {
    TrieNode childNodes[] = new TrieNode[26];
    int endOfWord = 0;
  }

  void insertWord(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';

      if (cur.childNodes[index] == null) {
        cur.childNodes[index] = new TrieNode();
      }
      cur = cur.childNodes[index];
    }
    cur.endOfWord += 1;
  }

  public List<String> findWords(char[][] board, String[] words) {
    root = new TrieNode();
    result = new ArrayList<>();

    int maxWordLen = 0;
    for (String word : words) {
      insertWord(word);
      maxWordLen = Math.max(maxWordLen, word.length());
    }

    int n = board.length;
    int m = board[0].length;
    int visited[][] = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        TrieNode cur = root;
        traverseDFS(board, n, m, i, j, board[i][j] + "", visited, maxWordLen, cur);
      }
    }
    return result;
  }

  boolean isValid(int n, int m, int x, int y) {
    return x >= 0 && y >= 0 & x < n && y < m;
  }

  private void traverseDFS(char[][] board, int n, int m, int x, int y, String curWord, int visited[][], int maxWordLen, TrieNode cur) {
    char ch = board[x][y];

    //check if 1st char of cell matching with any word in trie
    int index = ch - 'a';
    if (cur.childNodes[index] == null) {
      return;
    }
    cur = cur.childNodes[index];
    if (cur.endOfWord > 0) {
      result.add(curWord);
      cur.endOfWord -= 1;
    }

    if (curWord.length() > maxWordLen) {
      return;
    }

    visited[x][y] = 1;

    for (int i = 0; i < 4; i++) {
      int nextX = x + adjX[i];
      int nextY = y + adjY[i];

      if (isValid(n, m, nextX, nextY) && visited[nextX][nextY] == 0) {
        traverseDFS(board, n, m, nextX, nextY, curWord + board[nextX][nextY], visited, maxWordLen, cur);
      }
    }
    visited[x][y] = 0;

    return;
  }
}
