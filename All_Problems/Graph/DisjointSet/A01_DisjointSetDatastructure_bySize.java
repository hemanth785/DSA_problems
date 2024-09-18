package Graph.DisjointSet;

public class A01_DisjointSetDatastructure_bySize {
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

      if (size[ulp_of_u] <= size[ulp_of_v]) {
        parent[ulp_of_u] = ulp_of_v;
        size[ulp_of_v] += size[ulp_of_u];
      } else {
        parent[ulp_of_v] = ulp_of_u;
        size[ulp_of_u] += size[ulp_of_v];
      }
    }
  }

  public static void main(String[] args) {

    DisjointSet ds = new DisjointSet(7);
    ds.unionBySize(1, 2);
    ds.unionBySize(2, 3);
    ds.unionBySize(4, 5);
    ds.unionBySize(6, 7);
    ds.unionBySize(5, 6);

    if(ds.findUltimateParent(3) == ds.findUltimateParent(7)){
      System.out.println("Same set");
    } else {
      System.out.println("Different set");
    }

    ds.unionBySize(3, 7);

    if(ds.findUltimateParent(3) == ds.findUltimateParent(7)){
      System.out.println("Same set");
    } else {
      System.out.println("Different set");
    }
  }
}
