package Matrix_BinarySearch_Greedy_Mesc.Matrix;

/*
 * Link: https://www.geeksforgeeks.org/problems/c-matrix-rotation-by-180-degree0745/1
 */
public class A08_Matrix_rotation_180 {
  /*
   * Approach: 
   * - Step 1: Swap elements in each row
   * - Step 2: Swap elements in each column
   */

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    // 1. Reverse row elements
    for (int i=0; i<n; i++) {
      for (int j=0; j<m/2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][m-j-1];
        matrix[i][m-j-1] = temp;
      }
    }

    // 2. Reverse column elements
    for (int j=0; j<m; j++) {
      for (int i=0; i<n/2; i++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n-i-1][j];
        matrix[n-i-1][j] = temp;
      }
    }
  }
}
