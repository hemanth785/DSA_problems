import java.util.Arrays;
import java.util.List;

public class A_04_BellmanFord {

  /*
   * link: https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
   *
   * Read this to understand bellman ford logic
   * https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
   *
   * Time complexity: V * E (edges)
   */
  public static int[] bellmonFord(int V, int src, List<List<Integer>> edges) {
    int[] distance = new int[V];
    Arrays.fill(distance, 100000000);

    distance[src] = 0; //This is important

    //Relax all the edges N-1 times(where N is number of vertices), to get the shortest distance from source to all nodes
    //Note:  This for loop is enough for the bellman ford algorithm
    for (int i = 1; i <= V - 1; i++) {
      for (List<Integer> edge : edges) {
        int u = edge.get(0);
        int v = edge.get(1);
        int dist = edge.get(2);

        if (distance[u] != 100000000 && (distance[u] + dist) < distance[v]) {
          distance[v] = distance[u] + dist;
        }
      }
    }

    //This N-th relaxation is to verify if any negative weight cycle is present in the graph
    for (List<Integer> edge : edges) {
      int u = edge.get(0);
      int v = edge.get(1);
      int dist = edge.get(2);

      //if value is still descreasing for any edge, even after n-1 relaxation cycle, that means negative weight cycle exists
      if (distance[u] != 100000000 && distance[u] + dist < distance[v]) {
        int ans[] = new int[1];
        ans[0] = -1;
        return ans;
      }
    }

    return distance;
  }
}
