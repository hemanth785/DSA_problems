package Trees.BinarySearchTree;

import java.util.*;

/*
 * Link: https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class A_09_BST_Iterator {
  public static class Node {
    int data;
    Node left = null;
    Node right = null;

    Node() {
    }

    Node(int data) {
      this.data = data;
    }

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /*
   * Approach: Use the same DFS appraoch, but instead of using the inbuilt callstack,
   * use seperate stack to keep track of next node to process
   */
  Stack<Node> stack;

  public BST_Iterator(Node root) {
    stack = new Stack<>();

    // Insert all the left nodes of root to stack, 
    // because 1st element in the InOrder traversal is the leftMost element in the tree
    insertLeftNodes(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public Node next() {
    if (stack.isEmpty()) {
      return null;
    }

    Node root = stack.pop();

    //insert all the left subtree nodes of right child of current node
    Node cur = root.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }

    return root;
  }


}
