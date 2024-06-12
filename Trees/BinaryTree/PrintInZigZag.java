package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * 
 * link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */
public class PrintInZigZag {
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
    List<List<Integer>> zigZag = zigzagLevelOrder(root);
    System.out.println("Zig zag traversal: ");
    System.out.println(zigZag);
  }

  /*
   * Approach: Using 2 stacks
   * 1. Initially push the root node to stack1
   * 2. run the while loop, till any one the stack is not empty
   * 3. if stack1 is not empty, pop elements from stack1 while adding its child nodes to stack2, till stack1 becomes empty
   * 4. Next pop elements from stack2 while adding child nodes to stack1, until it becomes emtpy
   * 5. Do this until both stack becomes empty
   */
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> zigZag = new ArrayList<>();

    if (root == null) {
      return zigZag;
    }

    Stack<TreeNode> stack1 = new Stack<>(); // left to right traversal
    Stack<TreeNode> stack2 = new Stack<>(); // left to right traversal

    stack1.push(root);

    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      List<Integer> tempList = new ArrayList<>();
      while (!stack1.isEmpty()) {
        TreeNode cur = stack1.pop();
        if (cur.left != null) {
          stack2.push(cur.left);
        }
        if (cur.right != null) {
          stack2.push(cur.right);
        }
        tempList.add(cur.data);
      }
      if (!tempList.isEmpty()) {
        zigZag.add(tempList);
      }

      tempList = new ArrayList<>();
      while (!stack2.isEmpty()) {
        TreeNode cur = stack2.pop();
        if (cur.right != null) {
          stack1.push(cur.right);
        }
        if (cur.left != null) {
          stack1.push(cur.left);
        }
        tempList.add(cur.data);
      }
      if (!tempList.isEmpty()) {
        zigZag.add(tempList);
      }
    }
    return zigZag;
  }
}
