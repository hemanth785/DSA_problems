package Graph;

import java.util.Queue;
import java.util.LinkedList;
import javafx.util.Pair;

/*
 * Link: https://leetcode.com/problems/rotting-oranges/description/
 */

public class A_12_RottingOranges {
  
  public int[] xMoves = { 0, 1, 0, -1 };
  public int[] yMoves = { 1, 0, -1, 0 };

  public boolean isSafe(int[][] grid, int m, int n, int i, int j) {
    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != 0) {
      return true;
    }
    return false;
  }

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int visited[][] = new int[m][n];

    // find the initial rotten orange, there can be multiple rotten oranges initially
    Queue<Pair<Integer, Integer>> rottenOranges = new LinkedList<>();
    int orangesCount = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          rottenOranges.add(new Pair(i, j));
          visited[i][j] = 1;
        } else if (grid[i][j] == 1) {
          orangesCount++;
        }
      }
    }

    //this is important
    if (orangesCount == 0) {
      return 0;
    }
    if (rottenOranges.size() == 0) {
      return -1;
    }

    int numberOfMins = 0;
    while (!rottenOranges.isEmpty()) {
      int rottenCount = rottenOranges.size();
      boolean isOrangesToRotFound = false;

      for(int r=0; r<rottenCount; r++){
        Pair rottenOrange = rottenOranges.remove();
        int x = (int) rottenOrange.getKey();
        int y = (int) rottenOrange.getValue();

        for (int i = 0; i < xMoves.length; i++) {
          int nextX = x + xMoves[i];
          int nextY = y + yMoves[i];
          if (isSafe(grid, m, n, nextX, nextY) && visited[nextX][nextY] != 1 && grid[nextX][nextY] == 1) {
            isOrangesToRotFound = true;
            visited[nextX][nextY] = 1;
            grid[nextX][nextY] = 2;
            rottenOranges.add(new Pair(nextX, nextY));
          }
        }
      }

      if (isOrangesToRotFound) {
        numberOfMins++;
      }
    }

    // check if any unrotted still present in array
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }
    return numberOfMins;
  }
}
