package Trees.BinaryTree;

public class A_11_BinaryTreeToDLL {
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

  /*
   * Steps: 
   * 1. globally declare the head of DLL and previous pointers
   * 2. Traverse to the leftmost node of Binary tree
   * 3. Make the leftmost node of tree as Head of the DLL
   * 4. make the connections between current node and prev node by assingning the proper pointers
   * 5. make cur node as prev node
   * 6. call the same rec function for the right node of tree
   * 
   * Note: In resultant DLL, nodes will be arranged in InOrder traversal of tree
   */
  
  void convertBinaryTreeToDLL(Node root) {
    if (root == null) {
      return;
    }

    convertBinaryTreeToDLL(root.left);

    if (head == null) {
      head = root; // This only executes once
    } else {
      root.left = prev;
      prev.right = root;
    }

    prev = root;

    convertBinaryTreeToDLL(root.right);
  }
}
