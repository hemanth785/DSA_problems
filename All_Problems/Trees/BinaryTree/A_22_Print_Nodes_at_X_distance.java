package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class A_22_Print_Nodes_at_X_distance {
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

  /* --------------------- */

  /*
   * Approach: By constructing Adj list of Tree nodes
   * - Construct Adjascency list by treating given tree as Graph
   * - Then perfom BFS on adj list to find out all the nodes at distance 'k'
   */
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<Integer, List<Integer>> adjMap = getAdjascencyMapWithBFS(root);
    Set<Integer> visited = new HashSet<>();

    List<Integer> result = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(target.data);
    visited.add(target.data);

    int distance = 0;
    while (!queue.isEmpty()) {
      int n = queue.size();

      for (int i = 0; i < n; i++) {
        Integer curNode = queue.remove();

        if (distance == k) {
          result.add(curNode);
        }

        List<Integer> neighbours = adjMap.get(curNode);
        for (int neighbour : neighbours) {
          if (!visited.contains(neighbour)) {
            queue.add(neighbour);
            visited.add(neighbour);
          }
        }
      }
      if (distance == k) {
        return result;
      }
      distance++;
    }

    return result;
  }

  public Map<Integer, List<Integer>> getAdjascencyMapWithBFS(TreeNode root) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    if (root == null) {
      return adjMap;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();

      if (!adjMap.containsKey(node.data)) {
        adjMap.put(node.data, new ArrayList<>());
      }

      if (node.left != null) {
        if (!adjMap.containsKey(node.left.data)) {
          adjMap.put(node.left.data, new ArrayList<>());
        }

        adjMap.get(node.data).add(node.left.data);
        adjMap.get(node.left.data).add(node.data);

        queue.add(node.left);
      }
      if (node.right != null) {
        if (!adjMap.containsKey(node.right.data)) {
          adjMap.put(node.right.data, new ArrayList<>());
        }

        adjMap.get(node.data).add(node.right.data);
        adjMap.get(node.right.data).add(node.data);

        queue.add(node.right);
      }
    }

    return adjMap;
  }
}
