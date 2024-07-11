package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Link: https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/swap-nodes-algo
 */

public class A_16_Swap_nodes_hackerrank {
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
    
  public static void inOrder(TreeNode cur, List<Integer> path){
    if(cur == null){
      return;
    }

    inOrder(cur.left, path);
    path.add(cur.data);
    inOrder(cur.right, path);
  }

  public static TreeNode constructTree(List<List<Integer>> indexes){
    Queue<TreeNode> queue = new LinkedList<>();
    
    //create root node
    TreeNode root = new TreeNode(1);
    queue.add(root);
    
    //create a tree from indexes
    for(List<Integer> nodes: indexes){
      Integer leftNodeVal = nodes.get(0);
      Integer rightNodeVal = nodes.get(1);
      
      TreeNode cur = queue.remove();
      if(leftNodeVal != -1){
        cur.left = new TreeNode(leftNodeVal);
        queue.add(cur.left);
      }
      if(rightNodeVal != -1){
        cur.right = new TreeNode(rightNodeVal);
        queue.add(cur.right);
      }
    }

    return root;
  }
    
  public static void swapLevelOrder(TreeNode root, int k){
    if(root == null){
        return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    int level = 1;
    while(!queue.isEmpty()){
      int length = queue.size();
      System.out.println("length: "+length);
      while(length > 0){
        //add left and right nodes to queue
        TreeNode cur = queue.remove();
        if(cur.left != null){
          queue.add(cur.left);
        }
        if(cur.right != null){
          queue.add(cur.right);
        }
        
        //swap nodes
        if(level%k == 0){
          TreeNode temp = cur.left;
          cur.left = cur.right;
          cur.right = temp;
        }
        
        length--;
      }
      level++;
    }
  }
    
  /*--THIS IS THE MAIN/ENTRY FUNCTION--- */
  public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
      
    List<List<Integer>> res = new ArrayList<>();
    
    //construct tree from given node values
    TreeNode root = constructTree(indexes);
    
    for(Integer k: queries){
      //swap nodes at k level
      swapLevelOrder(root, k);
      
      //add the inorder traversal patht to result
      List<Integer> inorderPath = new ArrayList<>();
      inOrder(root, inorderPath);
      res.add(inorderPath);
    }
    
    return res;
  }
}
