package Backtracking;
/*
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. 
 * It has to reach the destination at (N - 1, N - 1). 
 * Find all possible paths that the rat can take to reach from source to destination. 
 * The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right)
 * Rat can only move through cells, which marked as 1.
 * 
 * Input:
 * N = 4
 * m[][] = {{1, 0, 0, 0},
 *          {1, 1, 0, 1}, 
 *          {1, 1, 0, 0},
 *          {0, 1, 1, 1}}
 * Output:
 *  DDRDRR DRDDRR
 * Explanation:
 *  The rat can reach the destination at 
 *  (3, 3) from (0, 0) by two paths - DRDDRR 
 *  and DDRDRR, when printed in sorted order 
 *  we get DDRDRR DRDDRR.
 */
public class Rat_in_maze {
  static int[] rowMoves = {0, 1, 0, -1};
  static int[] colMoves = {1, 0, -1, 0};
  static char[] direction = {'R', 'D', 'L', 'U'}; //Rat has 4 possible moves at each position in maze

  public static void main(String[] args) {
    int[][] maze =  {{1, 0, 0, 0},
                      {1, 1, 1, 1}, 
                      {1, 1, 0, 1},
                      {0, 1, 1, 1}};
    int n = maze.length;
    
    //possible moves for a rat in maze at each position
    int[][] visited = new int[n][n];
    for(int i=0; i<n; i++){
      for(int j=0;j<n;j++){
        visited[i][j] = -1;
      }
    }

    int row = 0;
    int col = 0;

    findPathForRat(n, row, col, maze, visited, "");
  }

  private static void findPathForRat(int n, int row, int col, int[][] maze, int[][] visited, String path){
    if(row == n-1 && col == n-1){
      System.out.println(path); //we have to print here, since we need to find out all possible paths to destination
      return;
    }

    for(int i=0; i<direction.length; i++){
      int nextRow = row + rowMoves[i];
      int nextCol = col + colMoves[i];
      boolean isSafe = isSafe(n, nextRow, nextCol, maze);
      if(isSafe && visited[nextRow][nextCol] == -1){
        visited[nextRow][nextCol] = 1;
        findPathForRat(n, nextRow, nextCol, maze, visited, path+direction[i]); 
        /*
        * THING TO NOTICE:
        * Here for path, we are not storing the path in variable, 
        * for each recursion call we are creating new variable and that is only valid until that function call is returned. 
        * thats why we are printing path at line:  51
        */

        visited[nextRow][nextCol] = -1; // this is to enable exploring next possible paths
      }
    }

    return; //this return executes only after all the possible moves exausted for all the posisiton: END OF PROGRAM

  }


  
  private static boolean isSafe(int n, int nextRow, int nextCol, int[][] maze){
    if(nextRow >= 0 && nextRow < n &&
      nextCol >= 0 && nextCol < n &&
      maze[nextRow][nextCol] == 1
    ) {
      return true;
    }
    return false;
  }


  /*
   * Time complexity: O(4^n^2)
   * Space complexity: O(n^2), extra size used for visited matrix
   */
}
