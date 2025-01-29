package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Matrix;

import java.util.Arrays;

public class A02_Diaganal_traversal {
  public static void main(String[] args) {
    int matrix[][] = {
            {1,  2,  3,  4,  5},
            {6,  7,  8,  9,  10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
          }; 

    int[] diagonal = diagonalTraversal(matrix);
    System.out.println("Diagonal traversal of matrix is: "+Arrays.toString(diagonal));
  }

  static int[] diagonalTraversal(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    int res[] = new int[n*m];
    int k = 0;

    int row = 0;
    int col = 0;

    //print top left part of matrix diagonal (1st half)
    while(row < n){
      int prevStartRow = row;
    
      while(row >=0 && col < m){
        res[k++] = mat[row][col];

        col++;
        row--;
      }

      col = 0;
      row = prevStartRow+1;
    }

    //print bottom right part of diagonal
    col = 1;
    row = n-1;
    while(col < m){
      int prevStartCol = col;

      while(row >=0 && col < m){
        res[k++] = mat[row][col];

        col++;
        row--;
      }

      row = n-1;
      col = prevStartCol + 1;
    }

    return res;
  }
}
