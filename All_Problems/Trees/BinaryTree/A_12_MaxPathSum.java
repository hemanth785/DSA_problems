package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */

public class A_12_MaxPathSum {
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
  public static TreeNode build() {
    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(6);

    root.right = new TreeNode(5);

    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(7);

    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(12);

    return root;
  }

  public static void main(String[] args) {
    TreeNode root = build();
    BFS(root);

    int maxPathSum = maxPathSum(root);
    System.out.println("Max path sum: "+ maxPathSum);
  }


  static int globalMax = Integer.MIN_VALUE;
  public static int maxPathSum(TreeNode root) {
    traverseRecursive(root);
    return globalMax;
  }

  public static int traverseRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMaxSum = traverseRecursive(root.left);
    int rightMaxSum = traverseRecursive(root.right);

    // Here we are checking all 4 scenarios - root | root+left | root+right | root+left+right
    int curMax = Math.max(root.data, Math.max(root.data + leftMaxSum, Math.max(root.data+rightMaxSum, root.data+ leftMaxSum+rightMaxSum)));
    globalMax = Math.max(globalMax, curMax);
   
    // Here we are checking only 3 conditions - root | root+left | root + right
    return Math.max(root.data, Math.max(root.data + leftMaxSum, root.data + rightMaxSum));
  }


}
