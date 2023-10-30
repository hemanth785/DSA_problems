package Matrix;

import java.util.HashSet;
import java.util.Set;

/*
 * link: https://workat.tech/problem-solving/practice/row-column-zero
 */
public class RowColumnZero {
  /*
   * Naive approach: Wrong
   * One naive solution that comes to mind is to scan the 2D matrix and, if a zero is found, 
   * make the entire column and row zero. 
   * However, this is incorrect; even if there is only one zero in the matrix, the entire matrix will be zero.
   */

  /*
   * Correct approach: Efficient
   * USING TWO SETS
   * We can record the row and column numbers of each cell in the matrix that has a zero. In the next cycle, all of the cells in this recorded row and column can be set to zero.
   */

  public void setZeroes(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> cols = new HashSet<Integer>();

    // Essentially, we mark the rows and columns that are to be made zero
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    // Iterate over the array once again and using the rows and cols sets, update
    // the elements.
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
