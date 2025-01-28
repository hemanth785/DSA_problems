package PrePlaced.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * Morris Inorder Traversal is a tree traversal algorithm aiming to achieve a space complexity of O(1) 
 * without recursion or an external data structure. 
 * The algorithm should efficiently visit each node in the binary tree in inorder sequence, 
 * printing or processing the node values as it traverses, without using a stack or recursion.
 */

public class A20_Morris_inorder_traversal {
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

  /* ---------------- */

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<>();

    if (root == null) {
      return inorder;
    }

    TreeNode cur = root;

    while (cur != null) {
      if (cur.left == null) {
        inorder.add(cur.data);
        cur = cur.right;

      } else {
        TreeNode leftRightNode = cur.left;

        while (leftRightNode.right != null && leftRightNode.right != cur) {
          leftRightNode = leftRightNode.right;
        }

        if (leftRightNode.right == null) {
          // create a link to root node from leftRight node
          leftRightNode.right = cur;
          cur = cur.left;
        } else {
          // remove the existing link and move to right subtree
          leftRightNode.right = null;
          inorder.add(cur.data);
          cur = cur.right;
        }

      }
    }

    return inorder;
  }
}
