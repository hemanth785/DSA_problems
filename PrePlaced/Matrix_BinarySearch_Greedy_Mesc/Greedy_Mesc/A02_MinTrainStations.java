package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

import java.util.*;

/*
 * link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 */
public class A02_MinTrainStations {

  /*
   * Solution 1: Little complex code
   * - Here we are creating a class for storing each train timestamp - class{arrivalTime, departureTime}
   * - when first train comes, just add it to list of 'trainsAtStations'
   * - When more trains comnes, check if any other train is still at station, 
   *  - if some of the trains already left, remove it from the list 'trainsAtStations'
   * - At each stage, count the max number of trains at station
   */
  static class Schedule {
    int arrival, departure, index;

    Schedule(int arr, int dep, int index) {
      this.arrival = arr;
      this.departure = dep;
      this.index = index;
    }
  }

  static int findPlatform(int arr[], int dep[], int n) {
    List<Schedule> scheduleList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Schedule schedule = new Schedule(arr[i], dep[i], i);
      scheduleList.add(schedule);
    }

    Collections.sort(scheduleList, (a, b) -> a.arrival - b.arrival);
    int maxPlatforms = 0;
    List<Integer> trainsInStation = new ArrayList<>();

    for (Schedule schedule : scheduleList) {
      int curTrainArrival = schedule.arrival;

      if (trainsInStation.size() != 0) {
        Iterator<Integer> itr = trainsInStation.iterator();
        while (itr.hasNext()) {
          int index = itr.next();
          if (dep[index] < curTrainArrival) {
            itr.remove();
          }
        }
      }

      trainsInStation.add(schedule.index);
      maxPlatforms = Math.max(maxPlatforms, trainsInStation.size());
    }
    return maxPlatforms;
  }


  /*
   * Solution 2: Simple to understand
   * - Create a class for each event timestamp class{timestamp, everntType}, then sort it based on timestamp.
   * - loop through each event, if arrival is there increase count, if diparture is there decrease count
   */
  private static int ARRIVAL = 0;
  private static int DEPARTURE = 1;

  static class StationEvent {
    int time, eventType;

    StationEvent(int time, int eventType) {
      this.time = time;
      this.eventType = eventType;
    }
  }

  static int findMaxPlatform(int arr[], int dep[], int n) {
    List<StationEvent> eventList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StationEvent stationEventArr = new StationEvent(arr[i], ARRIVAL);
      StationEvent stationEventDep = new StationEvent(dep[i], DEPARTURE);
      eventList.add(stationEventArr);
      eventList.add(stationEventDep);
    }
    Collections.sort(eventList, (a, b) -> {
      if (a.time == b.time) {
        return a.eventType - b.eventType;
      }
      return a.time - b.time;
    });

    int maxPlatformsRequired = 0;
    int trainsAtPlatforms = 0;
    for (StationEvent stationEvent : eventList) {
      if (stationEvent.eventType == ARRIVAL) {
        trainsAtPlatforms++;
      } else {
        trainsAtPlatforms--;
      }
      maxPlatformsRequired = Math.max(maxPlatformsRequired, trainsAtPlatforms);
    }
    return maxPlatformsRequired;
  }
}
