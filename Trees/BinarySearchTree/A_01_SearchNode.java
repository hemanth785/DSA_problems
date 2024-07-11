package Trees.BinarySearchTree;

public class A_01_SearchNode {
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

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (val == root.data) {
      return root;
    }
    if (val < root.data) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }
}
