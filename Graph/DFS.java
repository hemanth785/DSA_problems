package Graph;

import java.util.ArrayList;

public class DFS {
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> dfsList = new ArrayList<>();
    int[] visited = new int[V];

    dfsRecursive(V, adj, dfsList, visited, 0);

    return dfsList;
  }

  public void dfsRecursive(int V, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList, int[] visited, int cur) {
    dfsList.add(cur);
    visited[cur] = 1; //for dfs we can mark as visited while printing also

    for (int node : adj.get(cur)) {
      if (visited[node] != 1) {
        dfsRecursive(V, adj, dfsList, visited, node);
      }
    }
  }
}
