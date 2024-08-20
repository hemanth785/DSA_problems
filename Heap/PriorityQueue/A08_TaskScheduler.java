package Heap.PriorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Link: https://leetcode.com/problems/task-scheduler/
 * 
 * Solution explanation: https://www.youtube.com/watch?v=Q9006pUcypI
 */
public class A08_TaskScheduler {
  /*
   * Approach:
   * - We know that, 
   *    - In best case min num of intervals will be  -> number of tasks itself (Here no empty idle slots required)
   *    - In worst case min num of intervals will be -> no of idle slots + number of tasks
   * 
   * - To find the answer, first get the count of all the diff tasks
   * - Now pick the task with highest fequency
   * - Then calculate the 'idle slots' count, assuming that only this task need to be excecuted considering interval n
   *    - i.e idle slots = [(max freq task count - 1) * n], where n is interval time, and its count is '-1' because intervals will be between the tasks.
   * - Now start filling this idle slots with other tasks
   *    - Note that we can only fill (max freq task count - 1) idle slots with the single task
   * 
   * - Once we fill all tasks, check if idle count has become zero (or negative)
   *    - If yes, that means we have filled all idle slots with given task, in this case (number of tasks) is the answer
   *    - If No, then there are some idle slots still exists between tasks, so the answer is [number of tasks + task count]
   * 
   */
  public int leastInterval(char[] tasks, int n) {
    //get the count of each tasks
    Map<Character, Integer> taskCountMap = new HashMap<>();
    for(char ch: tasks){
      taskCountMap.put(ch, taskCountMap.getOrDefault(ch, 0)+1);
    }

    //push these counts to Max Heap
    PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
    for (Map.Entry<Character, Integer> entry : taskCountMap.entrySet()) {
      pq.add(entry.getValue());
    }

    //first calculate the idle slots required based on highest frequence tasks
    int maxFreq = pq.poll();

    int idleSlots = (maxFreq - 1) * n;

    // now fill these idle slots with next lower frequency tasks
    // if at any point, idleSlots count becomes or zero or less than 0, 
    // we can return the tasks size as answer
    while(!pq.isEmpty()){
      int tasksCanFillIdles = Math.min(maxFreq - 1, pq.poll());
      idleSlots = idleSlots - tasksCanFillIdles;
    }

    //if idle slots count becomes less than 1, that means all idle slots are filled.
    if(idleSlots <= 0){
      return tasks.length;
    }

    return idleSlots + tasks.length;
  }
}
