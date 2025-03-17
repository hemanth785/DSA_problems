package Trees.BinaryTree;

/*
 * Link: https://leetcode.com/problems/invert-binary-tree/
 */
public class A08_Invert_Binary_Tree {
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
  
  public TreeNode invertTree(TreeNode root) {
    invertDFS(root);

    return root;
  }

  public void invertDFS(TreeNode root) {
    if (root == null) {
      return;
    }

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertDFS(root.left);
    invertDFS(root.right);
  }
}
