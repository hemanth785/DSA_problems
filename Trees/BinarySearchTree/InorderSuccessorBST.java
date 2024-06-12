package Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/* 
 * Link: https://workat.tech/problem-solving/practice/inorder-successor-bst
 */

public class InorderSuccessorBST {

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
   * Approach 1: get the inorder path and find the next element of given element
   * from array
   */

  List<Node> inorderPath;

  Node findSuccessor(Node root, Node p) {
    inorderPath = new ArrayList<>();
    inorder(root);

    boolean found = false;
    Node successor = null;
    for (Node node : inorderPath) {
      if (found) {
        successor = node;
        break;
      }
      if (node.data == p.data) {
        found = true;
      }
    }

    return successor;
  }

  void inorder(Node root) {
    if (root == null) {
      return;
    }

    inorder(root.left);
    inorderPath.add(root);
    inorder(root.right);
  }

  /*
   * Approach 2: finding the successor while traversion inorder (No need to store inorder path in array)
   * - Traverse the given BST and if a node is found which is greater than the node p and smaller than the previously stored successor node
   *     then update the successor node.
   * - Return the successor node as the answer.
   */

  Node successor;
  Node findSuccessor2(Node root, Node p) {
    successor = null;
    findNode(root, p);
    return successor;
  }

  void findNode(Node root, Node p) {
    if (root.left != null) {
      findNode(root.left, p);
    }
    if (successor == null && root.data > p.data) {
      successor = root;
    } else if (successor != null && root.data > p.data && root.data < successor.data) {
      successor = root;
    }
    if (root.right != null) {
      findNode(root.right, p);
    }
    return;
  }

}
