package Trees.BinaryTree;

/*
 * Link: https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1
 */
public class A13_Binary_tree_to_DLL {
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
    if(root == null){
      return;
    }
    
    convertBinaryTreeToDLL(root.left);
    
    //assign head
    if(head == null){
        head = root;
    }
    
    //make connection with prev node and current node
    if(prev != null){
        prev.right = root;
        root.left = prev;
    }
    
    prev = root;
    
    convertBinaryTreeToDLL(root.right);
  }
}
