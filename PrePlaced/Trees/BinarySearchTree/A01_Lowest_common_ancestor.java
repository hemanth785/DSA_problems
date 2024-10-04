package PrePlaced.BinarySearchTree;

/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class A01_Lowest_common_ancestor {
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

  /* ----------------- */
  public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    return findLCA(root, p, q);
  }

  public static TreeNode findLCA(TreeNode cur, int p, int q) {
    if (cur == null) {
      return null;
    }

    if (p < cur.data && q < cur.data) {
      return findLCA(cur.left, p, q);
    } 
    if (p > cur.data && q > cur.data) {
      return findLCA(cur.right, p, q);
    } 
    return cur;
  }
}
