package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
  public static void main(String[] args) {
    
    Integer arr1[] = {3, 4, 4, 4, 8};
    int k = 9;
    List<List<Integer>> edges = new ArrayList<>();
    List<Integer> result = bfs(k, k, edges, k);
    System.out.println(result);
  }

  public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
       List<Integer> distances = new ArrayList<>();
       for(int i=1; i<=n; i++){
            distances.add(i, -1);
       }
       Map<Integer, List<Integer>> adjList = getAdjList(edges, n);
       System.out.println(adjList.toString());
        
       return distances;
    }
    
    public static Map<Integer, List<Integer>> getAdjList(List<List<Integer>> edges, int n){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=1; i<=n; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
        }
        
        return adjList;
    }

}
