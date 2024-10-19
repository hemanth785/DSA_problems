package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/insert-interval/
 */
public class A07_Add_new_interval {
  /*
   * Approach: 
   * - check if new interval in occuring before current interval, 
   *    - if yes, then add new interval and rest of the existing intervals and break
   * - else check if new interval is happening after the current interval,
   *    - If yes, add current interval and move to next
   * - else if new interval is conflicting with current interval
   *    - Merge 2 intervals and store resulting interval in 'new interval'
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    if(n == 0){
      return new int[][]{newInterval};
    }
    List<int[]> mergedIntervalsList = new ArrayList<>();

    int start = newInterval[0];
    int end = newInterval[1];

    boolean isNewIntevalAdded = false;  

    for(int i=0; i<n; i++){
      int s = intervals[i][0];
      int e = intervals[i][1];

      //non-merge case
      if(end < s){
        isNewIntevalAdded = true;
        mergedIntervalsList.add(new int[]{start, end});

        //Once new interval added, add rest of the intervals as it is
        for(int j=i; j<n; j++){
          mergedIntervalsList.add(intervals[j]);
        }
        break;
      } 
      if(start > e){
        //add existing intervals
        mergedIntervalsList.add(intervals[i]);
      } else {
        //merge existing interval with new interval
        start = Math.min(start, s);
        end = Math.max(end, e);
      }
    }

    //check if we have added new interval to list
    if(!isNewIntevalAdded){
      mergedIntervalsList.add(new int[]{start, end});
    }
    
    //convert list to array
    int n2 = mergedIntervalsList.size();
    int[][] mergedIntervals = mergedIntervalsList.toArray(new int[n2][2]);

    return mergedIntervals;
  }
}
