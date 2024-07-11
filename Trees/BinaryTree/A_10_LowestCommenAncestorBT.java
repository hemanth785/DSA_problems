package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
/*
 * Solution 1: Not recommonded
 *  TODO:  This is for binary tree (not bst)
 *   do the recursive traversal for node p and q and store the path on the way(path1 and path2)
 *   After the complete traversal, simultanously keep removing last element from path1 and path2 and compare at any point both have same node
 *   if same node found at any index, that is the LCA
 *
 *   refer 'PathToTarget' for keep track of path
 */


public class A_10_LowestCommenAncestorBT {
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

  /*Tree
  *                   1
  *                 /   \  
  *                2     5
  *               / \   / \
  *              4   6 3   7
  *                   / \
  *                  9  12
  */
  public static TreeNode build(){
    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(6);

    root.right = new TreeNode(5);

    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(7);

    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(12);

    return root;
  }

  public static void main(String[] args) {
    TreeNode root = build();
    BFS(root);

    TreeNode lca = lowestCommonAncestor(root, 9 ,12);
    System.out.println("LCA: ");
    System.out.println(lca.data);
  }

  /*
  * Solution 2: 
  * 1. Start DFS traversal from root
  * 2. if any point curNode data equals either p or q, then return the current node
  *     - because commen ancestor cannot be down below the current node
  * 3. else call recurse for left and right node
  * 4. if both p and q found in left and right node, then curNode is the LCA
  * 5. else pass the result which is not empty, So that LCA will be calculated at parent node
  */

  public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    return findLCA(root, p, q);
  }

  public static TreeNode findLCA(TreeNode cur, int p, int q) {
    if (cur == null) {
      return null;
    }
    if (cur.data == p || cur.data == q) {
      return cur;
    }

    TreeNode left = findLCA(cur.left, p, q);
    TreeNode right = findLCA(cur.right, p, q);

    // this one is checking - for current node does both p and q found
    if (left != null && right != null) {
      return cur;
      // these 2 below one is for passing the found ancestor upwards till root (passing ans to top)
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    return null;
  }
}
