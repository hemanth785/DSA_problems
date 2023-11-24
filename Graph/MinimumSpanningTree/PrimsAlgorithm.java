/*
 * Link: https://practice.geeksforgeeks.org/problems/minimum-spanning-tree
 * 
 * Given a weighted, undirected and connected graph of V vertices and E edges. 
 * The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 * 
 * More info about min spanning tree: https://www.geeksforgeeks.org/what-is-minimum-spanning-tree-mst/
 */

public class PrimsAlgorithm {
  /*
   * Approach: Using BFS and Priority queue
   * - Take any node as source node - add it to priority queue
   * - Start processing that node, while udpating the initial node cost as 0
   * - For other nodes, keep updating the distance or cost as the cost of edge from other node
   * - Keep the visited array, to track visited nodes. Since we are using priority queue, 
   *      it'll make sure we approach every node in min distance in first attempt only
   * 
   * - maintain distance array to store the previous edge cost to reach cur node (Not the cost all the way from source, in case of dijstras algo)
   * - Finally sum all the distance/cost for each node, that should be the min spanning tree cost
   */
  static int spanningTree(int V, int E, int edges[][]) {
    List<List<Pair>> adj = createAdjListFromEdges(V, edges);
    int visited[] = new int[V];
    int distance[] = new int[V];
    Arrays.fill(distance, Integer.MAX_VALUE);

    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(item -> item.cost));
    int src = edges[0][0];
    queue.add(new Pair(src, 0));
    distance[src] = 0;

    while (!queue.isEmpty()) {
      Pair pair = queue.remove();
      int node = pair.node;
      int cost = pair.cost;

      //here we are marking node as visited only when processing it, 
      // since we want all the possible weights for the nodes to be present in PriorityQueue, but process only min wieghted
      visited[node] = 1;

      for (Pair neighbour : adj.get(node)) {
        int u = node;
        int v = neighbour.node;

        //here we only check if cur edge cost is less than prev cost, no need to check of sum of cost + neighbour cost
        if (visited[v] != 1 && neighbour.cost < distance[v]) {
          distance[v] = neighbour.cost;
          queue.add(new Pair(v, distance[v]));
        }
      }
    }

    int minSpanCost = 0;
    for (int cost : distance) {
      minSpanCost += cost;
    }
    return minSpanCost;
  }

  public static List<List<Pair>> createAdjListFromEdges(int n, int[][] edges) {
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
      adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
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