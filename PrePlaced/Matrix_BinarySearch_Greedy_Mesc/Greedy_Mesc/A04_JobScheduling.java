package PrePlaced.Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * link: https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 */
public class A04_JobScheduling { 
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
     * 
     * NOte: check 2nd solution for simpler code (But logic is same)
     */
    for(Job job: arr){
      int jobCompletionTime = job.deadline;
      while(jobCompletionTime > 0 && slotsFilled[jobCompletionTime] == true){
        jobCompletionTime--;
      }

      if(jobCompletionTime > 0){ //check if its valid slot
        profit += job.profit;
        jobCount++;
        slotsFilled[jobCompletionTime] = true;
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
			int dayToDo = task.deadline; //check feasibility from last day of task

			while(dayToDo > 0){
				if(days[dayToDo] == 0){ //if that day has free slot, do that task
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


