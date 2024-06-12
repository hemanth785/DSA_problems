package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://workat.tech/problem-solving/practice/combination-sum-1
 * 
 * hint: This is same as the coin change 2 in DP, here we need to print the combinations (denominations)
 */
public class CombinationSum_using_duplicate_item {
	List<List<Integer>> combinationSum(int[] A, int target) {
	  List<List<Integer>> resList = new ArrayList<>();
		List<Integer> combList = new ArrayList<>();
		
		combinationSumRec(A, target, 0, 0, resList, combList);
		
		return resList;
	}
	
	void combinationSumRec(int[] A, int target, int curSum, int index, List<List<Integer>> resList, List<Integer> combList){
		if(curSum == target){
			resList.add(new ArrayList<>(combList));
			return;
		}
		if(curSum > target || index >= A.length){
			return;
		}

		for(int amount=curSum; amount <= target; amount += A[index]){
			int n = (amount-curSum)/A[index];
			for(int i=0; i<n; i++){
				combList.add(A[index]);
			}
			combinationSumRec(A, target, amount, index+1, resList, combList);
			for(int i=0; i<n; i++){
				combList.remove(combList.size()-1);
			}
		}
	}
}
