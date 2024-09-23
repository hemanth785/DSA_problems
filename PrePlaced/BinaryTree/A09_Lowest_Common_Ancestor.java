package PrePlaced.BinaryTree;

public class A09_Lowest_Common_Ancestor {
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
   * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
   */
  public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    return findLCA(root, p, q);
  }

  public static TreeNode findLCA(TreeNode cur, int p, int q) {
    if (cur == null) {
      return null;
    }
    if (cur.data == p || cur.data == q) {
      return cur;
    }

    TreeNode left = findLCA(cur.left, p, q);
    TreeNode right = findLCA(cur.right, p, q);

    // this one is checking - for current node does both p and q found
    if (left != null && right != null) {
      return cur;
      // these 2 below one is for passing the found ancestor upwards till root (passing ans to top)
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    return null;
  }
}
