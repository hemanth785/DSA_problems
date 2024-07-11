package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class A_21_View_BottomView {
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
   * Bottome view is same as top view, with just 2 changes(*), commented in code
   */
  static List<Integer> topView;
  static Map<Integer, TreeMap<Integer, List<Integer>>> treeMap;

  int[] bottomView(TreeNode root) {
    topView = new ArrayList<>();
    treeMap = new TreeMap<>();

    getTopViewDFS(root, 0, 0);

    for (Map.Entry colEntry : treeMap.entrySet()) {
      Map<Integer, List<Integer>> col = (Map<Integer, List<Integer>>) colEntry.getValue();
      for (Map.Entry rowEntry : col.entrySet()) {
        List<Integer> row = (List<Integer>) rowEntry.getValue();
        //1* - get the last element from list (if muliple elements are there in the same col and row)
        topView.add(row.get(row.size() - 1));
        break;
      }
    }

    int topViewArr[] = new int[topView.size()];
    for (int i = 0; i < topView.size(); i++) {
      topViewArr[i] = topView.get(i);
    }

    return topViewArr;
  }

  static void getTopViewDFS(TreeNode root, int col, int row) {
    if (!treeMap.containsKey(col)) {
      // 2* - Make the row map sorting in reverse order (Descending)
      treeMap.put(col, new TreeMap<>(Collections.reverseOrder()));
    }
    if (!treeMap.get(col).containsKey(row)) {
      treeMap.get(col).put(row, new ArrayList<>());
    }

    treeMap.get(col).get(row).add(root.data);

    if (root.left != null) {
      getTopViewDFS(root.left, col - 1, row + 1);
    }
    if (root.right != null) {
      getTopViewDFS(root.right, col + 1, row + 1);
    }
  }
}
