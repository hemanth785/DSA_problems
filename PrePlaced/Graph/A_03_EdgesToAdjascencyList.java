package Graph;

import java.util.ArrayList;

/**
 * Link: https://workat.tech/problem-solving/practice/edges-to-adjacency-list
 * EdgesToAdjascencyList
 */
public class A_03_EdgesToAdjascencyList {
  ArrayList<Integer>[] edgesToAdjList(int n, int[][] edges) {
    ArrayList<Integer>[] adjList = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adjList[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < edges.length; i++) {
      adjList[edges[i][0]].add(edges[i][1]);
      if (edges[i][0] == edges[i][1]) { //this is to avoid condition where node having edge to itself
        continue;
      }
      adjList[edges[i][1]].add(edges[i][0]);
    }

    return adjList;
  }
}