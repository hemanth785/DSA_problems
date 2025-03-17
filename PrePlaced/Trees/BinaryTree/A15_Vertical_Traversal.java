package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class A15_Vertical_Traversal {
  public static class TreeNode {
    int data;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(){}

    TreeNode(int data){
      this.data = data;
    }
    TreeNode(int data, TreeNode left, TreeNode right){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /*
   * PROPER VERTICAL TRAVERSAL
   * we have considered the following order for row and col while printing
   * 1. print nodes coloumn wise from left to right
   * 2. inside the same coloumn, print the nodes from row top to bottom
   * 3. inside the same row and coloumn, print the nodes in sorted order
   */
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> verticalRes = new ArrayList<>();
    if (root == null) {
      return verticalRes;
    }

    TreeMap<Integer, TreeMap<Integer, List<Integer>>> grid = new TreeMap<>();
    dfs(root, grid, 0, 0);

    for (Map.Entry colEntry : grid.entrySet()) {
      List<Integer> tempList = new ArrayList<>();
      TreeMap<Integer, List<Integer>> colValues = (TreeMap<Integer, List<Integer>>) colEntry.getValue();

      for (Map.Entry colRowEntry : colValues.entrySet()) {
        List<Integer> colRowValues = (List<Integer>) colRowEntry.getValue();
        Collections.sort(colRowValues);

        tempList.addAll(colRowValues);
      }
      verticalRes.add(tempList);
    }

    return verticalRes;
  }

  public void dfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> grid, int col, int row) {
    if (root == null) {
      return;
    }
    if (grid.get(col) == null) {
      grid.put(col, new TreeMap<>());
    }
    if (grid.get(col).get(row) == null) {
      grid.get(col).put(row, new ArrayList<>());
    }
    grid.get(col).get(row).add(root.data);

    dfs(root.left, grid, col - 1, row + 1);
    dfs(root.right, grid, col + 1, row + 1);
  }
}
