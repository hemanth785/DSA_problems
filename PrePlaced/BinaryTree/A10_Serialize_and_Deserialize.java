package PrePlaced.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A10_Serialize_and_Deserialize {
  public static class TreeNode {
    int data;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode() {
    }

    TreeNode(int data) {
      this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /*
   * Approach 1:
   * - We can serialize using (Inorder and Preorder) or (Inorder and Post order)
   * - Restore tree using the any one of the above methos
   * 
   * Note: This uses twice the extra space as size of tree
   */

  /*
   * Approach 2: Using Preorder traversal (Queue) with filling empty nodes as -1
   * - Create preorder path with -1 for the empty nodes
   * - traverse DFS with preoder to construct tree
   */
  public String serialize(TreeNode root) {
    if (root == null) {
      return -1 + "";
    }
    String leftString = serialize(root.left);
    String rightString = serialize(root.right);

    return root.data + "," + leftString + "," + rightString; // this is where preorder is applied
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> preOrderQ = new LinkedList<>();
    preOrderQ.addAll(Arrays.asList(data.split(","))); // remember this

    return contructBSTFromPre(preOrderQ);
  }

  TreeNode contructBSTFromPre(Queue<String> preOrderQ) {
    if (preOrderQ.size() == 0) {
      return null;
    }

    String curVal = preOrderQ.poll();

    if (curVal.equals("-1")) {
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(curVal));

    root.left = contructBSTFromPre(preOrderQ);
    root.right = contructBSTFromPre(preOrderQ);

    return root;
  }
}
