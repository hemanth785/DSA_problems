package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {
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

  public static int traverseRecursive(TreeNode cur) {
    if (cur == null) {
      return 0;
    }
    int leftMax = traverseRecursive(cur.left);
    int rightMax = traverseRecursive(cur.right);

    // find max among path - only cur, cur+left, cur+right
    int localMax = Math.max(cur.data, Math.max(cur.data + leftMax, cur.data + rightMax));
    /*
     * Here we are calculating 'localMax' seperately because, this needs to return to parent node
     * So we either need to return current node and left path sum or right path sum, but not entire tree sum to parent node
     * But we can check if current tree has max sum than existing sum calculated till now 
     */

    // find max among this tree path(either left or right) and enitre tree itself
    int tempAnsMax = Math.max(localMax, cur.data + leftMax + rightMax);

    // check if currentTree max is greater than ans
    globalMax = Math.max(globalMax, tempAnsMax);

    return localMax;
  }


  /*
   * This also works - But code is duplicate
   * 
   * //Here we are checking all 4 scenarios - root | root+left | root+right | root+left+right
   * int curMax = Math.max(root.val, Math.max(root.val + leftSum, Math.max(root.val+rightSum, root.val+ leftSum+rightSum)));
   * maxSum = Math.max(maxSum, curMax);
   *
   * //here we are checking only 3 conditions - root | root+left | root + right
   * return Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
   */
}
