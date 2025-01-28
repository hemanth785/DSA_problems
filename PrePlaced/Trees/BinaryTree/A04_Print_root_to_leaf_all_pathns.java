package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/binary-tree-paths/
 */
public class A04_Print_root_to_leaf_all_pathns {
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

  /* --------------------------------- */

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();

    List<Integer> tempPath = new ArrayList<>();
    dfs(root, result, tempPath);

    return result;
  }

  public void dfs(TreeNode root, List<String> result, List<Integer> tempPath) {
    if (root == null) {
      return;
    }

    tempPath.add(root.data);

    if (root.left == null && root.right == null) {
      printNodes(result, tempPath);
    } else {
      dfs(root.left, result, tempPath);
      dfs(root.right, result, tempPath);
    }

    tempPath.remove(tempPath.size() - 1);
  }

  public void printNodes(List<String> result, List<Integer> tempPath) {
    String resString = "";
    for (int nodeVal : tempPath) {
      resString += resString == "" ? nodeVal : "->" + nodeVal;
    }

    result.add(resString);
  }
}
