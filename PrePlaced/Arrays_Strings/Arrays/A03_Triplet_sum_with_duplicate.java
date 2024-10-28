package PrePlaced.Arrays_Strings.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/3sum/description/
 */
public class A03_Triplet_sum_with_duplicate {
  public List<List<Integer>> threeSum(int[] A) {
    Arrays.sort(A);
		int n = A.length;
		List<List<Integer>> triplets = new ArrayList<>();
		
    int prev = Integer.MIN_VALUE;
		for(int i=0; i<n-2; i++){
      if(prev != A[i]){
          getPairEqualToSum(A, i+1, n-1, triplets, A[i]);
      }
      prev = A[i];
		}
		
		return triplets;
	}
	
	void getPairEqualToSum(int[] A, int l, int r, List<List<Integer>> triplets, int cur){
		System.out.println(l+" - "+r);
		int sumNeeded = 0 - cur;
		int prev = Integer.MIN_VALUE;

		while(l<r){
			if(prev != A[l] && A[l] + A[r] == sumNeeded){
				List<Integer> triplet = new ArrayList<>();
				triplet.add(cur);
				triplet.add(A[l]);
				triplet.add(A[r]);
				
				triplets.add(triplet);
				prev = A[l];
				l++;
				r--;
			} else if(A[l] + A[r] < sumNeeded){
				l++;
			} else {
				r--;
			}
		}
	}
}
