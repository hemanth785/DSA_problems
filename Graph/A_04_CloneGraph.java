package Graph;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Link: https://www.geeksforgeeks.org/problems/clone-graph
 */

class Node {
  public int value = 0;
  public ArrayList<Node> neighbors = new ArrayList<Node>();
  public Node(int val) { value = val; }
};

public class A_04_CloneGraph {
  Node cloneGraph(Node node) {
    Node clonedNode = new Node(node.value);
		HashSet<Node> visited = new HashSet<>();
		
		cloneDFS(node, clonedNode, visited);
		
		return clonedNode;
  }
	
	void cloneDFS(Node curNode, Node clonedNode, HashSet<Node> visited){
		visited.add(curNode);
		
		for(Node adjNode: curNode.neighbors){
			if(!visited.contains(adjNode)){
				Node cloneAdjNode = new Node(adjNode.value);
				clonedNode.neighbors.add(cloneAdjNode);

				cloneDFS(adjNode, cloneAdjNode, visited);
			}
		}
	}
}
