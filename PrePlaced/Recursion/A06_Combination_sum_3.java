package PrePlaced.Recursion;

import java.util.ArrayList;
import java.util.List;

public class A06_Combination_sum_3 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<Integer> tempList = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    combinationSumRec(k, n, 1, 0, 0, tempList, res);

    return res;
  }

  public void combinationSumRec(int k, int target, int number, int sum, int count, List<Integer> tempList, List<List<Integer>> res){
    if(sum == target && count == k){
      res.add(new ArrayList<>(tempList));
      return;
    }

    if(number >= target || number > 9 || sum >= target){
      return;
    }
    
    //include
    tempList.add(number);
    combinationSumRec(k, target, number+1, sum+number, count+1, tempList, res);
    tempList.remove(tempList.size()-1);
    
    //exclude
    combinationSumRec(k, target, number+1, sum, count, tempList, res);
  }
}
