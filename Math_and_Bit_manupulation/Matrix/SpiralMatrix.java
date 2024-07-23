package Math_and_Bit_manupulation.Matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
  /*
   * Solution: https://www.youtube.com/watch?v=3Zv-s9UUrFM
   */
  /*
   * Approach: (only one approach exists)
   * - Define the boundaries - top, bottom, left, right
   * - traverse the matrix starting from [0,0], through boundary in all 4 directions, while addint items to arrayList
   * - while while traversing keep checking for conditon (top <= bottom && left <= right)
   * - at any point above condition fails, break the loop over there
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int top = 0;
    int left = 0;
    int right = m - 1;
    int bottom = n - 1;

    List<Integer> result = new ArrayList<>();

    while (top <= bottom && left <= right) {
      // 1. top right
      int row1 = top;
      for (int col1 = left; col1 <= right; col1++) {
        result.add(matrix[row1][col1]);
      }
      top++;
      if (top > bottom) {
        break;
      }

      // 2. right bottom
      int col2 = right;
      for (int row2 = top; row2 <= bottom; row2++) {
        result.add(matrix[row2][col2]);
      }
      right--;

      if (right < left) {
        break;
      }

      // 3. bottom left
      int row3 = bottom;
      for (int col3 = right; col3 >= left; col3--) {
        result.add(matrix[row3][col3]);
      }
      bottom--;
      if (top > bottom) {
        break;
      }

      // 4. left top
      int col4 = left;
      for (int row4 = bottom; row4 >= top; row4--) {
        System.out.println("here 4");
        result.add(matrix[row4][col4]);
      }
      left++;
    }

    return result;
  }
}
