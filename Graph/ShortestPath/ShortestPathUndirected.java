package Graph;

import java.util.*;

/*
 * Problem: Find the shorted path (no of edges/nodes between) for each node from source node, 
 * for undirected, non-weighteg graph. i.e. each edge weight would be 1 by default
 */

public class ShortestPathUndirected {
  public static void main(String[] args) {
    int n=5;
    int m = 5;
    int edges[][] = {{0,1}, {1,4}, {2,3}, {2,4}, {3,4}};
    int src = 1;

    int shortPath[] = shortestPath(n, edges, src);
    System.out.println(Arrays.toString(shortPath));
  }
  
  /*
   * Approach 1: Using simple BFS, 
   * - We know that with BFS traversal, we first reach any node in shortest possible distance (FOR undirected)
   * - keep counting nodes, while marking visited nodes
   * - Finally we should have shortest distance to all the nodes from the source.
   */
  public static int[] shortestPath(int n, int[][] edges, int src) {
    List<List<Integer>> adj = createAdjListFromEdges(n, edges);

    Queue<Integer> queue = new LinkedList<>();
    int visited[] = new int[n];
    int[] shortPath = new int[n];
    Arrays.fill(shortPath, -1);

    queue.add(src);
    shortPath[src] = 0;
    visited[src] = 1;

    int distance = 1;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();

      for (int i = 0; i < queueSize; i++) {
        int node = queue.remove();
        for (int neighbour : adj.get(node)) {
          if (visited[neighbour] != 1) {
            visited[neighbour] = 1;
            shortPath[neighbour] = distance;
            queue.add(neighbour);
          }
        }
      }

      distance++;
    }
    return shortPath;
  }

  public static List<List<Integer>> createAdjListFromEdges(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    return adj;
  }
}
