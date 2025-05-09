package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Link: https://leetcode.com/problems/balanced-binary-tree/description/
 */
/*
 * Check if the tree is complete binary tree
 * 
 * COMPLETE BINARY TREE: 
 *  - all levels are filled, except for last level
 *  - all leaf nodes must lean towards left
 */
public class A_08_CheckBalanced {
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
  public static void BFS(TreeNode root){ //level order traversal custom
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    System.out.print("level-order traversal: "); 
    while(!queue.isEmpty()){
      TreeNode cur = queue.remove();

      System.out.print(cur.data+", ");
      if(cur.left != null){
        queue.add(cur.left);
      }
      if(cur.right != null){
        queue.add(cur.right);
      }
    }
    System.out.println();
  }

  /*Tree
  *                   1
  *                 /   \  
  *                2     5
  *               / \   / \
  *              4   6 3   7
  *                   / \
  *                  9  12
  */
  public static TreeNode build(){
    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(3);

    root.right = new TreeNode(5);

    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(12);

    return root;
  }

  /*
   * Approach:
   * 1. Call recursive function to get the maxHeight of tree
   * 2. this recursive function while returning the height of each branch of tree
   *      also checks if height diff between left subtree and right subtree is more than 1
   *    - if Yes, its returns -1 and all the subsequent function calls returns -1 only
   * Then we can conclude its not balanced
   */

  public static void main(String[] args) {
    TreeNode root = build();
    BFS(root);

    System.out.println("Is balanced: "+ isBalanced(root));
  }

  public static boolean isBalanced(TreeNode root) {
    int height = getMaxHeightDiffOfTree(root);
    if (height == -1) {
      return false;
    }
    return true;
  }

  public static int getMaxHeightDiffOfTree(TreeNode cur) {
    if (cur == null) {
      return 0;
    }
    int leftHeight = getMaxHeightDiffOfTree(cur.left);
    int rightHeight = getMaxHeightDiffOfTree(cur.right);

    if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return 1 + Math.max(leftHeight, rightHeight);
  }
  
}
