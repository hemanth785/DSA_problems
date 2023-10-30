package Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommenAncestorBST {
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
  *                   6
  *                 /   \  
  *                2     8
  *               / \   / \
  *              0   4 7   9
  *                   
  *                 
  */
  public static TreeNode build(){
    TreeNode root = new TreeNode(6);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);

    root.right = new TreeNode(8);

    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);

    return root;
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
  public static void main(String[] args) {
    TreeNode root = build();
    BFS(root);
    TreeNode lca = lowestCommonAncestor(root, 2, 4);
    System.out.println("lowest common ancestor: "+lca.data);
  }

  /* Solution: The below solution works only for Bineary search tree
   * - if both p and q node in tree less than current node, that means these nodes exists in left subtree of current node
   * - if both p and q node in tree greater than current node, that means these nodes exists in right subtree of current node
   * - if both conditions is not true, that means from given nodes one exists on the left and another on right
   *    that means, current node will be the lowest commen ancestor
   * 
  */
  public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    return findLCA(root, p, q);
  }

  public static TreeNode findLCA(TreeNode cur, int p, int q) {
    if (cur == null) {
      return null;
    }

    if (p < cur.data && q < cur.data) {
      return findLCA(cur.left, p, q);
    } 
    if (p > cur.data && q > cur.data) {
      return findLCA(cur.right, p, q);
    } 
    return cur;
  }
}
