package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructFromPostAndInorder {
  // TODO: with respect to 'ConstructFromPreAndInorder', we just need traverse the
  // postOrder array from last to start

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
  
  public static void BFS(TreeNode root){ //level order traversal custom
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

  int postorderIndex = 0;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    //process postOrder path from last. 
    postorderIndex = postorder.length - 1;
    return buildTreeRecursive(postorder, inorder, 0, postorder.length - 1);
  }

  public TreeNode buildTreeRecursive(int[] postorder, int[] inorder, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    TreeNode newNode = new TreeNode(postorder[postorderIndex--]);
    if (inStart == inEnd) {
      return newNode;
    }
    int newNodeInIndex = searchInOrder(inorder, newNode.data, inStart, inEnd);
    //for postorder, construct right tree first when compare to pre order
    newNode.right = buildTreeRecursive(postorder, inorder, newNodeInIndex + 1, inEnd);
    newNode.left = buildTreeRecursive(postorder, inorder, inStart, newNodeInIndex - 1);

    return newNode;
  }

  public int searchInOrder(int[] inorder, int key, int start, int end) {
    for (int i = start; i <= end; i++) {
      if (key == inorder[i]) {
        return i;
      }
    }
    return -1;
  }
}
