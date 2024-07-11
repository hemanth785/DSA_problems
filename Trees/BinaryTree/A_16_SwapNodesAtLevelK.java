package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/*
 * link: https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/swap-nodes-algo/
 */
public class A_16_SwapNodesAtLevelK {
  /*
   * Approach: 
   * - We know that root level of tree is always 1
   * - First build the tree from the given node indexes, using the level order traversal
   * - Then for each k value, swap the nodes at all level = 2*k, and store the inorder traversal
   * - Then return all the inOrder traversals
   */

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

  public static void inOrder(TreeNode cur, List<Integer> path) {
    if (cur == null) {
      return;
    }

    inOrder(cur.left, path);
    path.add(cur.data);
    inOrder(cur.right, path);
  }

  public static void swapLevelOrder(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int level = 1;
    while (!queue.isEmpty()) {
      int length = queue.size();

      while (length > 0) {
        // add left and right nodes to queue
        TreeNode cur = queue.remove();
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }

        // swap nodes
        if (level % k == 0) {
          TreeNode temp = cur.left;
          cur.left = cur.right;
          cur.right = temp;
        }

        length--;
      }
      level++;
    }
  }

  public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {

    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    // create root node
    TreeNode root = new TreeNode(1);
    queue.add(root);

    // create a tree from indexes
    for (List<Integer> nodes : indexes) {
      Integer leftIndex = nodes.get(0);
      Integer rightIndex = nodes.get(1);

      TreeNode cur = queue.remove();
      if (leftIndex != -1) {
        cur.left = new TreeNode(leftIndex);
        queue.add(cur.left);
      }
      if (rightIndex != -1) {
        cur.right = new TreeNode(rightIndex);
        queue.add(cur.right);
      }
    }

    for (Integer k : queries) {
      // swap nodes at every kth level
      swapLevelOrder(root, k);

      // add the inorder traversal patht to result
      List<Integer> inorderPath = new ArrayList<>();
      inOrder(root, inorderPath);
      res.add(inorderPath);
    }

    return res;
  }
}
