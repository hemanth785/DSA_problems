package Trees.BinaryTree;

/*
 * Link: https://workat.tech/problem-solving/practice/symmetric-binary-tree
 * 
 * Explanation: https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
 */
public class A_04_SymmetricTree {
  static class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int data) {
			this.data = data;
		}
	}
  
  boolean isSymmetric(Node root) {
    return isMirror(root.left, root.right);
  }

  boolean isMirror(Node root1, Node root2){
    if(root1 == null && root2 == null){
      return true;
    }
    
    if(root1 != null && root2 != null && root1.data == root2.data){
      return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
    
    return false;
  }
}
