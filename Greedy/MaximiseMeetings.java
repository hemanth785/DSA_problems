package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * link: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 */
public class MaximiseMeetings {
  /*
   * Approach 1: give priority to short duration meetings
   * 
   * This might not be the best solution, we might end up giving room for meeting which comes late
   */


  /*
   * Approach 2: give priority to the meeting which ends early
   * 
   * - sort meeting based on their 'end time'
   * - loop through each meeting while keep end time of last meeting,
   * - if start time of cur meeting is grater than, end time of last meeting. increase meeting count.
   * 
   * Time: n * log(n), space: O(n)
   */
  static class Meeting {
    int start, end;

    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static int maxMeetings(int start[], int end[], int n) {
    List<Meeting> meetingList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      meetingList.add(new Meeting(start[i], end[i]));
    }
    // int slotsFilled[] = new int[maxTime+1];
    // Arrays.fill(slotsFilled, 0);

    // sort meeting based on duration
    Collections.sort(meetingList, (a, b) -> {
      return a.end - b.end;
    });

    int meetingCount = 0;
    int curEndTime = -1;
    for (Meeting meeting : meetingList) {
      int endTime = meeting.end;
      int startTime = meeting.start;
      if (curEndTime < startTime) {
        curEndTime = endTime;
        meetingCount++;
      }
    }
    return meetingCount;
  }
}
