// Link: https://workat.tech/problem-solving/practice/matrix-search

public class MatrixSearch {
  /*
   * Approach 1: Lenear searching
   */

  /*Approach 2: Copy matrix into lenear arraya nd apply binary search */

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
			int i = mid/cols;
			int j = mid%cols;
			if(matrix[i][j] == key){
				return true;
			} else if(key < matrix[i][j]){
				r = r-1;
			} else {
				l = l+1;
			}
		}
		return false;
	}
}
