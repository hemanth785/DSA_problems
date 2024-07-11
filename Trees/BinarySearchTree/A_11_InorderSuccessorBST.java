package Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/* 
 * Link: https://workat.tech/problem-solving/practice/inorder-successor-bst
 */

public class A_11_InorderSuccessorBST {

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
   * Approach 2: finding the successor while traversing inorder (No need to store inorder path in array)
   * - initialize variable 'pFound' to indicate whether p is found
   * - traverse the tree with inOrder fashion, while checking for 3 conditions
   *   1. check if successor is already found in left subtree call, if yes, just return it
   *   2. check if p item is already found, if yes then immidiate next item (cur) is the successor
   *   3. if not check if cur item is the p, if yes mark p is found
   *   
   * Note: Here we know that, inorder successor is found when left subtree call is exiting.
   *       thats why we put the condition after the leftSubtree recursion call
   */

   boolean pFound;

  Node findSuccessor2(Node root, Node p) {
    pFound = false;
    return findSuccessor2(root, p);
  }

  Node findSuccessorDFS(Node root, Node p) {
    if (root == null) {
      return null;
    }

    Node leftFound = findSuccessorDFS(root.left, p);

    //check if successor is already found
    if (leftFound != null) {
      return leftFound;
    }
    //check if p item found, so that we can conclude current node is successor
    if (pFound) {
      return root;
    }
    //if current item is the p, mark it.
    if (root == p) {
      pFound = true;
    }

    return findSuccessorDFS(root.right, p);
  }

}
