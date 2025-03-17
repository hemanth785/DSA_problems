package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A02_LevelOrder_BFS {
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
