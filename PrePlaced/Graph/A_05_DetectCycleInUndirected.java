package Graph;

import java.util.List;

public class A_05_DetectCycleInUndirected {
  /*
   * Approach: 
   * - Proceed with normal DFS traversal, while passing the parent node
   * - If at any point, if we come accross already visited node
   *  - check that if this neighbour node is not same as parent of the current node
   *     - if this is true, that means there is a cycle in the graph
   * 
   * Note: check for parent if needed because, in an undirected graph, 
   *  when we move from node A to node B (Now A is already marked as visited), B also will have edge to A
   *  thus visited for A will be true in this case, but its not cycle. since A is the parent(while traversig), so B having edge to A is expected
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
