package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * What all incldued
 * 1. Initilization of tree class
 * 2. building tree
 * 3. pre-order traversal
 * 4. in-order traversal
 * 5. post-order traversal
 * 6. level order or BFS
 */

public class A_00_TreeImplementation {
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


  /*
   * Tree built
   */
  public static void main(String[] args) {
    TreeNode root = build();

    List<Integer> preOrderPath = new ArrayList<>();
    List<Integer> inOrderPath = new ArrayList<>();
    List<Integer> postOrderPath = new ArrayList<>();

    List<Integer> levelOrderPath = new ArrayList<>();
    
    preOrder(root, preOrderPath);
    System.out.println("Pre-order traversal: "+preOrderPath);

    inOrder(root, inOrderPath);
    System.out.println("In-order traversal: "+inOrderPath);

    postOrder(root, postOrderPath);
    System.out.println("post-order traversal: "+postOrderPath);

    BFS(root, levelOrderPath);
    System.out.println("level-order traversal: "+levelOrderPath);
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

  public static void preOrder(TreeNode cur, List<Integer> path){
    if(cur == null){
      return;
    }

    path.add(cur.data);
    preOrder(cur.left, path);
    preOrder(cur.right, path);
  }

  public static void inOrder(TreeNode cur, List<Integer> path){
    if(cur == null){
      return;
    }

    inOrder(cur.left, path);
    path.add(cur.data);
    inOrder(cur.right, path);
  }

  public static void postOrder(TreeNode cur, List<Integer> path){
    if(cur == null){
      return;
    }

    postOrder(cur.left, path);
    postOrder(cur.right, path);
    path.add(cur.data);
  }

  public static void BFS(TreeNode root, List<Integer> path){ //level order traversal
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
      TreeNode cur = queue.remove();

      path.add(cur.data); // this is for printing
      if(cur.left != null){
        queue.add(cur.left);
      }
      if(cur.right != null){
        queue.add(cur.right);
      }
    }
  }
}
