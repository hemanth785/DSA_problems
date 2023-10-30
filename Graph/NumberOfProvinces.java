package Graph;
/*
 * This is basicall finding the number of disconneted components in given graph
 */
public class NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
    int V = isConnected.length;
    int[] visited = new int[V];

    int provinceCount = 0;

    for (int i = 0; i < V; i++) {
      if (visited[i] != 1) {
        provinceCount++;
        dfsRecursive(isConnected, visited, i, V);
      }
    }

    return provinceCount;
  }

  public void dfsRecursive(int[][] connected, int[] visited, int cur, int V) {
    visited[cur] = 1;
    for (int j = 0; j < V; j++) {
      if (connected[cur][j] == 1 && visited[j] != 1) {
        dfsRecursive(connected, visited, j, V);
      }
    }
  }
}
