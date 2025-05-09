package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.HashMap;

public class PrintViews {
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
  public static TreeNode build() {
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

    //print topView
    topView(root);
  }

  public static void leftView(TreeNode root) {
    // TODO: tip: print first node in level order traversal
    // Output: 1,2,4,9
  }

  public static void rightView(TreeNode root) {
    // TODO: tip: print last node in level order traversal
    // Output: 1,5,7,12
  }

  // TODO: tip: print first node in vertical order traversal------
  public static void topView(TreeNode root) {
    // Output: 4,2,1,5,7
    Map<Integer, List<Integer>> verticalMap = new TreeMap<>();
    recursiveTraversalSimple(root, verticalMap, 0, 0);
    for (Map.Entry entry : verticalMap.entrySet()) {
      List<Integer> row = (List<Integer>) entry.getValue();
      // int value = entry.getValue().get(0);
      System.out.print(row.get(0) + " ");
    }
  }

  public static void recursiveTraversalSimple(TreeNode cur, Map<Integer, List<Integer>> verticalMap, int col, int row) {
    if (cur == null) {
      return;
    }

    if (!verticalMap.containsKey(col)) {
      verticalMap.put(col, new ArrayList<Integer>());
    }
    verticalMap.get(col).add(cur.data);

    recursiveTraversalSimple(cur.left, verticalMap, col - 1, row + 1);
    recursiveTraversalSimple(cur.right, verticalMap, col + 1, row + 1);
  }

  //--------------

  public static void bottomView(TreeNode root) {
    // TODO: tip: print first node in vertical order traversal
    // Output: 4,9,6,3,12,7
  }

}
