package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * link: https://leetcode.com/problems/course-schedule/
 * 
 * Note: Its same a detecting cycle in directed graph. 
 * If cycle exists, you cannot complete all the courses by following dependency (prerequisites)
 * 
 * i.e. if there is edge a->b, b->c, c->a. 
 * this means that before completeing a, you need to complete b. and before b we need to complete c, 
 * and before c, we need to complete c. Now here we have cyclical dependency and we cannot complete any course by following prerequisite order
 * 
 * Solution: Use Kahn's algorithm to check whether cycle exists, if cycle exists then its not possible
 */

public class A_09_CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int V = numCourses;

    // 0. Convert edges to adjecency list
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    int[] indegree = new int[V];
    for (int[] course : prerequisites) {
      adj.get(course[1]).add(course[0]);
      
      //1. calculate the indegree of each node
      indegree[course[0]]++;
    }

    // keep track of how many nodes processed
    int nodesProcessed = 0;

    Queue<Integer> queue = new LinkedList<>();
    // insert nodes having indegree = 0 into queue
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    // traverse the indegree 0 nodes
    while (!queue.isEmpty()) {
      int cur = queue.remove();
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
