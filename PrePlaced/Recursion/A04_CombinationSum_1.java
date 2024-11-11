package PrePlaced.Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/combination-sum/
 * 
 * hint: This is same as the coin change 2 in DP, here we need to print the combinations (denominations)
 */
public class A04_CombinationSum_1 {
	List<List<Integer>> combinationSum(int[] candidates, int target) {
	  List<List<Integer>> resList = new ArrayList<>();
		List<Integer> combList = new ArrayList<>();
		
		combinationSumRec(candidates, target, 0, resList, combList);
		
		return resList;
	}
	
	public void combinationSumRec(int candidates[], int target, int index, List<List<Integer>> result, List<Integer> tempRes) {
    if (target == 0) {
      result.add(new ArrayList<>(tempRes));
      return;
    }
    if (target < 0 || index >= candidates.length) {
      return;
    }

    int curItem = candidates[index];

    // include same item multiple times, because we are not updating index here
    tempRes.add(curItem);
    combinationSumRec(candidates, target - curItem, index, result, tempRes);
    tempRes.remove(tempRes.size() - 1);

    // exclude current coin
    combinationSumRec(candidates, target, index + 1, result, tempRes);
  }
}
