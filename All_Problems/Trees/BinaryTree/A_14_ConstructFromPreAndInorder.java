package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class A_14_ConstructFromPreAndInorder {
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
  public static void main(String[] args) {
    int preOrder[] = new int[]{1, 2, 4, 5, 7, 3, 6, 8};
    int inOrder[] = new int[]{4, 2, 7, 5, 1, 8, 6, 3};
    TreeNode root = buildTreeFromPreOrder(preOrder, inOrder);
    BFS(root);
  }

  /*Solution:  
   * 
   * 1. Start by reading 1st element from the preOrder list, 1st element will be root (In Post order last element will be root element)
   * 2. create a new node for that data
   * 3. identify the position(index) of the current element in InOrder list. (because in InOrder list, items on the left will be part of left sub tree and on the right will be part of right sub tree)
   * 4. For creating nodes on the left side of root node, call recursive function by passing left side of the list, w.r.t current node 
   * 5. For creating nodes on the right side of root node, call recursive function by passing right side of the list, w.r.t current node 
   * 6. Do this until we left with one node on left or right, then return that node.
  */
  static int preOrderIndex = 0;
  public static TreeNode buildTreeFromPreOrder(int[] preorder, int[] inorder) {
    return buildTreeRecursive(preorder, inorder, 0, preorder.length - 1);
  }

  public static TreeNode buildTreeRecursive(int[] preorder, int[] inorder, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    TreeNode newNode = new TreeNode(preorder[preOrderIndex]);
    preOrderIndex++;
    if (inStart == inEnd) {
      return newNode;
    }

    int newNodeInIndex = searchInOrder(inorder, newNode.data, inStart, inEnd);
    
    newNode.left = buildTreeRecursive(preorder, inorder, inStart, newNodeInIndex - 1);
    newNode.right = buildTreeRecursive(preorder, inorder, newNodeInIndex + 1, inEnd);

    return newNode;
  }

  public static int searchInOrder(int[] inorder, int key, int start, int end) {
    for (int i = start; i <= end; i++) {
      if (key == inorder[i]) {
        return i;
      }
    }
    return -1;
  }
}
