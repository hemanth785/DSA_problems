package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Matrix;

public class A06_Search_in_row_column_sorted_matrix {
  /*
   * Approach: Using Binary search
   * - We can observe that, top right matrix element we can consider as the middle element.
   * - compare it with target, if it equals return true
   * - else if, target is lesser than mid element, decrement column
   * - else if, target is greater than mid element, icrement row
   */
  static boolean search(int matrix[][], int n, int m, int x) 
	{  
    //consider top right corner as mid item
    int row = 0;
    int col = m-1;
    
    while(row >= 0 && col >= 0 && row < n && col < m){
      int midItem = matrix[row][col];
      if(x == midItem){
        return true;
      } else if(x < midItem){
        col--;
      } else {
        row++;
      }
    }
    
    return false;
} 
}
