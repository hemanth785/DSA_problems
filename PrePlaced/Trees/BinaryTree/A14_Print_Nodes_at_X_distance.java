package PrePlaced.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class A14_Print_Nodes_at_X_distance {
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
   * Approach - 1: By constructing Adj list of Tree nodes
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

  /*
   * Apprach 2: Add parent pointer to each node in tree
   * Note: We know that in tree we can only traverse top to bottom, 
   *      so we can add the parent pointer to each node, to get capability of traversing bottom to top as well
   *      - We can use HashMap for storing the parent pointer.
   * 
   * - step 1: Do DFS or BFS traversal to assign parent pointer to each node
   * - step 2: Then Do BFS traversal starting from target node, in all 3 directions - left, right and parent
   * - step 3: when we reach nodes at a distance of k from target nodes, add it to result list
   * 
   */
  public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    findParentWithDFS(root, null, parentMap);

    List<Integer> res = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    queue.add(target);
    set.add(target.data);

    int distance = 0;
    while (!queue.isEmpty()) {
      int n = queue.size();

      for (int i = 0; i < n; i++) {
        TreeNode curNode = queue.remove();

        if (distance == k) {
          res.add(curNode.data);
        }

        // check left node
        if (curNode.left != null && !set.contains(curNode.left.data)) {
          queue.add(curNode.left);
          set.add(curNode.left.data);
        }

        // check right node
        if (curNode.right != null && !set.contains(curNode.right.data)) {
          queue.add(curNode.right);
          set.add(curNode.right.data);
        }

        // check parent node
        TreeNode parentNode = parentMap.get(curNode);
        if (parentNode != null && !set.contains(parentNode.data)) {
          queue.add(parentNode);
          set.add(parentNode.data);
        }
      }

      if (distance == k) {
        return res;
      }
      distance++;
    }
    return res;
  }

  public void findParentWithDFS(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
    if (root == null) {
      return;
    }

    parentMap.put(root, parent);

    findParentWithDFS(root.left, root, parentMap);
    findParentWithDFS(root.right, root, parentMap);
  }
}
