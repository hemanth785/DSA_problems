package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a Binary Tree A containing N nodes.
 * You need to find the path from Root to a given node B.
 * 
 * link: https://www.interviewbit.com/problems/path-to-given-node/
 */
public class PathToTarget {
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
    ArrayList<Integer> path = pathToTarget(root, 12);
    System.out.println("Path to target: ");
    System.out.println(path);
  }

  public static ArrayList<Integer> pathToTarget(TreeNode root, int key) {
    ArrayList<Integer> path = new ArrayList<Integer>();
    hasPath(root, key, path);
    return path;
  }

  public static boolean hasPath(TreeNode cur, int key, ArrayList<Integer> path) {
    if (cur == null) {
      return false;
    }
    path.add(cur.data);
    if (cur.data == key) {
      return true;
    }
    boolean leftHasPath = hasPath(cur.left, key, path);
    boolean rightHasPath = hasPath(cur.right, key, path);

    if (leftHasPath || rightHasPath) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }
}
