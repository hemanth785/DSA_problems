package Trees.BinarySearchTree;

/*
 * Link: https://workat.tech/problem-solving/practice/inorder-predecessor-bst
 * 
 * 
 */
public class A06_InorderPredecessorBST {
  public static class Node {
    int data;
    Node left = null;
    Node right = null;

    Node() {
    }

    Node(int data) {
      this.data = data;
    }

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /* Approach: Optimum 
   * Note: This is reversal of InorderSuccessor(A_11) problem,  (traverse in reverse inorder)
   *  we need to  traverse Right node -> root node (or logic) -> left node  
   * 
  */
  boolean keyFound;
	Node findPredecessor(Node root, Node p) {
		keyFound = false;
	    return findSuccessor2(root, p);
	}
	
	Node findSuccessor2(Node root, Node p){
		if(root == null){
			return null;
		}
		
		Node rightFound = findSuccessor2(root.right, p);
		
		if(rightFound != null){
			return rightFound;
		}
		
		if(keyFound){
			return root;
		}
		
		if(root == p){
			keyFound = true;
		}
		
		return findSuccessor2(root.left, p);
	}
}
