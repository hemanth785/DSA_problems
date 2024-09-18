package Graph.DisjointSet;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/redundant-connection/
 */
public class A05_RedundantConnection {
  static class DisjointSet{
        int size[];
        int parent[];

        DisjointSet(int n){
            this.size = new int[n+1];
            this.parent = new int[n+1];

            for(int i=0; i<=n; i++){
                size[i] = 1;
                parent[i] = i;
            }
        }

        int findUltimateParent(int node){
            if(node == parent[node]){
                return node;
            }

            parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }

        void unionBySize(int u, int v){
            if(parent[u] == parent[v]){
                return;
            }

            int ult_parent_of_u = findUltimateParent(u);
            int ult_parent_of_v = findUltimateParent(v);

            if(size[ult_parent_of_u] >= size[ult_parent_of_v]){
                parent[ult_parent_of_v] = ult_parent_of_u;
                size[ult_parent_of_u] += size[ult_parent_of_v];
            } else {
                parent[ult_parent_of_u] = ult_parent_of_v;
                size[ult_parent_of_v] += size[ult_parent_of_u];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        for(int[] edge: edges){
            System.out.println(Arrays.toString(edge));
            int u = edge[0];
            int v = edge[1];

            int ult_parent_of_u = ds.findUltimateParent(u);
            int ult_parent_of_v = ds.findUltimateParent(v);

            if(ult_parent_of_u == ult_parent_of_v){
                return edge;
            } else {
                ds.unionBySize(ult_parent_of_u, ult_parent_of_v);
            }
        }

        return new int[]{-1, -1};
    }
}
