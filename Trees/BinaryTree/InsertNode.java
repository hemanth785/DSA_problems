package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
public class InsertNode {
  
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

  public static void BFS(TreeNode root){ //level order traversal
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
    insertNode(root, 50);
    BFS(root);
  }

  /*
   * Approach:
   * 1. traverse the tree starting from root
   * 2. if root is null, return the new node as root node
   * 3. traverse each node while checking if left or right child is null for any node
   * 4. if left is empty, add newNode to the left of cur node else to the right of cur node
   */
  public static TreeNode insertNode(TreeNode root, int data){
    TreeNode newNode = new TreeNode(data);

    if(root == null){
      return newNode;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      TreeNode cur = queue.remove();

      if(cur.left == null){
        cur.left = newNode;
        break;
      } 
      queue.add(cur.left);

      if(cur.right == null){
        cur.right = newNode;
        break;
      }
      queue.add(cur.right);
    }
    return root;
  }
}
