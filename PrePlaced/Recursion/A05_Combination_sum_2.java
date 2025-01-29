package PrePlaced.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/combination-sum-ii/
 */

public class A05_Combination_sum_2 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      
    Arrays.sort(candidates); //Important

    List<List<Integer>> res = new ArrayList<>();
    combinationSumRec(candidates, target, 0, 0, res, new ArrayList<>());
    return res;
  }

  public void combinationSumRec(int[] candidates, int target, int sumSoFar, int index, List<List<Integer>> res, List<Integer> tempRes){
    if(sumSoFar == target){
      res.add(new ArrayList<>(tempRes));
      return;
    }
    if(sumSoFar > target){
      return;
    }
    if(index >= candidates.length){
      return;
    }

    //include
    tempRes.add(candidates[index]);
    combinationSumRec(candidates, target, sumSoFar+candidates[index], index+1, res, tempRes);
    tempRes.remove(tempRes.size()-1);

    //exclude
    int nextIndex = index+1;
    while(nextIndex < candidates.length && candidates[nextIndex] == candidates[index]){
      nextIndex++;
    }

    combinationSumRec(candidates, target, sumSoFar, nextIndex, res, tempRes);
  }
}
