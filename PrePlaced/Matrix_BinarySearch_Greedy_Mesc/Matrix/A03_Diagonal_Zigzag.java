package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Matrix;
/*
 * Link: https://leetcode.com/problems/diagonal-traverse/
 */
public class A03_Diagonal_Zigzag {
  public int[] findDiagonalOrder(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    if(n == 0 || m == 0) return new int[0];

    int res[] = new int[n*m];
    int k = 0;

    int row = 0;
    int col = 0;

    boolean up = true;

    while(row < n && col < m){
      //up case
      if(up){
        while(row > 0 && col < m-1){
          res[k++] = mat[row][col];
          row--;
          col++;
        }
        res[k++] = mat[row][col];

        if(col == m-1){
          row++;
        } else {
          col++;
        }

      //down case
      } else {
        while(col > 0 && row < n-1){
          res[k++] = mat[row][col];
          row++;
          col--;
        }
        res[k++] = mat[row][col];
        if(row == n-1){
          col++;
        } else {
          row++;
        }
      }
      
      up = !up;
    }

    return res;
  }
}
