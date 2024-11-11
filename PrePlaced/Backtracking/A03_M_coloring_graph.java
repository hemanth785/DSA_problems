package PrePlaced.Backtracking;

import java.util.ArrayList;

/*
 * Link: https://workat.tech/problem-solving/practice/m-coloring-problem
 * 
 * Note: This is actually a BACKTRACKING PROBLEM
 */

public class A03_M_coloring_graph {
  boolean isColoringPossible(int[][] adjMatrix, int m) {
    int n = adjMatrix.length;
    ArrayList<Integer>[] adjList = matrixToAdjList(n, adjMatrix);

    int colors[] = new int[n];
    // start from 0th node
    return solveRec(adjList, colors, m, n, 0);
  }

  boolean solveRec(ArrayList<Integer>[] adjList, int colors[], int m, int n, int curNode) {
    if (curNode == n) {
      return true;
    }

    // try applying all colors to each node and proceed to next node
    for (int i = 1; i <= m; i++) {
      if (isSafe(curNode, adjList, colors, i)) { // check if adjascent node has the same color
        colors[curNode] = i;
        if (solveRec(adjList, colors, m, n, curNode + 1)) {
          return true;
        }
        colors[curNode] = 0; // reset the color if it not works
      }
    }
    return false;
  }

  boolean isSafe(int node, ArrayList<Integer>[] adjList, int[] colors, int curNodeColor) {
    for (int neighbour : adjList[node]) {
      //check if neighbour has same color as current node or, current node has edge to itself
      if (colors[neighbour] == curNodeColor || node == neighbour) {
        return false;
      }
    }
    return true;
  }

  ArrayList<Integer>[] matrixToAdjList(int n, int[][] matrix) {
    ArrayList<Integer>[] adjList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          list.add(j);
        }
      }
      adjList[i] = list;
    }

    return adjList;
  }
}
