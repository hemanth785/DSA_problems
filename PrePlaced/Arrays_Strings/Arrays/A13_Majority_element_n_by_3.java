package PrePlaced.Arrays_Strings.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/majority-element-ii
 */
public class A13_Majority_element_n_by_3 {
  /*
   * Approach 1: Using hashmap
   * 
   * Time: O(n), Space: O(n)
   */


  /*
   * Approach 2: without using hashmap (Efficient)
   * 
   * Initialize 4 variables:
   *  - cnt1 & cnt2 –  for tracking the counts of elements
   *  - el1 & el2 – for storing the majority of elements.
   * 
   * Traverse through the given array.
   *  - If cnt1 is 0 and the current element is not el2 then store the current element of the array as el1 along with increasing the cnt1 value by 1.
   *  - If cnt2 is 0 and the current element is not el1 then store the current element of the array as el2 along with increasing the cnt2 value by 1.
   *  - If the current element and el1 are the same increase the cnt1 by 1.
   *  - If the current element and el2 are the same increase the cnt2 by 1.
   * 
   * Other than all the above cases: decrease cnt1 and cnt2 by 1.
   * 
   * Time: O(n), Space: o(1)
   */
  public List<Integer> majorityElement(int[] nums) {
    int n = nums.length;

    int el1 = Integer.MIN_VALUE;
    int el2 = Integer.MIN_VALUE;

    int count1 = 0;
    int count2 = 0;

    //find probable majority elements
    for(int i=0; i<nums.length; i++){
      int item = nums[i];

      if(count1 == 0 && item != el2){
        count1++;
        el1 = item;
        continue;
      } 
      if(count2 == 0 && item != el1){
        count2++;
        el2 = item;
        continue;
      } 
      if(item == el1){
        count1++;
      } else if(item == el2){
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    //verify mejority elements
    count1 = 0;
    count2 = 0;
    for(int i=0; i<nums.length; i++){
      if(nums[i] == el1){
        count1++;
      }
      if(nums[i] == el2){
        count2++;
      }
    }

    List<Integer> majorityElements = new ArrayList<>();
    if(count1 > n/3){
      majorityElements.add(el1);
    }
    if(count2 > n/3){
      majorityElements.add(el2);
    }

    return majorityElements;
  }
}
