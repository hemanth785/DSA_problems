package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class A04_HeightOfTree {
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


  
  public static int findMaxDepthIterative(TreeNode root) { // using level order traversal
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    queue.add(null); // this is marker to incrementing height

    int height = 0;
    while (!queue.isEmpty()) {
      TreeNode cur = queue.remove();
      if (cur == null) {
        height++;
        if (!queue.isEmpty()) {
          queue.add(null);
        }
      } else {
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
    }
    return height;
  }

  /*
   * for each iteration, while each function call is removing from call stack
   * add 1 height from each node and max height of its child nodes (left or right)
   */
  public static int findMaxDepthRecursive(TreeNode root) { // recursive approach
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(findMaxDepthRecursive(root.left), findMaxDepthRecursive(root.right));
  }
}
