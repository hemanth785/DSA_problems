package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/*
 * link: https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 */
public class JobScheduling { 
  class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
    }
  }

  static int[] jobScheduling(Job arr[], int n)
  {
    List<Job> jobList = new ArrayList<>(Arrays.asList(arr));
    //sort the jobs based on the profit
    Collections.sort(jobList, (a, b) -> b.profit - a.profit); 
    
    int profit = 0;
    int jobCount = 0;

    boolean slotsFilled[] = new boolean[n];
    Arrays.fill(slotsFilled, false);

    /*
     * Start processing jobs with higher profit and try to schedule these jobs on the deadline date of job
     * - if that slot is not available, keep check if any previous slot is available for current job.
     */
    for(Job job: arr){
      int deadlineSlot = job.deadline;
      while(deadlineSlot > 0 && slotsFilled[deadlineSlot] == true){
        deadlineSlot--;
      }
      if(deadlineSlot > 0){ //check if its valid slot
        profit += job.profit;
        jobCount++;
        slotsFilled[deadlineSlot] = true;
      }
    }

    int res[] = new int[2];
    res[0] = profit;
    res[1] = jobCount;

    return res;
  }



/* Simple solution written at work@tech */
class Task {
  public int deadline, profit;
  public Task(int deadline, int profit) {
    this.deadline = deadline;
    this.profit = profit;
  }
}
int getMaxProfit(Task[] tasks) {
		Arrays.sort(tasks, (a, b) -> {
			return b.profit - a.profit;
		});
		
		int days[] = new int[tasks.length+1];
		int profit = 0;
		for(Task task: tasks){
			int dayToDo = task.deadline;
			while(dayToDo > 0){
				if(days[dayToDo] == 0){
					days[dayToDo] = 1;
					profit += task.profit;
					break;
				}
				dayToDo--;
			}
		}
		
		return profit;
	}
}


