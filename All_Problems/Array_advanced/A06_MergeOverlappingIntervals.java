package Array_advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A06_MergeOverlappingIntervals {
  public int[][] merge(int[][] intervals) {
    // 1. Sort the intervals bases on their start time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // create a list to store merged interval
    List<int[]> mergedList = new ArrayList<>();
    mergedList.add(intervals[0]);

    int[] prevInterval = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      int[] curInterval = intervals[i];
      // check if startTime of cur interval is less than or equal to endTime of
      // previous interval
      // - if yes, this needs to be merged
      if (curInterval[0] <= prevInterval[1]) {
        // if endTime of cur interval is greater than, endTime of prev interval,
        // - Then update the end time of previous interval
        if (curInterval[1] > prevInterval[1]) {
          prevInterval[1] = curInterval[1];
        }
      } else {
        mergedList.add(curInterval);
        prevInterval = curInterval;
      }
    }

    // move intervals from list to Array
    int mergedArr[][] = new int[mergedList.size()][2];
    for (int i = 0; i < mergedList.size(); i++) {
      mergedArr[i] = mergedList.get(i);
    }

    return mergedArr;
  }
}
