package Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

/*
 * Link: https://leetcode.com/problems/jump-game-ii/
 */
public class A11_Jump_game_2 {
  /*
   * Approach 1: Using backtracking
   * 
   * Time: O(n^2)
   */


  /*
   * Approach 2: Using Greedy approach
   * - initialize 2 pointer, l and r as '0'
   * - for each position, calculate lowest and farthest we can reach from current range
   * - for each iteration, loop through left and right pointer, which calculating farthest point from current range
   * - aftre traversal, mark l as r+1, and r=farthest | ans also increment jump count after traversinng each range
   * 
   * - once r reaches end of array, stop iteration. and return jump count
   * 
   * Time: O(n), Space: O(1)
   * Solution link: https://www.youtube.com/watch?v=7SBVnw7GSTk
   */
  public int jump(int[] nums) {
    int n = nums.length;
    int jumps = 0;
    int l = 0;
    int r = 0;

    while(r < n-1){ 
      int farthest = 0;

      for(int i=l; i<=r; i++){
        farthest = Math.max(farthest, i+nums[i]);
      }

      l = r+1;
      r = farthest;

      jumps++;
    }

    return jumps;
  }
}
