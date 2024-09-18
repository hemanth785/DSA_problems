package Trees.BinarySearchTree;

/*
 * link: https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

 * A valid BST is defined as follows:

 *  - The left subtree of a node contains only nodes with keys less than the node's key.
 *  - The right subtree of a node contains only nodes with keys greater than the node's key.
 *  - Both the left and right subtrees must also be binary search trees.
 */
public class A_03_CheckForBST {
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
   * Solution 1: Using InOrder traversal (Left, Right, Data)
   * 
   * We know that, InOrder traversal of Binary search tree is always a Ascending list
   * So get the InOrder path of BST, and then verify is all the elements are in sorted order (ASC)
   * 
   * Time: O(n)
   */

  /*
   * Solution 2: Recursive
   * 
   * Here we recursively check if the nodes of the tree are in the strict order of max an min rules of BST
   * i.e left subtree nodes should not contain any value greater than root 
   *  and left subtree nodes should not contain any value lesseer than root 
   */
  boolean checkBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean isBST(TreeNode root, int min, int max) {
    /* an empty tree is BST */
    if (root == null)
      return true;

    /* false if this node violates the min/max constraints */
    if (root.data < min || root.data > max)
      return false;

    /*
     * otherwise check the subtrees recursively
     * tightening the min/max constraints
     */
    return (isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max));
  }
}
