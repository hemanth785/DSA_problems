package PrePlaced.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversals {
  public static void main(String[] args) {
    
  }

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

  // 01. Using Recursion
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


  // 02. Using Iteration (with loop)

  /*
   * Appraoch: Use stack
   * - We have to run a while loop until, if cur node is exists or stack is not empty
   * - Start with root node, print the node value first and then add the node to stack, to check if any right node exists
   * - if cur pointer is not empty, print the node value and add it to stack
   * - else, pop the top item from stack, if topNode has right child, assign that right child to 'cur' pointer
   */
  public List<Integer> preorderIterative(TreeNode root) {
    List<Integer> preOrder = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        preOrder.add(cur.data);
        stack.push(cur);
        cur = cur.left;

      } else {
        TreeNode topNode = stack.pop();
        if (topNode.right != null) {
          cur = topNode.right;
        }
      }
    }

    return preOrder;
  }

  /*
   * Approach: Use stack
   * - Same as PreOrder, only diff is -> print the item while removing item from stack
   */
  public List<Integer> inorderIterative(TreeNode root) {
    List<Integer> inOrder = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        TreeNode top = stack.pop();
        inOrder.add(top.data);

        if (top.right != null) {
          cur = top.right;
        }
      }
    }

    return inOrder;
  }

  /*
   * Approach: Use stack
   * - Same as InOrder, only diff is
   * - print when removing item from stack, and if that item is not having any right child node
   * - If there is right child node exists for current not, 
   *   - make cur node as right child
   *   - remove right pointer from topNode
   *   - add the topNode back to stack.
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postOrder = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode cur = root;

    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        TreeNode top = stack.pop();
        if (top.right == null) {
          postOrder.add(top.data);
        } else {
          cur = top.right;
          top.right = null;
          stack.push(top);
        }
      }
    }

    return postOrder;
  }
}
