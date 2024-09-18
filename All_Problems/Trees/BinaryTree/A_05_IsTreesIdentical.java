package Trees.BinaryTree;

public class A_05_IsTreesIdentical {
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
  public static void main(String[] args) {
    
  }

  /*
   * Solution 1: We can use any traversal below traversal to find whether tree is same or not
   * - Level
   * - Inorder
   * - preorder
   * - PostOrder
   */


  /*
   * Solution 2: quick recursive solution
   */
  boolean isIdentical(TreeNode root1, TreeNode root2)
	{
    if(root1 == null && root2 == null){
      return true;
    }
    
    if(root1 != null && root2 != null){
      if(root1.data != root2.data){
        return false;
      }
        
      return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    
    return false;
	}
}
