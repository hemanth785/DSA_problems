package PrePlaced.BinarySearchTree;

/*
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 */
public class A03_Check_for_BST {
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

  /* -------------------- */

  public boolean isValidBST(TreeNode root) {
    return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isBST(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    if (root.val > min && root.val < max) {
      return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    } else {
      return false;
    }
  }
}
