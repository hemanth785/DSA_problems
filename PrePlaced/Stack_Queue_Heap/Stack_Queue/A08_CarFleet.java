import java.util.Arrays;
/*
 * Link: https://leetcode.com/problems/car-fleet/
 */
public class A08_CarFleet {
  /*
   * Arroach: Solve it using stack (return stack size at the end), without stack also works
   * - To find the number of fleets, first we need to find the time taken by individual cars to reach the target from their position
   * - So first sort the cars by their original position in descending order
   * - Consider the 1st car as the fleetLeader, initialize fleetCount as 1
   * - Node start iterating through each car
   * - Calculate time to reach destination for both fleet leader and car
   * - If car ttr(time to reach) is lesser than fleetLeader's ttr, then ignore it, because this car will become of part fleet at some point
   * - If car ttr is greater than fleet, increment the fleetCount and consider this car as the new fleetLeader
   * - at the end, return feetCount
   */
  
  public int carFleet(int target, int[] position, int[] speed) {
    int n = speed.length;
    int cars[][] = new int[n][2];

    for (int i = 0; i < n; i++) {
      cars[i] = new int[] { position[i], speed[i] };
    }

    Arrays.sort(cars, (a, b) -> b[0] - a[0]);

    int fleets = 1;
    int fleetLeader[] = cars[0];

    for (int[] car : cars) {
      double fleetLeaderArrivalTime = (target - fleetLeader[0]) * 1.0 / fleetLeader[1];
      double carArrivalTime = (target - car[0]) * 1.0 / car[1];

      if (carArrivalTime > fleetLeaderArrivalTime) {
        fleets++;
        fleetLeader = car;
      }
    }

    return fleets;
  }
}
