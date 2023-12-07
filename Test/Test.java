package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
  static class Node {
    public Node left;
      public Node right;
      int data;
  
      Node(int data) {
          this.data = data;
      }
  }
  public static void main(String[] args) {
    int preorder[] = {1, 2, 4, 5, 7, 3, 6, 8};
    int inorder[] = {4, 2, 7, 5, 1, 8, 6, 3};
    constructTree(preorder, inorder);
  }

  static int preOrderIndex = 0;
	static Node constructTree(int[] preorder, int[] inorder) {
		int l = 0;
		int r = preorder.length-1;
		return constructTree(preorder, inorder, l, r);
	}
	
	static Node constructTree(int[] preorder, int[] inorder, int l, int r){
		if(l>r){
			return null;
		}
		
	  Node node = new Node(preorder[preOrderIndex++]);
		if(l==r){
			return node;
		}
		
		int currentNodePreIndex = getInorderIndex(inorder, l, r, node.data);
		
		node.left = constructTree(preorder, inorder, l, currentNodePreIndex-1);
		node.right = constructTree(preorder, inorder, currentNodePreIndex+1, r);
		
		return node;
	}
	
	static int getInorderIndex(int[] inorder, int l, int r, int item){
		for(int i=l; i<=r; i++){
			if(inorder[i] == item){
				return i;
			}
		}
		return -1;
	}
}
