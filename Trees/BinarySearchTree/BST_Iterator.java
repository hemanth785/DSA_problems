package Trees.BinarySearchTree;

import java.util.*;

/*
 * Link: https://workat.tech/problem-solving/practice/binary-search-tree-iterator
 */
public class BST_Iterator {
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
   * Approach: Use the same DFS appraoch, but instead of using the inbuilt
   * callstack,
   * use seperate stack to keep track of next node to process
   */
  Stack<Node> stack;

  public BST_Iterator(Node root) {
    stack = new Stack<>();

    // insert all the left nodes for root
    insertLeftNodes(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public Node next() {
    Node curNode = stack.pop();

    Node rightNode = curNode.right;
    if (rightNode != null) {
      stack.push(rightNode);

      // insert all the left nodes of next right node
      Node rightLeftnode = rightNode.left;
      insertLeftNodes(rightLeftnode);
    }

    return curNode;
  }

  // helper function
  private void insertLeftNodes(Node cur) {
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
  }
}