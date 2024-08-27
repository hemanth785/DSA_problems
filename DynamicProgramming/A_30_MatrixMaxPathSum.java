package DynamicProgramming;

public class A_30_MatrixMaxPathSum {
  public static void main(String[] args) {
    int M[][]={
      { 12, 22, 5, 0,  20,  18 },
      { 0,  2,  5, 25, 18,  17 },
      { 12, 10, 5, 4,  2,   1  },
      { 3,  8,  2, 20, 10,  8  }
    };

    int maxSum = findMaxPath(M);
    System.out.println(maxSum);
  }
  static int findMaxPath(int[][] M) {
	  int n = M.length;
		int m = M[0].length;
		
		int maxPathSum = Integer.MIN_VALUE;
		
		//start from the 2nd row
		for(int i=1; i<n; i++){
			maxPathSum = Integer.MIN_VALUE;
			for(int j=0; j<m; j++){
				if(j>0 && j<m-1){
					M[i][j] = M[i][j]+ Math.max(M[i-1][j], Math.max(M[i-1][j-1], M[i-1][j-1]));
				} else if(j < m - 1) {
					M[i][j] = M[i][j] + Math.max(M[i-1][j], M[i-1][j+1]);
				} else if(j > 0){
					M[i][j] = M[i][j] + Math.max(M[i-1][j], M[i-1][j-1]);
				}
				maxPathSum = Math.max(maxPathSum, M[i][j]);
			}
		}
		
		return maxPathSum;
	}
}
