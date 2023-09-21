package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them
 */
public class FindDiameter {
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

  /*
   * Tip: Diameter of tree can be find out by (max number of edges between any two nodes in tree)
   * - at each level, find the left max height and right max height
   * - then find the sum of the leftMaxHeight and rightMaxHeight
   * - so diameter  = max( diameter, leftMaxheight + rightMaxHeigh)
   */
  public static void main(String[] args) {
    TreeNode root = build();
    BFS(root);

    int diameter = diameterOfBinaryTree(root);
    System.out.println("Diamter of given tree is: "+diameter);
  }

  static int diameter = 0;
  public static int diameterOfBinaryTree(TreeNode root) {
    int maxHeight = findMaxHeightAndDiameter(root);

    return diameter;
  }

  public static int findMaxHeightAndDiameter(TreeNode cur) {
    if (cur == null) {
      return 0;
    }
    int leftHeight = findMaxHeightAndDiameter(cur.left);
    int rightHeight = findMaxHeightAndDiameter(cur.right);

    diameter = Math.max(diameter, leftHeight + rightHeight);

    return 1 + Math.max(leftHeight, leftHeight);
  }
}
