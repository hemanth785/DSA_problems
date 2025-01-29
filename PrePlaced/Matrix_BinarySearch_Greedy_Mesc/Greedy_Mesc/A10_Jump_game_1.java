package Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

/*
 * Link: https://leetcode.com/problems/jump-game/
 */
public class A10_Jump_game_1 {
  /*
   * Approach: Using dynamic programming
   * 
   * Time: O(n), Space: O(n)
   */

  /*
   * Approach: using Greedy approach
   * - Start from endpoint (goal), and check if we can reach start pointer
   * - initially mark last point as goal and start checking from last but one pointer
   * - calculate distance between goal and current pointer
   * - if current pos has jump number greater than distance, then mark current pos as goal 
   *  - Else check for next previous position
   *
   * - once we exhaust iteration, check if goal has reached to 0th index.
   * 
   * Time: O(n), Space: O(1) 
   */
  
  public boolean canJump(int[] nums) {
    int n = nums.length;
    int goal = n-1;

    //check if we can reach start from goal (Greedy)
    for(int i=n-2; i>=0; i--){
      int distance = goal - i;
      if(nums[i] >= distance){
        goal = i;
      }
    }

    return goal == 0;
  }
}
