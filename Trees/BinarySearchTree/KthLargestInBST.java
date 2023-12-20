package Trees.BinarySearchTree;

/*
 * Link: https://workat.tech/problem-solving/practice/kth-largest-element-bst
 */
public class KthLargestInBST {

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
   * Approach 1: get the inorder traversal path and find the kth element from last of inorder path
   * 
   * Time: O(n), Space: O(n)
   */

  /*
   * Approach 2: Using priority queue
   *  - Define the Priority queue of size k (min priority queue), and keep on storing the inorder elements of tree
   *  - Once done, return the top element from the min priority queue (this will be the Kth largest element)
   * 
   * Time: O(n log(n)), Space: O(n) - PQ is of size k, n because of the recursive call stack of inorder
   */

  /*
   * Approach 3: While recursing for reverse inorder traversal
   * 
   * Time: O(n), Space: O(n), But this is better because we are not using any space to store the data again
   */

  int kthLargest = -1;
	int count = 0;
	int findKthLargest(Node root, int k) {
		kthLargest = -1;
		count = k;
		reverseInorder(root);
		
		return kthLargest;
	}
	
	void reverseInorder(Node root){
		if(root == null){
			return;
		}
		
		reverseInorder(root.right);
		
		count--;
		if(count == 0){
			kthLargest = root.data;
			return;
		}
		
		reverseInorder(root.left);
	}

}
