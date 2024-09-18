package Graph.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
 */
public class A02_KruskalsAlgorithmForMinSpanTree {
  static class Edge {
    int u;
    int v;
    int wt;

    Edge(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }
  }

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

    // This will help in finding the ultimate parent (Boss of component) of anynode,
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

      // System.out.println("size: "+u+"->"+size[u]+" , "+v+"->"+size[v]);
    }
  }

  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    List<Edge> edges = convertAdjToEdges(adj);

    // sort the edges based on weights (lesser weight edge comes first)
    Collections.sort(edges, (a, b) -> a.wt - b.wt);

    DisjointSet ds = new DisjointSet(V);
    int minSpanCost = 0;

    for (Edge edge : edges) {
      int ulp_of_u = ds.findUltimateParent(edge.u);
      int ulp_of_v = ds.findUltimateParent(edge.v);

      // this means, these 2 nodes are already connected
      if (ulp_of_u == ulp_of_v) {
        continue;
      }

      // otherwise connect them min current wt edge
      ds.unionBySize(ulp_of_u, ulp_of_v);

      // System.out.println("wt: "+edge.wt);
      minSpanCost += edge.wt;
    }

    return minSpanCost;
  }

  static List<Edge> convertAdjToEdges(List<List<int[]>> adj) {
    List<Edge> edges = new ArrayList<>();

    for (int i = 0; i < adj.size(); i++) {
      for (int[] neighbour : adj.get(i)) {
        edges.add(new Edge(i, neighbour[0], neighbour[1]));
      }
    }

    return edges;
  }
}
