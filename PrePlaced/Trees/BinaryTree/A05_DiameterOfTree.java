package PrePlaced.BinaryTree;

public class A05_DiameterOfTree {
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

  /*--------------------------- */
  static int diameter;
  public static int diameterOfBinaryTree(TreeNode root) {
    diameter = 0;
    findMaxHeightAndDiameter(root);

    return diameter;
  }

  public static int findMaxHeightAndDiameter(TreeNode cur) {
    if (cur == null) {
      return 0;
    }
    int leftHeight = findMaxHeightAndDiameter(cur.left);
    int rightHeight = findMaxHeightAndDiameter(cur.right);

    diameter = Math.max(diameter, leftHeight + rightHeight);

    return 1 + Math.max(leftHeight, leftHeight);
  }
}
