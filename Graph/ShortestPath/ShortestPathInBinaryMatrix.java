/*
 * link: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */

public class ShortestPathInBinaryMatrix {

  public static int[] xMoves = { 0, 1, 0, -1, 1, 1, -1, -1 };
  public static int[] yMoves = { 1, 0, -1, 0, 1, -1, 1, -1 };

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    int distance[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          distance[i][j] = Integer.MAX_VALUE;
        } else {
          distance[i][j] = -1;
        }
      }
    }

    Queue<Pair> queue = new LinkedList<>();
    //add src node to queue only if it is valid in matrix
    if (distance[0][0] != -1) {
      distance[0][0] = 1;
      queue.add(new Pair(0, 0));
    }

    while (!queue.isEmpty()) {
      Pair node = queue.remove();
      int x = node.row;
      int y = node.col;

      for (int i = 0; i < xMoves.length; i++) {
        int nextX = x + xMoves[i];
        int nextY = y + yMoves[i];

        if (
          isValidDirection(n, nextX, nextY, grid) &&
          distance[x][y] + 1 < distance[nextX][nextY]
        ) {
          distance[nextX][nextY] = distance[x][y] + 1;
          queue.add(new Pair(nextX, nextY));
        }
      }
    }

    return distance[n - 1][n - 1] != Integer.MAX_VALUE
      ? distance[n - 1][n - 1]
      : -1;
  }

  private boolean isValidDirection(int n, int i, int j, int[][] grid) {
    if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0) {
      return true;
    }
    return false;
  }

  public static class Pair {

    int row;
    int col;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
