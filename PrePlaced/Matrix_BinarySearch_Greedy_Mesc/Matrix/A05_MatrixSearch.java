package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Matrix;

// Link: https://leetcode.com/problems/search-a-2d-matrix/

public class A05_MatrixSearch {
  /*
   * Approach 1: Lenear searching
   */

  /* Approach 2: Copy matrix into lenear array nd apply binary search */

  /*
   * Approach 3: Apply binary search directly on matrix
   * 
   * Time: Log(n)
   */
  boolean searchMatrix(int[][] matrix, int key){
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int k = rows * cols;
		
		int l=0;
		int r = k-1;
		while(l<=r){
			int mid = l + ((r-l)/2);
			int i = mid/cols; //gives row from mid
			int j = mid%cols; // gives col from mid
			if(matrix[i][j] == key){
				return true;
			} else if(key < matrix[i][j]){
				r = mid-1;
			} else {
				l = mid+1;
			}
		}
		return false;
	}
}
