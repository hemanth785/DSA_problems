package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
  public void solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;

    int notPossible[][] = new int[n][m];
    // traverse boundary of board to mark connected cells as not possible
    // check top row
    int row = 0;
    for (int i = 0; i < m; i++) {
      if (board[row][i] == 'O' && notPossible[row][i] == 0) {
        BFS(board, notPossible, n, m, row, i);
      }
    }
    // bottom row
    row = n - 1;
    for (int i = 0; i < m; i++) {
      if (board[row][i] == 'O' && notPossible[row][i] == 0) {
        BFS(board, notPossible, n, m, row, i);
      }
    }

    // leftmost col
    int col = 0;
    for (int i = 0; i < n; i++) {
      if (board[i][col] == 'O' && notPossible[i][col] == 0) {
        BFS(board, notPossible, n, m, i, col);
      }
    }

    // rightmost col
    col = m - 1;
    for (int i = 0; i < n; i++) {
      if (board[i][col] == 'O' && notPossible[i][col] == 0) {
        BFS(board, notPossible, n, m, i, col);
      }
    }

    // replace all eligible field with "X"
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'O' && notPossible[i][j] == 0) {
          board[i][j] = 'X';
        }
      }
    }
  }

  static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int adjX[] = { 0, 1, 0, -1 };
  static int adjY[] = { 1, 0, -1, 0 };

  public void BFS(char[][] board, int notPossible[][], int n, int m, int x, int y) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y));
    notPossible[x][y] = 1;

    while (!queue.isEmpty()) {
      Point point = queue.remove();

      for (int i = 0; i < adjX.length; i++) {
        int nextX = point.x + adjX[i];
        int nextY = point.y + adjY[i];
        if (isValid(n, m, nextX, nextY) && notPossible[nextX][nextY] == 0 && board[nextX][nextY] == 'O') {
          queue.add(new Point(nextX, nextY));
          notPossible[nextX][nextY] = 1;
        }
      }
    }
  }

  boolean isValid(int n, int m, int x, int y) {
    if (x >= 0 && y >= 0 & x < n && y < m) {
      return true;
    }
    return false;
  }
}
