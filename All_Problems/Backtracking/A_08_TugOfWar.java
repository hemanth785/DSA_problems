package Backtracking;

/*
 * Link: https://workat.tech/problem-solving/practice/tug-of-war
 */
public class A_08_TugOfWar {

  /*
   * Approach: 
   * Time: O(2^n), Space: O(1)
   */
  int divideGroup(int[] A) {
		int n = A.length;
		return devideGroupRec(A, n, 0, 0, 0, 0, 0);
	}
	
	int devideGroupRec(int[] A, int n, int index, int leftCount, int rightCount, int leftSum, int rightSum){
		if(index == n){
			if(Math.abs(leftCount - rightCount) <= 1){
				return Math.abs(leftSum-rightSum);
			} else {
				return Integer.MAX_VALUE;
			}
		}
		int addToLeft = devideGroupRec(A, n, index+1, leftCount+1, rightCount, leftSum+A[index], rightSum);
		int addToRight = devideGroupRec(A, n, index+1, leftCount, rightCount+1, leftSum, rightSum+A[index]);
		
		return Math.min(addToLeft, addToRight);
	}
}
