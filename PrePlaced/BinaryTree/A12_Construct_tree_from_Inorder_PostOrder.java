package PrePlaced.BinaryTree;

public class A12_Construct_tree_from_Inorder_PostOrder {
  
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
  

  int postorderIndex = 0;
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    //process postOrder path from last. 
    postorderIndex = postorder.length - 1;
    return buildTreeRecursive(postorder, inorder, 0, postorder.length - 1);
  }

  public TreeNode buildTreeRecursive(int[] postorder, int[] inorder, int l, int r) {
    if (l > r) {
      return null;
    }
    TreeNode newNode = new TreeNode(postorder[postorderIndex--]);
    if (l == r) {
      return newNode;
    }
    int newNodeInIndex = searchInOrder(inorder, newNode.data, l, r);

    //for postorder, construct right tree first when compare to pre order
    newNode.right = buildTreeRecursive(postorder, inorder, newNodeInIndex + 1, r);
    newNode.left = buildTreeRecursive(postorder, inorder, l, newNodeInIndex - 1);

    return newNode;
  }

  public int searchInOrder(int[] inorder, int item, int l, int r) {
    for (int i = l; i <= r; i++) {
      if (item == inorder[i]) {
        return i;
      }
    }
    return -1;
  }
}
