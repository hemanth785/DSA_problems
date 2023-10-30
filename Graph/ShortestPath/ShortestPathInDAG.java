package Graph;

import java.util.*;

public class ShortestPathInDAG {
  public static void main(String[] args) {
    int n = 3;
    int m = 3;
    int edges[][] = { { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 6 } };

    int shortPath[] = shortestPathInDAG(n, m, edges);
    System.out.println(Arrays.toString(shortPath));
  }

  /*
   * Approach 1: Using BFS traversal
   * - For directed acyclic graph, we need to visit the each node in all the possible ways, So visited array will not be needed
   * - each time we come accross any node, calculate the min distance if already visited. or assign current distance as the shortest distance
   * 
   * Note: This works for both cyclic as well as acyclic directed graph
   *  Bute it wont work for negative cycle
   */
  public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
    List<List<Pair>> adj = createAdjListFromEdges(n, edges);
    System.out.println(adj);

    int shortDistance[] = new int[n];
    Arrays.fill(shortDistance, -1);

    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    shortDistance[0] = 0;

    while (!queue.isEmpty()) {
      int curNode = queue.remove();
      int curCost = shortDistance[curNode];

      for (Pair neighbour : adj.get(curNode)) {
        if (shortDistance[neighbour.node] == -1) {
          shortDistance[neighbour.node] = curCost + neighbour.cost;
        } else if (shortDistance[neighbour.node] > curCost + neighbour.cost) {
          shortDistance[neighbour.node] = curCost + neighbour.cost;
        }
        queue.add(neighbour.node);
      }
    }
    return shortDistance;
  }

  public static List<List<Pair>> createAdjListFromEdges(int n, int[][] edges) {
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    return adj;
  }

  public static class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }
  }
}
