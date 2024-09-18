package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Link: https://workat.tech/problem-solving/practice/is-graph-bipartite
 * 
 * Bipartite graph:
 * A bipartite graph is a graph in which the vertices can be divided into two disjoint sets, such that no two vertices within the same set are adjacent.
 * 
 * In other words, if are able to color all nodes of graph with 2 colors, such that any 2 adjascent nodes should not have same colors
 */


/*
 * Approach:
 * - 
 */
public class A_18_BipartiteGraph {
  public boolean isBipartite(ArrayList<Integer>[] adjList) {
    int n = adjList.length;

    int colors[] = new int[n];
    Arrays.fill(colors, -1);

    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    colors[0] = 0; // we are using color 0 and 1

    while (!queue.isEmpty()) {
      int node = queue.remove();

      for (int adjNode : adjList[node]) {
        //if adj node is not colored
        if (colors[adjNode] == -1) {
          queue.add(adjNode);
          colors[adjNode] = colors[node] ^ 1; //this toggles between 0 and 1, (xor with 1 -> 0^1 => 1 and 1^1 => 0)
        } else {
          // if adj node is already colored, check these 2 nodes have diff colors
          if (colors[node] == colors[adjNode]) {
            return false;
          }
        }
      }
    }

    return true;
  }
}
