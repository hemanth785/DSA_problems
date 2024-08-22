package Graph;

public class A_14_WordSearchMatrix {
  /*
   * Link: https://leetcode.com/problems/word-search/
   */

  public int adjX[] = { 0, 1, 0, -1 };
  public int adjY[] = { 1, 0, -1, 0 };

  public boolean exist(char[][] board, String word) {
    int n = board.length;
    int m = board[0].length;
    int visited[][] = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char firstChar = word.charAt(0);
        if(firstChar == board[i][j]){   //consider only when first char of word matches with current board charector
          if(traverseDFS(board, n, m, i, j, word, firstChar + "", visited)){
            return true;
          }
        }
      }
    }

    return false;
  }

  public boolean traverseDFS(char[][] board, int n, int m, int x, int y, String word, String curWord, int visited[][]) {
    if (curWord.equals(word)) {
      return true;
    }
    if (curWord.length() >= word.length()) {
      return false;
    }
    visited[x][y] = 1;

    for (int i = 0; i < 4; i++) {
      int nextX = x + adjX[i];
      int nextY = y + adjY[i];

      if (isValid(n, m, nextX, nextY) && visited[nextX][nextY] == 0) {
        if (word.charAt(curWord.length()) == board[nextX][nextY]) { //continue in direction where next char required is matching 
          boolean isExists = traverseDFS(board, n, m, nextX, nextY, word, curWord + board[nextX][nextY], visited);
          if (isExists) {
            return true;
          }
        }

      }
    }
    visited[x][y] = 0;

    return false;
  }

  boolean isValid(int n, int m, int x, int y) {
    if (x >= 0 && y >= 0 & x < n && y < m) {
      return true;
    }
    return false;
  }
}
