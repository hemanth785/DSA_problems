package Trees.BinarySearchTree;

public class A_05_KthSmallestInBST {
  public static class Node {
    int data;
    Node left = null;
    Node right = null;

    Node(){}

    Node(int data){
      this.data = data;
    }
    Node(int data, Node left, Node right){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
  
  /*
   * Approach 1: get the inorder traversal path and find the kth element from 1st of inorder path
   * 
   * Time: O(n), Space: O(n)
   */

  /*
   * Approach 2: Using priority queue
   *  - Define the Priority queue of size k (max priority queue), and keep on storing the inorder elements of tree
   *  - Once done, return the top element from the max priority queue (this will be the Kth largest element)
   * 
   * Time: O(n log(n)), Space: O(n) - PQ is of size k, n because of the recursive call stack of inorder
   */

  /*
   * Approach 3: While recursing for inorder traversal
   * 
   * Time: O(n), Space: O(n), But this is better because we are not using any space to store the data again
   */

  int kthSmallest = 0;
	int count = 0;
	int findKthSmallest(Node root, int k) {
	  kthSmallest = 0;
		count = k;
		inorder(root);
		
		return kthSmallest;
	}
	
	void inorder(Node root){
		if(root == null){
			return;
		}
		
		inorder(root.left);
		
		count--;
		if(count == 0){
			kthSmallest = root.data;
			return;
		}
		
		inorder(root.right);
	}
}
