package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * https://practice.geeksforgeeks.org/problems/bst-to-max-heap/1
 */
public class A03_BSTtoMaxHeap {
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
   * Solution: Steps
   * - Get the InOrder path for given BST (we know inOrder path for BST is always in sorted order, ascending)
   * - Then do the postOrderTraversal tree construct to create the maxHeap (post order - LRD)
   */
  static int inOrderIndex = 0;

  public static void inOrder(TreeNode curr, List<Integer> inOrderPath) {
    if (curr == null)
      return;

    // Left->>DATA->>Right
    inOrder(curr.left, inOrderPath);
    inOrderPath.add(curr.data);
    inOrder(curr.right, inOrderPath);
  }

  public static void postOrder(TreeNode curr, List<Integer> inOrderPath) {
    if (curr == null)
      return;

    // Left->>Right->>DATA
    postOrder(curr.left, inOrderPath);
    postOrder(curr.right, inOrderPath);
    curr.data = inOrderPath.get(inOrderIndex++);
  }

  public static void convertToMaxHeapUtil(TreeNode root) {
    List<Integer> inOrderTraversal = new ArrayList<>();
    inOrder(root, inOrderTraversal);
    inOrderIndex = 0;
    postOrder(root, inOrderTraversal);
  }
}
