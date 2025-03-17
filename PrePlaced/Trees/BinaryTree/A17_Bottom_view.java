package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
 * Link: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 */
public class A17_Bottom_view {
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

  /* ------------- */
  public ArrayList<Integer> bottomView(TreeNode root)
    {
    ArrayList<Integer> bottomView = new ArrayList<>();
    if (root == null) {
      return bottomView;
    }

    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> grid = new TreeMap<>();
    dfs(root, grid, 0, 0);

    for (Map.Entry colEntry : grid.entrySet()) {
      TreeMap<Integer, ArrayList<Integer>> colValues = (TreeMap<Integer, ArrayList<Integer>>) colEntry.getValue();

      int size = colValues.size();
      int i = 0;
      for (Map.Entry colRowEntry : colValues.entrySet()) {
        ArrayList<Integer> colRowValues = (ArrayList<Integer>) colRowEntry.getValue();

        //Here we have to print item from, last row of tree and last item of a list.
        if (i == size - 1) {
          bottomView.add(colRowValues.get(colRowValues.size() - 1));
        }
        i++;
      }
    }

    return bottomView;
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
