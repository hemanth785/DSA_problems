package Trees.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;
public class MaxDepth {
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

  public static void main(String[] args) {
    TreeNode root = build();

    int height = findMaxDepthIterative(root);
    System.out.println("max dept of tree: "+height);

  }

  public static int findMaxDepthIterative(TreeNode root){ //using level order traversal
    if(root == null){
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    queue.add(null); //this is marker to incrementing height

    int height = 0;
    while(!queue.isEmpty()){
        TreeNode cur = queue.remove();
        if(cur == null){
            height++;
            if(!queue.isEmpty()){
                queue.add(null);
            }
        } else {
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }
    return height;
  }

  /*
   * for each iteration, while each function call is removing from call stack
   * add 1 height from each node and max height of its child nodes (left or right)
   */
  public static int findMaxDepthRecursive(TreeNode root){ //recursive approach
    if(root == null){
        return 0;
    }

    return 1 + Math.max( findMaxDepthRecursive(root.left), findMaxDepthRecursive(root.right));
  }
}
