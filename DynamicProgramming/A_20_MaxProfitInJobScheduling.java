/*
 * LInk: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 */

class A_20_MaxProfitInJobScheduling{
	/*
	 * Approach: Using DP (This may seem like greedy problem, but its not)
	 * - First merge all 3 arrays in array of objects
	 * - Sort the jobs based on start or end time
	 * - Then apply include/notInclude recursive approach
	 * - To add the DP on index, we have to add one more element in include segment
	 *   - For include case, instead of directly calling next index function, we have to call the next eligible task (based on startTime of next task and end time of current task)
	 */
	static class Job{
		int startTime;
		int endTime;
		int profit;

		Job(int startTime, int endTime, int profit){
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}
	}
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job jobs[] = new Job[n];

		for(int i=0; i<n; i++){ 
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}

		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);

		//sort the jobs based on startTime or endTime
		Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);

		return maxProfitJobsMemo(jobs, n, 0, 0, dp);
	}

	public int maxProfitJobsMemo(Job[] jobs, int n, int timeToStartNextTask, int index, int[] dp){
		if(index >= n){
			return 0;
		}

		if(dp[index] != -1){
			return dp[index];
		}
		Job job = jobs[index];

		// 1. include case
		int includeProfit = 0;
		if(job.startTime >= timeToStartNextTask){
			int nextIndex = index+1;
			//find next possible task to execute
			while(nextIndex < n && job.endTime > jobs[nextIndex].startTime){
				nextIndex++;
			}
			includeProfit = job.profit + maxProfitJobsMemo(jobs, n, job.endTime, nextIndex, dp);
		}

		// 2. exclude case
		int excludeProfit = maxProfitJobsMemo(jobs, n, timeToStartNextTask, index+1, dp);

		dp[index] = Math.max(includeProfit, excludeProfit);
		return dp[index];
	}
}	