package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Invert/Mirror of tree
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * link: https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertTree {
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
    TreeNode invertedRoot = invertTree(root);
    System.out.println("Tree after iversion--- ");
    BFS(invertedRoot);
  }

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    if (!(root.left == null && root.right == null)) {
      swap(root, root.left, root.right);
    }
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  public static void swap(TreeNode root, TreeNode left, TreeNode right) {
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
}
