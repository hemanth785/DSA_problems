package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class A21_Connect_nodes_at_same_level {
  class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
  }
  
  /*
   * Using BFS - 
   * 
   * Time: O(n), Space: O(2^(height))
   */
  public Node connect(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    
    while(!queue.isEmpty()){
      int n = queue.size();
      Node prev = null;
        
      for(int i=0; i<n; i++){
        Node curNode = queue.remove();
        curNode.nextRight = null;
        if(prev != null){
          prev.nextRight = curNode;
        }
        if(curNode.left != null){
          queue.add(curNode.left);
        }
        if(curNode.right != null){
          queue.add(curNode.right);
        }
        prev = curNode;
      }
    }
    
    return root;
  }
}
