package Trees.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
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

  public static void BFS(TreeNode root) { // level order traversal
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    System.out.print("level-order traversal: ");
    while (!queue.isEmpty()) {
      TreeNode cur = queue.remove();

      System.out.print(cur.data + ", ");
      if (cur.left != null) {
        queue.add(cur.left);
      }
      if (cur.right != null) {
        queue.add(cur.right);
      }
    }
    System.out.println();
  }

  public static TreeNode buildTreeFromArray(int[] arr) {
    TreeNode root = null;
    for (int i = 0; i < arr.length; i++) {
      if (root == null) {
        root = insertNode(root, arr[i]);
      } else {
        insertNode(root, arr[i]);
      }

    }
    return root;
  }

  public static TreeNode insertNode(TreeNode root, int data) {
    TreeNode curr = root;

    if (curr == null) {
      return new TreeNode(data);
    }

    while (curr != null) {
      if (data < curr.data) {

        if (curr.left == null) {
          curr.left = new TreeNode(data);
          return root;
        }
        curr = curr.left;
      } else {

        if (curr.right == null) {
          curr.right = new TreeNode(data);
          return root;
        }
        curr = curr.right;
      }
    }

    return root;
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 10, 4, 8, 6, 7, 1, 3, 15, 12, 18, 11, 16, 17, 19 };
    TreeNode root = buildTreeFromArray(arr);

    BFS(root);
    // root = deleteNodeIterative(root, 10);
    root = deleteNodeRecursive(root, 10);
    BFS(root);
  }

  // Iterative function - takes time to write
  public static TreeNode deleteNodeIterative(TreeNode root, int key) {
    if (root == null) {
      return root;
    }
    String lastPath = "";

    TreeNode curr = root;
    TreeNode parent = null;
    while (curr != null) {
      if (key < curr.data) {
        lastPath = "left";
        parent = curr;
        curr = curr.left;

      } else if (key > curr.data) {
        lastPath = "right";
        parent = curr;
        curr = curr.right;

      } else {
        // case 1: if no childs for curr, just remove
        if (curr.left == null && curr.right == null) {
          if (parent == null) { // for deleting root node
            return null;
          }
          if (lastPath == "left") {
            parent.left = null;
          } else {
            parent.right = null;
          }

          // case 2: if 1 child exists, swap with child and remove child
        } else if (curr.right == null) {
          if (parent == null) { // for deleting root node
            return root.left;
          }
          if (lastPath == "left") {
            parent.left = curr.left;
          } else {
            parent.right = curr.left;
          }

        } else if (curr.left == null) {
          if (parent == null) { // for deleting root node
            return root.right;
          }
          ;
          if (lastPath == "left") {
            parent.left = curr.right;
          } else {
            parent.right = curr.right;
          }

        } else {
          // case 3: if 2 childs: find inorder successer -> swap -> remove successor
          /*
           * Steps to find inorder successor (node value to replace the current node),
           * - navigate to immidiate right node,
           * - keep moving to left node, until current.left becomes null.
           * Now current node will be the successor node
           */
          TreeNode successor = curr.right, successorParent = curr;
          while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
          }

          if (successorParent == curr) { // if there is no left node, to the right node of key node
            curr.right = successor.right;
          } else {
            successorParent.left = successor.right;
          }
          curr.data = successor.data;
        }
      }
    }
    return root;
  }



  
  /* Recursive: SIMPLE SOLUTION */
  public static TreeNode deleteNodeRecursive(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (key < root.data) {
      root.left = deleteNodeRecursive(root.left, key);
    } else if (key > root.data) {
      root.right = deleteNodeRecursive(root.right, key);
    } else {
      // case 1: if left and right nodes are null, just remove current node
      if (root.left == null && root.right == null) {
        return null;
      }

      // case 2: If any one child is null, return the other node
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }

      // case 3: If Both child nodes exists
      // 1. move to the leftMost node(curNode) in rightSubTree of node to be deleted(key)
      // 2. Assign the 'left tree' of 'keynode' to the 'curNode'(leftMost right subtree node)
      // 3. Return the right node of the 'keynode'
      TreeNode leftMostRightNode = root.right;

      while (leftMostRightNode.left != null) {
        leftMostRightNode = leftMostRightNode.left;
      }

      leftMostRightNode.left = root.left;
      return root.right;

    }

    return root;
  }
}
