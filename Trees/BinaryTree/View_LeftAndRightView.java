package Trees.BinaryTree;

import java.util.*;

public class View_LeftAndRightView {
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

  /*----------- */

  // Left view
  int[] leftView(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> leftView = new ArrayList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      int leftIndex = 0;
      while (size > 0) {
        TreeNode node = queue.remove();
        if (leftIndex == 0) {
          leftView.add(node.data);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }

        size--;
        leftIndex++;
      }
    }

    int leftViewArr[] = new int[leftView.size()];
    for (int i = 0; i < leftView.size(); i++) {
      leftViewArr[i] = leftView.get(i);
    }

    return leftViewArr;
  }

  // Right view
  int[] rightView(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> rightView = new ArrayList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size > 0) {
        TreeNode node = queue.remove();
        if (size == 1) {
          rightView.add(node.data);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }

        size--;
      }
    }

    int leftViewArr[] = new int[rightView.size()];
    for (int i = 0; i < rightView.size(); i++) {
      leftViewArr[i] = rightView.get(i);
    }

    return leftViewArr;
  }
}
