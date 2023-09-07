package Queue;
/*
 * https://leetcode.com/problems/gas-station/
 * 
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
 * You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. 
 * If there exists a solution, it is guaranteed to be unique.
 * 
 */

public class GasStation {
  public static void main(String args[]){
    int gas[] = new int[]{1,2,3,4,5};
    int cost[] = new int[]{3,7,5,1,2};

    int result = canCompleteCircuit(gas, cost);
    System.out.println("Can complete circut: "+result);
  }

  /*
   * Solution 1: Bruteforce
   * - For each gas station, check can we complete the circle
   * 
   * Time: O(n^2), Space: O(n)
   */

  /*
   * Solution 2: Optimized
   * We know that, Suppost we start with station 1 and fuel becomes empty at station 3, 
   * we can conclude that we cannot start with station 1,2,3. 
   * 
   * So that we can start with 4th station
   * With this approach we just need to traverse station only once
   * 
   * Time: O(n)
   */
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int start = 0;
    while(start < n){
      int totalGas = gas[start] - cost[start];
      int index = start;
      int stationsCovered = 1;

      while(totalGas >= 0 && stationsCovered <= n){
        stationsCovered += 1;
        index = (index+1)%n;
        
        totalGas = totalGas + gas[index] - cost[index];
      }
      
      if(stationsCovered > n){
        return start;
      } else {
        start += stationsCovered;
      }
    }
    return -1;
  }
  
}
