package Trees.BinaryTree;

public class BinaryTreeToDLL {
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

  Node head = null;
  Node prev = null;

  Node binaryTreeToDoublyLinkList(Node root) {
    head = null;
    prev = null;
    convertBinaryTreeToDLL(root);
    return head;
  }

  void convertBinaryTreeToDLL(Node root) {
    if (root == null) {
      return;
    }

    convertBinaryTreeToDLL(root.left);

    if (head == null) {
      head = root;
    } else {
      root.left = prev;
      prev.right = root;
    }

    prev = root;

    convertBinaryTreeToDLL(root.right);
  }
}
