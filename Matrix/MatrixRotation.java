/*
 * Rotate matrix by 90 degree
 * link: https://leetcode.com/problems/rotate-image/
 */


 /*
  * Approach: 2 steps
  * 1. Find the transpose of a matrix
  * 2. Reverse the each row


    Note: this code only works for N*N matrix (Row size == col size), as inplace rotation will not work for n*m
    because, rotation of n*m matrix becomes m*n, that mean we cannot store result in original matrix,
    we need to create a new matrix for that
  */
public class MatrixRotation {
  int m = matrix.length;
  int n = matrix[0].length;
    
    //convert the given matrix to transpose of matrix
    for(int i=0; i<m-1; i++){
      for(int j=i+1; j<n; j++){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    //reverse the elements in each row
    for(int i=0; i<m; i++){
      for(int j=0; j<n/2; j++){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n-j-1];
        matrix[i][n-j-1] = temp;
      }
    }
  return matrix;
}
