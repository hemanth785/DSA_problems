package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/assign-cookies/
 */
public class A09_Assign_cookie_easy {
  /*
   * Approach: Sorting both greed and cookie arrays
   * - start checking feasibility for largest cookie for highest greed student
   * - If it is feasible - assign that cookie to that student, and decrement both index
   * - If is not feasible - check this cookie feasibility for less greed student
   * - run this iteration until either cookie or greed index becomes less than 0
   */
  public int findContentChildren(int[] greed, int[] cookie) {
    Arrays.sort(greed);
    Arrays.sort(cookie);

    int gi = greed.length-1;
    int ci = cookie.length-1;

    int contentStudents = 0;
    while(gi >=0 && ci >= 0){
      if(cookie[ci] >= greed[gi]){
        contentStudents++;
        gi--;
        ci--;
      } else {
        gi--;
      }
    }

    return contentStudents;
  }
}
