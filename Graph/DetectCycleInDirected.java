package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class DetectCycleInDirected {
  /*
   * Approach 1: Using dfs and recursiveVisited Arrays
   * - for directed, instead of parent key, pass the visitedRecursive array
   * - this array is used to mark whether the node is visited for this recursive iteration
   * - while exiting the current recursive stack, we need to unkmark as visited
   * - So at any point in the recursive stack, if we come accross the node which is already visited in 'visitedRecursive', 
   *      that means there is cycle exists
   */

  // Function to detect cycle in a directed graph.
  public boolean isCyclicDFS(int V, ArrayList<ArrayList<Integer>> adj) {
    int visited[] = new int[V];
    int recVisited[] = new int[V];

    for (int i = 0; i < V; i++) {
      if (visited[i] != 1) {
        boolean isCyclePresent = isCyclePresentDFS(adj, visited, i, recVisited);
        if (isCyclePresent) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isCyclePresentDFS(ArrayList<ArrayList<Integer>> adj, int[] visited, int node, int[] recVisited) {
    if (recVisited[node] == 1) {
      return true;
    }
    if (visited[node] == 1) {
      return false;
    }
    visited[node] = 1;
    recVisited[node] = 1;

    for (int neighbour : adj.get(node)) {
      // if cycle present, no need to check for other neighbours
      if (isCyclePresentDFS(adj, visited, neighbour, recVisited)) {
        return true;
      }
    }
    recVisited[node] = 0;
    return false;
  }

  /*
   * Approach 2: Using Kahn's algorithm
   * - Logic is that, traverse the nodes which are having the indegree is zero, while decreasing the indegree of neighbour nodes
   * - If any node left for processing, which is having more that 0 indefree, that means there is cycle.
   * 
   * Notes: Becuase Kahn's algorithm will not be usefull for cyclic directed graphs
   */
  public boolean isCyclicKahns(int V, ArrayList<ArrayList<Integer>> adj) {
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

    return nodesProcessed != V;
  }
}
