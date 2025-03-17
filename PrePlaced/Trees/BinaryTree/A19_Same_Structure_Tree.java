package Trees.BinaryTree;

public class A19_Same_Structure_Tree {
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
  /* ------------- */

  static boolean isSameStructure(TreeNode a, TreeNode b) {
    // 1. both empty
    if (a == null && b == null)
      return true;

    // 2. both non-empty . compare them
    if (a != null && b != null) {
      return (isSameStructure(a.left, b.left) &&
          isSameStructure(a.right, b.right));
    }

    // 3. one empty, one not . false
    return false;
  }
}
