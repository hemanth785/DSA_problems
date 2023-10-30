package Graph;

import java.util.ArrayList;
import java.util.List;

/*
 * link: https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int V = numCourses;

    // 0. Convert edges to adjecency list
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int course[] = prerequisites[i];
      adj.get(course[1]).add(course[0]);
    }

    Queue<Integer> queue = new LinkedList<>();
    int[] indegree = new int[V];

    // 1. calculate the indegree of each node
    for (int i = 0; i < V; i++) {
      for (int neighbour : adj.get(i)) {
        indegree[neighbour]++;
      }
    }

    // keep track of how many nodes processed
    int nodesProcessed = 0;

    // insert nodes having indegree = 0 into queue
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    int[] sorted = new int[V];
    int i = 0;
    // traverse the indegree 0 nodes
    while (!queue.isEmpty()) {
      int cur = queue.remove();
      sorted[i++] = cur;
      nodesProcessed++;

      // loop through curr node neigbours and decrease their indegree
      for (int neighbour : adj.get(cur)) {
        indegree[neighbour]--;
        if (indegree[neighbour] == 0) {
          queue.add(neighbour);

        }
      }
    }

    return nodesProcessed == V;
  }
}
