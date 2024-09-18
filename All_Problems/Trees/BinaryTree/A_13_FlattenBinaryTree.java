package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
public class A_13_FlattenBinaryTree {
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

    flattenRecursive(root);


    System.out.println("Atfer flattening---");
    BFS(root);
  }
  
  /*  Solution 1  -Recursive---- */

  public static void flattenRecursive(TreeNode root) {
    flatternRecursive(root);
  }

  public static TreeNode flatternRecursive(TreeNode cur) {
    if (cur == null) {
      return null;
    }
    if (cur.left != null) {
      // store right tree in temp until we flattern left tree completely
      TreeNode tempRight = cur.right;
      cur.right = cur.left;
      cur.left = null;

      // flatten left to right moved node, further
      cur = flatternRecursive(cur.right);

      // flattern remaining right tree stored in temp
      if (tempRight != null) {
        cur.right = tempRight;
        cur = flatternRecursive(cur.right);
      }
      return cur;
    }

    if (cur.right != null) {
      return flatternRecursive(cur.right);
    }
    return cur;
  }

  /*Solution 2: Iterative approach --- Easy to understand */ 

  public static void flatternIterative(TreeNode root){
    while(root != null){
      //check for each right node, any left sub tree exists
      if(root.left != null){
        
        //if Yes, assign the right subtree to temp and assign left sub tree as right child of cur node
        TreeNode cur = root;
        TreeNode tempRight = cur.right;
        cur.right = cur.left;
        cur.left = null;

        //move till the right end of, right assigned left tree
        while(cur.right != null){
            cur=cur.right;
        }
        //connect the right assigned left tree, to original right tree
        cur.right = tempRight;
      }
      root = root.right;
    }

  }

}
