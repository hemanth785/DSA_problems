package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class A06_CheckCousinNodes {
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

    boolean isCousins = isCousins(root,4,7);
    System.out.println("Is cousin nodes: "+ isCousins);
  }

  /*
   * Solution: 
   * for 2 nodes to be considered as cousins, it should meet follwing conditions
   * 1. Two nodes should at the same level in the tree
   * 2. Two nodes should not be siblings(i.e. two nodes should not have commen parent)
   *
   * Steps:
   * 1. Get the levels of two nodes, if levels are not same, return false
   * 2. Check if two nodes are having the same parent. if yes, return false
   */

  public static boolean isCousins(TreeNode root, int x, int y) {
    int leftLevel = getLevel(root, x);
    int rightLevel = getLevel(root, y);

    if (leftLevel == 0 || rightLevel == 0) {
      return false;
    }
    if (leftLevel != rightLevel) {
      return false;
    }
    if (isSiblings(root, x, y)) {
      return false;
    }
    return true;
  }

  public static int getLevel(TreeNode root, int data) {
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

  public static boolean isSiblings(TreeNode root, int x, int y) {
    if (root == null) {
      return false;
    }
    if ((root.left != null && root.right != null) &&
        ((root.left.data == x && root.right.data == y) ||
            (root.left.data == y && root.right.data == x))) {
      return true;
    }
    return (isSiblings(root.left, x, y) || isSiblings(root.right, x, y));
  }
}
