package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/*
 * link: https://practice.geeksforgeeks.org/problems/topological-sort/1
 * 
 * TOPOLOGICAL SORTED:
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that 
 * for every directed edge u-v, vertex u comes before v in the ordering.
 * 
 * Note: Topological Sorting for a graph is not possible if the graph is not a DAG.
 */
public class TopologicalOrder {
  
  /*
   * Approach 1: Using DFS and Stack
   * - traverse graph using DFS, and push each node to stack in reverse order. 
   *  such that last node should be pushed to stack first (if there is edge a ---> b, then b should be pushed first)
   * 
   * - Then pop the all the eelements from stack, while insrting it to list
   */

   static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    Stack<Integer> stack = new Stack<>();
    int visited[] = new int[V];

    for (int i = 0; i < V; i++) {
      if (visited[i] != 1) {
        DFS(V, adj, visited, stack, i);
        stack.push(i);
      }
    }

    int topoSorted[] = new int[V];
    int i = 0;
    while (!stack.isEmpty()) {
      topoSorted[i++] = stack.pop();
    }

    return topoSorted;
  }

  static void DFS(int V, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack, int cur) {
    visited[cur] = 1;
    for (int neighbour : adj.get(cur)) {
      if (visited[neighbour] != 1) {
        DFS(V, adj, visited, stack, neighbour);
        stack.push(neighbour);
      }
    }
  }

  /*
   * Approach 2: Using Kahn's algorithm
   * Algorithm: Steps involved in finding the topological ordering of a DAG: 
   * Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.
   * Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
   * Step-3: Remove a vertex from the queue (Dequeue operation) and then. 
   * 
   * Increment the count of visited nodes by 1.
   * Decrease in-degree by 1 for all its neighbouring nodes.
   * If the in-degree of neighbouring nodes is reduced to zero, then add it to the queue.
   * Step 4: Repeat Step 3 until the queue is empty.
   * Step 5: If the count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.
   */

  static int[] topoSortKahns(int V, ArrayList<ArrayList<Integer>> adj) {
    Queue<Integer> queue = new LinkedList<>();
    int[] indegree = new int[V];

    // 1. calculate the indegree of each node
    for (int i = 0; i < V; i++) {
      for (int neighbour : adj.get(i)) {
        indegree[neighbour]++;
      }
    }

    // insert nodes having indegree = 0 into queue
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    int[] sorted = new int[V];
    int i = 0;
    // traverse the indegree 0 nodes
    while (!queue.isEmpty()) {
      int cur = queue.remove();
      sorted[i++] = cur;

      // loop through curr node neigbours and decrease their indegree
      for (int neighbour : adj.get(cur)) {
        indegree[neighbour]--;
        if (indegree[neighbour] == 0) {
          queue.add(neighbour);
        }
      }
    }
    return sorted;
  }
}
