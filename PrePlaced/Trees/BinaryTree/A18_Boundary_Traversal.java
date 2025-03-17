package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Link: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 */
public class A18_Boundary_Traversal {
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

  /* ------------------- */

  /*
   * Apprach: We need to use 3 diff functions to get the answer
   * - step 1: first add the root node to res
   * - step 2: add left nodes from left subtree, at any point left child does not exists, add right child node
   * - step 3: add leaf nodes, Use inorder traversal to get leaf nodes
   * - step 4: add right nodes from right subtree, at any point right child does not exists, add left child node
   */
  ArrayList<Integer> boundary(TreeNode root) {
    ArrayList<Integer> boundaryRes = new ArrayList<>();
    if (root == null) {
      return boundaryRes;
    }

    // 1. Add root node to boundary list
    boundaryRes.add(root.data);
    if (root.left == null && root.right == null) {
      return boundaryRes;
    }

    // 2. Add left boundary nodes from left sub tree, except the leap nodes
    getLeftBoundaryNodes(root.left, boundaryRes);

    // 3. Add leap nodes, from left to right - So use inorder traversal
    inorder(root, boundaryRes);

    // 4. Add left boundary nodes from right sub tree, except the leap nodes - Use stack
    Stack<Integer> stack = new Stack<>();
    getRightBoundaryNodes(root.right, stack);
    while (!stack.isEmpty()) {
      boundaryRes.add(stack.pop());
    }

    return boundaryRes;

  }

  static void getLeftBoundaryNodes(TreeNode root, ArrayList<Integer> boundaryRes) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      return;
    }
    boundaryRes.add(root.data);

    if (root.left != null) {
      getLeftBoundaryNodes(root.left, boundaryRes);
    } else {
      getLeftBoundaryNodes(root.right, boundaryRes);
    }
  }

  static void getRightBoundaryNodes(TreeNode root, Stack<Integer> stack) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      return;
    }
    stack.add(root.data);

    if (root.right != null) {
      getRightBoundaryNodes(root.right, stack);
    } else {
      getRightBoundaryNodes(root.left, stack);
    }
  }

  static void inorder(TreeNode root, ArrayList<Integer> boundaryRes) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      boundaryRes.add(root.data);
      return;
    }

    inorder(root.left, boundaryRes);
    inorder(root.right, boundaryRes);
  }
}
