package All_Problems.Trees.BinaryTree;

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

    treeMap.forEach((col, rowEntries)->{
      //Note: For iterating row inside the cols, we are using Map.Entry instead of forEach because - forEach does not support the break; statement
      for(Map.Entry<Integer, List<Integer>> rowEntry: rowEntries.entrySet()){
        List<Integer> rowItems = (List<Integer>) rowEntry.getValue();
        topView.add(rowItems.get(rowItems.size() - 1)); //1* - get the last element from list (if muliple elements are there in the same col and row)

        break;
      }
    });

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
