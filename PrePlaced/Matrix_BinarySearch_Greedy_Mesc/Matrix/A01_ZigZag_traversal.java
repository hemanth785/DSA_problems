package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Matrix;

import java.util.Arrays;

public class A01_ZigZag_traversal {
  public static void main(String[] args) {
    int matrix[][] = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
          }; 

    int[] zigZag = zigZagTrvarsal(matrix);
    System.out.println("zig zag traversla of matrix is: "+Arrays.toString(zigZag));
  }

  static int[] zigZagTrvarsal(int matrix[][]){
    int n = matrix.length;
    int m = matrix[0].length;

    int res[] = new int[n*m];
    int k = 0;
    boolean isLeftToRight = true;
    for(int i=0; i<n; i++){
      if(isLeftToRight){
        for(int j=0; j<m; j++){
          res[k++] = matrix[i][j];
        } 
        isLeftToRight = false;
      } else {
        for(int j=m-1; j>=0; j--){
          res[k++] = matrix[i][j];
        } 
        isLeftToRight = true;;
      }
    }

    return res;
  }
}
