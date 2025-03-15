/*
 * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 */

 /*
  * Approach: Problem is sovled using Prim's algorithm, only diff is while creating the adj list form the points given
  */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class A02_MinCostToConnectPoints {
  public int minCostConnectPoints(int[][] points) {
    int V = points.length;
    List<List<Pair>> adj = createAdjListFromEdges(V, points);

    int visited[] = new int[V];
    int distance[] = new int[V];
    Arrays.fill(distance, Integer.MAX_VALUE);

    PriorityQueue<Pair> queue = new PriorityQueue<>(
      Comparator.comparingInt(item -> item.cost)
    );
    int src = 0;
    queue.add(new Pair(src, 0));
    distance[src] = 0;

    while (!queue.isEmpty()) {
      Pair pair = queue.remove();
      int node = pair.node;

      //here we are marking node as visited only when processing it,
      // since we want all the possible weights for the nodes to be present in PriorityQueue, but process only min wieghted
      visited[node] = 1;

      for (Pair neighbour : adj.get(node)) {
        int v = neighbour.node;

        //here we only check if cur edge cost is less than prev cost, no need to check of sum of cost + neighbour cost
        if (visited[v] != 1 && neighbour.cost < distance[v]) {
          distance[v] = neighbour.cost;
          queue.add(new Pair(v, neighbour.cost));
        }
      }
    }

    int minSpanCost = 0;
    for (int cost : distance) {
      minSpanCost += cost;
    }
    return minSpanCost;
  }

  /*
   * Only creating adj list has additional logic, rest all from Prim's algo code
   */
  public static List<List<Pair>> createAdjListFromEdges(int n, int[][] points) {
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    //number the each point from 0 to n-1, while creating edge between all the points to every other point
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) {
          int u = i;
          int v = j;

          int x1 = points[i][0];
          int y1 = points[i][1];
          int x2 = points[j][0];
          int y2 = points[j][1];
          int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);

          adj.get(u).add(new Pair(v, cost));
        }
      }
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
