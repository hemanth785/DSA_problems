package PrePlaced.BinaryTree;

/*
 * Link: https://leetcode.com/problems/symmetric-tree/
 */
public class A07_Check_If_Symmetric {
  public static class TreeNode {
    int data;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode() {
    }

    TreeNode(int data) {
      this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /*------------------------------ */

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetricRec(root.left, root.right);
  }

  public boolean isSymmetricRec(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if ((left == null && right != null) ||
        (left != null && right == null) ||
        left.data != right.data) {
      return false;
    }

    return isSymmetricRec(left.left, right.right) && isSymmetricRec(right.left, left.right);
  }
}
