package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/combination-sum/
 * 
 * hint: This is same as the coin change 2 in DP, here we need to print the combinations (denominations)
 */
public class A_12_CombinationSum_using_same_item_multi_times {
	List<List<Integer>> combinationSum(int[] candidates, int target) {
	  List<List<Integer>> resList = new ArrayList<>();
		List<Integer> combList = new ArrayList<>();
		
		combinationSumRec(candidates, target, 0, resList, combList);
		
		return resList;
	}
	
	public void combinationSumRec(int[] candidates, int sumReq, int index, List<List<Integer>> result, List<Integer> tempRes){
    if(sumReq == 0){        
        result.add(new ArrayList<>(tempRes));
      return;
    }
    if(sumReq < 0){
      return;
    }
    if(index >= candidates.length){
      return;
    }

    int count = 0;
    int curItem = candidates[index];

    //for the given reqSum, check all these options - sumReq = 8, index = 0, arr = [2, 4]
    // 1st iteration - [], recCall(nextItem)
    // 1st iteration - [2], recCall(nextItem)
    // 2nd iteration - [2, 2], recCall(nextItem)
    // 2nd iteration - [2, 2, 2], recCall(nextItem)
    //...... 
    for(int amount=sumReq; amount>=0; amount = amount-curItem){
      combinationSumRec(candidates, amount, index+1, result, tempRes);

      tempRes.add(curItem); //we are adding the item to temp array after the 1st call, because we want to consider the case 'Not considering the current element'

      count++;
    }

    //remove the frequency of item added, so that we can check for another combination
    for(int i=0; i<count; i++){
      tempRes.remove(tempRes.size()-1);
    }
  }
}
