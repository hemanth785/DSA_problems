package Backtracking;
/*
 * Given an integer array nums of unique elements, return all possible subsets(the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * link: https://leetcode.com/problems/subsets/
 */
public class PrintAllSubsets {
  
}

/*
 * Recursive approach
 */

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> tempList = new ArrayList<Integer>();
    getSubsetsRecursive(nums, resultList, tempList, 0);
    return resultList;
  }
  public static void getSubsetsRecursive(int[] nums, List<List<Integer>> resultList, List<Integer> tempList, int l){
    if(l == nums.length){
        List<Integer> copiedList = new ArrayList<Integer>(tempList);
        resultList.add(copiedList);
        return;
    }
    tempList.add(nums[l]);
    getSubsetsRecursive(nums, resultList, tempList, l+1);
    tempList.remove(tempList.size()-1);

    getSubsetsRecursive(nums, resultList, tempList, l+1);
  }
}

/*
 * Iterative approach
 * [],
 * [] + [1]
 * [],[1] + [2] [1, 2]
 * [],[1] [2] [1, 2] + [3],[1, 3] [2, 3] [1, 2, 3]
 * 
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //initialize the resultList with empty set element
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<Integer>());

        //for each element, loop over exisisting resultSet elements,
        // copy all the elements
        // add the current item(num[i]) to copied elements
        // add the copied elements to resultSet 
        for(int i=0; i<nums.length; i++){
            List<List<Integer>> tempResList = new ArrayList<>();
            for(List<Integer> list : resultList){
                List<Integer> tempList = new ArrayList<Integer>(list);
                tempList.add(nums[i]);
                tempResList.add(tempList);
            }
            resultList.addAll(tempResList);
        }
        return resultList;
    }
}
