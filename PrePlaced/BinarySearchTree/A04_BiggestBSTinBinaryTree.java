package Trees.BinarySearchTree;

/* 
  link: https://workat.tech/problem-solving/practice/size-of-largest-bst-in-binary-tree 
*/
public class A04_BiggestBSTinBinaryTree {
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
   * -----Simple code-----
   * 1. Declare a class named 'NodeInfo' which holds size of BST under it, and max and min values under which elements should be there
   * 
   * Note: If a BST subtree exists it should exists from leaf node below. otherwise it cannot exists in the middle or top of the tree
   */

  static class TreeInfo {
    int size, min, max;

    TreeInfo(int size, int min, int max) {
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }

  // Return the size of the largest sub-tree which is also a BST
  static int largestBst(Node root) {
    TreeInfo treeInfo = largestBstRec(root);
    return treeInfo.size;
  }

  static TreeInfo largestBstRec(Node root) {
    if (root == null) {
      return new TreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    TreeInfo leftTree = largestBstRec(root.left);
    TreeInfo rightTree = largestBstRec(root.right);

    // if current node satisfies BST condition
    // left.max -> indicates the max value among all the nodes from left sub tree
    // right.max -> indicates the min value among all the nodes from right sub tree
    if (root.data > leftTree.max && root.data < rightTree.min) {
      return new TreeInfo(
          1 + leftTree.size + rightTree.size,
          Math.min(root.data, leftTree.min),
          Math.max(root.data, rightTree.max));
    } else {
      // return [-intMax, intMax], so that parent cannot validate to valid BST (i.e
      // these values dont let the condition at line 59 to satisfy)
      return new TreeInfo(
          Math.max(leftTree.size, rightTree.size),
          Integer.MIN_VALUE,
          Integer.MAX_VALUE);
    }
  }
}
