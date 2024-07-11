package Trees.BinarySearchTree;

/* 
  link: https://workat.tech/problem-solving/practice/size-of-largest-bst-in-binary-tree 
*/
public class A_10_BiggestBSTinBinaryTree {
  public static class Node {
    int data;
    Node left = null;
    Node right = null;

    Node(){}

    Node(int data){
      this.data = data;
    }
    Node(int data, Node left, Node right){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /*
   * My Code:
   */

  static class NodeInfo {
    int min = 0, max = 0, size = 0;

    public NodeInfo(int size, int min, int max) {
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }

  // Return the size of the largest sub-tree which is also a BST
  static int largestBst1(Node root) {
    NodeInfo rootNode = largestBstRec(root);

    return rootNode.size;
  }

  static NodeInfo largestBstRec1(Node root) {
    if (root == null) {
      return null;
    }

    NodeInfo left = largestBstRec1(root.left);
    NodeInfo right = largestBstRec1(root.right);

    // do the processing
    if (left == null && right == null) {
      return new NodeInfo(1, root.data, root.data);
    }
    if (right == null) {
      if (root.data > left.max) {
        return new NodeInfo(left.size + 1, left.min, root.data);
      } else {
        return new NodeInfo(left.size, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }
    }
    if (left == null) {
      if (root.data < right.min) {
        return new NodeInfo(right.size + 1, root.data, right.max);
      } else {
        return new NodeInfo(right.size, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }
    }

    // if current node satisfies BST condition
    if (left.max < root.data && right.min > root.data) {
      return new NodeInfo(1 + left.size + right.size, left.min, right.max);
    }

    return new NodeInfo(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
  }



  /*
   * -----Simple code-----
   * 1. Declare a class named 'NodeInfo' which holds size of BST under it, and max and min values under which elements should be there
   * 
   * Note: If a BST subtree exists it should exists from leaf node below. otherwise it cannot exists in the middle or top of the tree
   */

  // Return the size of the largest sub-tree which is also a BST
  static int largestBst2(Node root) {
    NodeInfo rootNode = largestBstRec2(root);

    return rootNode.size;
  }

  static NodeInfo largestBstRec2(Node root) {
    if (root == null) {
      return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    NodeInfo left = largestBstRec2(root.left);
    NodeInfo right = largestBstRec2(root.right);

    // if current node satisfies BST condition
    // left.max -> indicates the max value among all the nodes from left sub tree
    // right.max -> indicates the min value among all the nodes from right sub tree
    if (root.data > left.max  && root.data < right.min) {
      return new NodeInfo(
          1 + left.size + right.size,
          Math.min(left.min, root.data),
          Math.max(right.max, root.data));
    }
    // if not return [-intMax, intMax], so that parent cannot validate to valid BST (i.e these values dont let the condition at line 107 to satisfy)
    return new NodeInfo(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
