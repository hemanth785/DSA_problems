package PrePlaced.BinaryTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
 * Link: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 */
public class A16_Top_View {
  public static class TreeNode {
    int data;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode() {
    }

    TreeNode(int data) {
      this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /*--------------- */
  static ArrayList<Integer> topView(TreeNode root) {
    ArrayList<Integer> topView = new ArrayList<>();
    if (root == null) {
      return topView;
    }

    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> grid = new TreeMap<>();
    dfs(root, grid, 0, 0);

    for (Map.Entry colEntry : grid.entrySet()) {
      TreeMap<Integer, ArrayList<Integer>> colValues = (TreeMap<Integer, ArrayList<Integer>>) colEntry.getValue();

      for (Map.Entry colRowEntry : colValues.entrySet()) {
        ArrayList<Integer> colRowValues = (ArrayList<Integer>) colRowEntry.getValue();

        topView.add(colRowValues.get(0)); //for top view only print 1st value in the row
        break;
      }
    }

    return topView;
  }

  public static void dfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> grid, int col, int row) {
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
