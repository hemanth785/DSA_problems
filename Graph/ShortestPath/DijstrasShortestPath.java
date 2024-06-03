package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/*
 * https://www.codingninjas.com/studio/problems/dijkstra's-shortest-path_985358
 * 
 * Find the shortest path to each node, For un-directed weighted graph (It could be cyclic also)
 * 
 * NOTE: DIJSTRA'S ALGORITHM WILL NOT WORK OF TREE HAVING "NEGATIVE" WEIGHTS
 */
public class DijstrasShortestPath {
  public static void main(String[] args) {
    int vertices = 5;
    int edges = 4;
    int edge[][] = { {0, 4, 2}, {3, 0, 4}, {0, 1, 5}, {2, 0, 2}};

    List<Integer> shortPath = dijkstra(edge, vertices, edges, 4);
    System.out.println(shortPath);
  }

  public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
    List<List<Pair>> adj = createAdjListFromEdges(vertices, edge);

    int shortDistance[] = new int[vertices];
    Arrays.fill(shortDistance, -1);

    /*
    Here normal queue also works, But using priority queue optmizes the code, 
    it first process the edges having the less cost, thus less number of repetative nodes will be pushed to queue
    */
    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(item -> item.cost));
    queue.add(new Pair(source, 0));

    shortDistance[source] = 0;

    while (!queue.isEmpty()) {
      Pair nodePair = queue.remove();
      int curNode = nodePair.node;
      int curCost = nodePair.cost;

      for (Pair neighbour : adj.get(curNode)) {
        int curShortDist = curCost + neighbour.cost;
        if (shortDistance[neighbour.node] == -1) {
          shortDistance[neighbour.node] = curShortDist;
          queue.add(new Pair(neighbour.node, curShortDist));
          
        } else if (curShortDist < shortDistance[neighbour.node]) {
          shortDistance[neighbour.node] = curShortDist;
          queue.add(new Pair(neighbour.node, curShortDist));
        }
      }
    }

    List<Integer> distanceList = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
      distanceList.add(shortDistance[i]);
    }
    // System.out.println(distanceList);
    return distanceList;
  }

  public static List<List<Pair>> createAdjListFromEdges(int vertices, int[][] edges) {
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
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
