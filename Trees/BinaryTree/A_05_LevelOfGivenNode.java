package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a Binary Tree and a target key you need to find the level of target key in the given Binary Tree.
 * 
 * link: https://practice.geeksforgeeks.org/problems/level-of-a-node-in-binary-tree/1
 */

public class A_05_LevelOfGivenNode {
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

  public static void main(String[] args) {
    TreeNode root = build();
    BFS(root);

    int target = 12;
    // int levelOfNode = getLevelIterative(root, target);
    int levelOfNode = getLevelRecursive(root, target);
    System.out.println("Level of give node: "+ levelOfNode);
  }

  /*
   * Solution 1: Using level order traversal, while keeping track of level number
   * 
   * Time: O(n), Space: O(width of tree)
   */

  static int getLevelIterative(TreeNode root, int data) {
    if (root == null)
      return 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int level = 1;
    while (!q.isEmpty()) {
      int qSize = q.size();
      for (int i = 0; i < qSize; i++) {
        TreeNode curr = q.remove();

        if (curr.data == data)
          return level;

        if (curr.left != null)
          q.add(curr.left);
        if (curr.right != null)
          q.add(curr.right);
      }
      level++;
    }
    return 0;
  }

   /*
    * Solution 1: Recursive approach
    * Time: O(n), Space: O(height of tree)
    */
  static int level = 0;
  static int getLevelRecursive(TreeNode node, int data) {
    recursiveTraversal(node, data, 1);
    return level;
  }

  static void recursiveTraversal(TreeNode node, int data, int curLevel) {
    if (node == null) {
      return;
    }
    if (node.data == data) {
      level = curLevel;
      return;
    }
    recursiveTraversal(node.left, data, curLevel + 1);
    recursiveTraversal(node.right, data, curLevel + 1);
  }
}
