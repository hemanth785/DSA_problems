package PrePlaced.BinarySearchTree;

/*
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class A02_Construct_BST_from_Sorted_array {
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

  /* --------------------- */

  /*
   * Approach: There can be multiple ways we can construct tree, once approach we can use is
   * Using the mid item in array to construct the root node
   * - First find the middle element in array and make it as root node,
   * - then call recursive function for left subtree, with only left items of array to middle element
   * - then call recursive function for right tree, with only right items of array to middle element
   * - at any point l == r, return the lth item as node
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    return constructTree(nums, 0, nums.length - 1);
  }

  public TreeNode constructTree(int[] nums, int l, int r) {
    TreeNode root = null;
    if (l == r) {
      root = new TreeNode(nums[l]);
      return root;
    }

    if (l > r) {
      return null;
    }

    int mid = (l + r) / 2;
    root = new TreeNode(nums[mid]);

    root.left = constructTree(nums, l, mid - 1);
    root.right = constructTree(nums, mid + 1, r);

    return root;
  }
}
