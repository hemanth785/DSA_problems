package Graph.DisjointSet;

/*
 * Link: https://www.geeksforgeeks.org/problems/connecting-the-graph
 */
public class A03_ConnectingTheGraph {
  static class DisjointSet {
    int size[];
    int parent[];

    DisjointSet(int n) {
      size = new int[n + 1];
      parent = new int[n + 1];

      for (int i = 0; i < n; i++) {
        size[i] = 1;
        parent[i] = i; // initialy all nodes parent will be itself only
      }
    }

    // This will help in finding the ultimate parent (Boss of component) of any node,
    // Along the way it also performs 'Path compression'
    public int findUltimateParent(int node) {
      if (parent[node] == node) {
        return node;
      }

      parent[node] = findUltimateParent(parent[node]); // this line does the job of path compression
      return parent[node];
    }

    // This will add one component to another dijoint component, if both of them are
    // already not connected
    public void unionBySize(int u, int v) {
      int ulp_of_u = findUltimateParent(u);
      int ulp_of_v = findUltimateParent(v);

      if (ulp_of_u == ulp_of_v) {
        return;
      }

      if (size[u] < size[v]) {
        parent[u] = v;
        size[v] += size[u];
      } else {
        parent[v] = u;
        size[u] += size[v];
      }
    }
  }

  public int Solve(int n, int[][] edges) {
    DisjointSet ds = new DisjointSet(n);
    // Contruct the graph using Disjoint set, while calculating extra edges between any 2 nodes
    int extraEdges = 0;

    for (int edge[] : edges) {
      int ulp_of_u = ds.findUltimateParent(edge[0]);
      int ulp_of_v = ds.findUltimateParent(edge[1]);

      if (ulp_of_u == ulp_of_v) {
        extraEdges++;
        continue;
      }

      ds.unionBySize(ulp_of_u, ulp_of_v);
    }

    // find the number of disjoint components after constructing Graph
    int numOfComponents = 0;
    for (int i = 0; i < n; i++) {
      // to calculate number of components, we have to check
      // How many nodes are still having parent as themselves (Leader nodes)
      if (i == ds.findUltimateParent(i)) {
        numOfComponents++;
      }
    }

    int minEdgesNeededToConnect = numOfComponents - 1;
    if (extraEdges >= minEdgesNeededToConnect) {
      return minEdgesNeededToConnect;
    } else {
      return -1;
    }
  }
}
