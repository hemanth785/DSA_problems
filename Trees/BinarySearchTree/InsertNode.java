package Trees.BinarySearchTree;

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
    int arr[] = new int[]{5,4,6,2,3,7,9,5,3};
    TreeNode root = buildTreeFromArray(arr);

    BFS(root);
  }

  public static TreeNode buildTreeFromArray(int[] arr){
    TreeNode root = null;
    for(int i=0; i<arr.length; i++){
      if(root == null){
        root = insertNode(root, arr[i]); 
      } else {
        insertNode(root, arr[i]); 
      }
      
    }
    return root;
  }

  public static TreeNode insertNode(TreeNode root, int data){
      TreeNode curr = root;

      if(curr == null){
        return new TreeNode(data);
      }

      while(curr != null){
        if(data < curr.data){

          if(curr.left == null){
            curr.left = new TreeNode(data);
            return root;
          }
          curr = curr.left;
        } else {

          if(curr.right == null){
            curr.right = new TreeNode(data);
            return root;
          }
          curr = curr.right;
        }
      }

      return root;
  }
}
