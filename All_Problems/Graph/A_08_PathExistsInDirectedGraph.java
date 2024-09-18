package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class A_08_PathExistsInDirectedGraph {
  boolean pathExists(ArrayList<Integer>[] adjList) {
    HashSet<Integer> visited = new HashSet<>();
		int n = adjList.length;
		
		return dfsRec(adjList, visited, 0, n);
  }
	
  /*
   * Approach: do the normal dfs traversal, if we reach last node (n-1) 
   * then we can conclude that there is path exists
   */
	boolean dfsRec(ArrayList<Integer>[] adjList, HashSet<Integer> visited, int cur, int n){
		if(cur == n-1){
			return true;
		}
		visited.add(cur);
		
		for(int adj: adjList[cur]){
			if(!visited.contains(adj)){
				if(dfsRec(adjList, visited, adj, n)){
					return true;
				}
			}
		}
		
		return false;
	}
}
