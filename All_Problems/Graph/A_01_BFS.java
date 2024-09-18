package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class A_01_BFS {
  /*
   * This is similar to BFS of tree, but one thing is additional is the visited Array
   */
  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> bfsList = new ArrayList<>();
    int[] visited = new int[V];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0] = 1;

    while (!queue.isEmpty()) {
      int cur = queue.remove();
      // add the current node to bfs res
      bfsList.add(cur);

      // add the adjacent nodes to queue, if that node is already not visited
      List<Integer> nodes = adj.get(cur);
      for (int node : nodes) {
        if (visited[node] != 1) {
          queue.add(node);
          visited[node] = 1;
        }
      }
    }

    return bfsList;
  }
}
