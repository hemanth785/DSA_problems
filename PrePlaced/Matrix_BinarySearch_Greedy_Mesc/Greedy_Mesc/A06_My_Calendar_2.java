package Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/my-calendar-ii/
 */
public class A06_My_Calendar_2 {
  /*
   * Approach: Using 2 lists
   * - One list for storing the calendar events
   * - 2nd list for storing overlapping intervals (Intervals having double booking)
   * - Before adding new event, check if this new event overlaps with, overlaping intervals
   *    - If Yes, return false
   * - Then check if this new event, overlaps with already exisiting calendar events
   *    - If Yes, then add the overlapping intervals to overlapping intervals list
   * - Add event to calendar list
   */
  List<int[]> calendar;
  List<int[]> overlapping;
  public A06_My_Calendar_2() {
    calendar = new ArrayList<>();
    overlapping = new ArrayList<>();
  }
  
  public boolean book(int start, int end) {
    //1. check if current event overlaps with already overlapping timeline
    for(int[] event: overlapping){
      int s = event[0];
      int e = event[1];

      if(! (end <= s || start >= e)){
        return false;  //if its overlapping, that means it would cause tripple booking
      }
    }

    for(int[] event: calendar){
      int s = event[0];
      int e = event[1];

      if(! (end <= s || start >= e)){
        int overlappingStart = Math.max(start, s);
        int overlappingEnd = Math.min(end, e);
        
        overlapping.add(new int[]{overlappingStart, overlappingEnd}); //Add it to overlapping list (double booking)
      }
    }
    calendar.add(new int[]{start, end});
    return true;

  }
}
