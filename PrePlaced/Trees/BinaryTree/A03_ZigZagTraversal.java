package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A03_ZigZagTraversal {
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
