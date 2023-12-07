package Backtracking;

/*
 * Link: https://workat.tech/problem-solving/practice/tug-of-war
 */
public class TugOfWar {

  /*
   * Approach: 
   * Time: O(2^n), Space: O(1)
   */
  int divideGroup(int[] A) {
		int n = A.length;
		return devideGroupRec(A, n, 0, 0, 0, 0, 0);
	}
	
	int devideGroupRec(int[] A, int n, int index, int count1, int count2, int sum1, int sum2){
		if(index == n){
			if(Math.abs(count1 - count2) <= 1){
				return Math.abs(sum1-sum2);
			} else {
				return Integer.MAX_VALUE;
			}
			
		}
		int leftDiff = devideGroupRec(A, n, index+1, count1+1, count2, sum1+A[index], sum2);
		int rightDiff = devideGroupRec(A, n, index+1, count1, count2+1, sum1, sum2+A[index]);
		
		return Math.min(leftDiff, rightDiff);
	}
}
