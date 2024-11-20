package DP;

/*
 * Link: https://leetcode.com/problems/count-square-submatrices-with-all-ones
 */
public class A16_Count_square_submatrices_with_1s {
  /*
   * Approach 1: Bruteforce
   * 
   * Time: O(n^2*m^2)
   */

  static int count;
  public int countSquares(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int maxSize = Math.min(n, m);

    count = 0;

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        for(int k=1; k<=maxSize; k++){
          if(k == 1 && matrix[i][j] == 1){
            count++;
          } else {
            if(checkForSquareMatrixWithOnes(matrix, n, m, i, j, k)){
              count++;
            }
          }
        }
      }
    }

    return count;
  }
 
  public boolean checkForSquareMatrixWithOnes(int[][] matrix, int n, int m, int startRow, int startCol, int size){
    for(int i=startRow; i<startRow+size; i++){
      for(int j=startCol; j<startCol+size; j++){
        if(i>=n || j>=m || matrix[i][j] != 1){
          return false;
        }
      }
    }

    return true;
  }

  /*
   * Approach 2: DP Tabulation
   * - create a DP matrix of size same as given matrix
   * - Fill 1st row and 1st column of dp matrix with same elements as given matrix (each cell in dp matrix signifies number of square matrix till that point as bottom right)
   * - Then iterate through each cell, while calculating square matrix based on already calculated square matrix in previous cells
   * - i.e 
   *    Step 1: Check if current cell has 1 (If it has 0, directly fill 0)
   *    Step 2: If it has '1', then take min count among - top, left, top-left cells and add 1 to it
   *    Continue this for all the other cells
   * - Loop through each cell of DP matrix to calculate the total number of square matrix with 1
   * 
   * Time: O(n*m), Space: O(n*m)
   */
  public int countSquaresDP(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int dp[][] = new int[n][m];

    //populate 1st row as same as matrix
    for(int col=0; col<m; col++){
      dp[0][col] = matrix[0][col];
    }

    //populate 1st col as same as matrix
    for(int row=0; row<n; row++){
      dp[row][0] = matrix[row][0];
    }

    //now popluate square count for others cells
    for(int i=1; i<n; i++){
      for(int j=1; j<m; j++){
        if(matrix[i][j] == 1){
          //Take min square counts among - top, left, and top-left and 1 to it
          dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        }
      }
    }

    //loop through dp to get the total count of square matrix
    int totalSquareMatrix = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        totalSquareMatrix += dp[i][j];
      }
    }

    return totalSquareMatrix;
  }
}
