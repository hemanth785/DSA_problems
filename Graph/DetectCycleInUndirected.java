package Graph;

import java.util.List;

public class DetectCycleInUndirected {
  /*
   * Approach: 
   * - Proceed with normal DFS traversal, while passing the parent node
   * - If at any point, if we come accross already visited node
   *  - check that if this neighbour node is not same as parent of the current not
   *     - if this is true, that means there is a cycle in the graph
   */

  boolean detectCycle(int V, List<List<Integer>> adj) {
    int visited[] = new int[V];

    for (int i = 0; i < V; i++) {
      if (visited[i] != 1) {
        boolean isCyclePresent = isCyclePresentDFS(adj, visited, i, -1);
        if (isCyclePresent) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isCyclePresentDFS(List<List<Integer>> adj, int[] visited, int node, int parent) {
    visited[node] = 1;

    List<Integer> neighbours = adj.get(node);
    for (int neighbour : neighbours) {
      if (visited[neighbour] != 1) {
        // if cycle present, no need to check for other neighbours
        if (isCyclePresentDFS(adj, visited, neighbour, node)) {
          return true;
        }
      } else if (neighbour != parent) {
        return true;
      }
    }
    return false;
  }
}
