package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
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
    deleteNode(root, 2);
    BFS(root);
  }

  /*
   * Approach: 
   * - Starting at the root, find the deepest and rightmost node in the binary tree and the node which we want to delete. 
   * - Replace the deepest rightmost node’s data with the node to be deleted. 
   * - Then delete the deepest rightmost node.
   *
   */

  public static TreeNode deleteNode(TreeNode root, int key){
    if(root == null){
      return root;
    }

    TreeNode keyNode = null;
    TreeNode cur = null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      cur = queue.remove();

      if(cur.data == key){
        keyNode = cur;
      }

      if(cur.left != null){
        queue.add(cur.left);
      } 
      
      if(cur.right != null){
        queue.add(cur.right);
      } 
    }

    if(keyNode == null){
      System.out.println("Node is not present in the tree");
      return root;
    } else if(keyNode != cur) {
      //swap the deepest node, after all traversal 'cur' will be our deepest node
      keyNode.data = cur.data;
    }
    deleteBottomRightNode(root, cur);
    return root;
  }

  public static TreeNode deleteBottomRightNode(TreeNode root, TreeNode delNode){
    if(root == null){
      return root;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
      TreeNode cur = queue.remove();

      //this case happens only root node is present in tree
      if(cur == delNode){
        return null;
      }

      if(cur.left != null){
        if(cur.left == delNode){
          cur.left = null;
          return root;
        } else {
          queue.add(cur.left);
        }
      }

      if(cur.right != null){
        if(cur.right == delNode){
          cur.right = null;
          return root;
        } else {
          queue.add(cur.right);
        }
      }
    }

    return root;

  }
}
