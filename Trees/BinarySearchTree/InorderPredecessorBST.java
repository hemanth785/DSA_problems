package Trees.BinarySearchTree;

/*
 * Link: https://workat.tech/problem-solving/practice/inorder-predecessor-bst
 */
public class InorderPredecessorBST {
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

  /* Approach: Optimum (Same as InorderSuccessor with slight condition change) */
  Node predecessor;
	Node findPredecessor(Node root, Node p) {
		predecessor = null;
	    
		DFS(root, p);
		
		return predecessor;
	}
	
	void DFS(Node root, Node p){
		if(root == null){
			return;
		}
		
		DFS(root.left, p);
		
		if(predecessor == null && root.data < p.data){
			predecessor = root;
		}
		if(predecessor != null && root.data > predecessor.data && root.data < p.data){
			predecessor = root;
		}
		
		DFS(root.right, p);
	}
}
