package Graph;
import java.util.Queue;
import java.util.LinkedList;
import javafx.util.Pair;

public class NumberOfIslands {
  
  public int[] xMoves = { 0, 1, 0, -1 };
  public int[] yMoves = { 1, 0, -1, 0 };

  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] visited = new int[m][n];

    int islandCount = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1' && visited[i][j] != 1) {
          islandCount++;
          visited[i][j] = 1;
          traverseBFS(grid, visited, m, n, i, j); // need to fill
        }
      }
    }
    return islandCount;
  }

   public boolean isSafe(int[][] visited, int m, int n, int i, int j) {
    if (i >= 0 && i < m && j >= 0 && j < n) {
      return true;
    }
    return false;
  }

  //Apporach 1: Using BFS
  public void traverseBFS(char[][] grid, int[][] visited, int m, int n, int i, int j) {
    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    queue.add(new Pair(i, j));

    while (!queue.isEmpty()) {
      System.out.println("hello");
      Pair node = queue.remove();
      int x = (int) node.getKey();
      int y = (int) node.getValue();

      for (int k = 0; k < xMoves.length; k++) {
        int nextX = x + xMoves[k];
        int nextY = y + yMoves[k];

        if (isSafe(visited, m, n, nextX, nextY)
            && grid[nextX][nextY] == '1'
            && visited[nextX][nextY] != 1) {
          visited[nextX][nextY] = 1;
          queue.add(new Pair(nextX, nextY));
        }
      }
    }
  }

  //Apporach 1: Using DFS
  public void dfsRecursive(char[][] grid, int[][] visited, int m, int n, int i, int j) {
    visited[i][j] = 1;

    // visit all 4 possible directions
    for (int k = 0; k < 4; k++) {
      int tempRow = i + xMoves[k];
      int tempCol = j + yMoves[k];
      if (isSafe( visited, m, n, tempRow, tempCol)) {
        dfsRecursive(grid, visited, m, n, tempRow, tempCol);
      }
    }
  }

 
}
