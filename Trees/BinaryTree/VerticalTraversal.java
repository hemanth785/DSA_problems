package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * 
 * Note: For Top and Bottom view of tree, vertical traversal is needed
 * For left and right view of tree, BFS traversal is enough
 */
public class VerticalTraversal {
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

    List<List<Integer>> verticalPathSimple = verticalTraversalSimple(root);
    System.out.println("----Simple vertical Traversal---");
    System.out.println(verticalPathSimple);

    List<List<Integer>> verticalPathProper = verticalTraversalProper(root);
    System.out.println("----Proper vertical Traversal---");
    System.out.println(verticalPathProper);
  }

  /*
   * SIMPLE VERTICAL TRAVERSAL
   * - Here we have not defined the the proper order if two nodes come at same coloumn and row
   */
  public static List<List<Integer>> verticalTraversalSimple(TreeNode root) {
    List<List<Integer>> verticalResult = new ArrayList<>();

    Map<Integer, List<Integer>> verticalMap = new TreeMap<>();
    recursiveTraversalSimple(root, verticalMap, 0, 0);

    for (Map.Entry entry : verticalMap.entrySet()) {
      verticalResult.add((List<Integer>) entry.getValue());
    }
    return verticalResult;
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
  
  /*
   * PROPER VERTICAL TRAVERSAL
   * we have considered the following order for row and col while printing
   * 1. print nodes coloumn wise from left to right
   * 2. inside the same coloumn, print the nodes from row top to bottom
   * 3. inside the same row and coloumn, print the nodes in sorted order
   */

   /*
    * verticalMap stucture:
    * verticalMap = TreeMap<cols>({
          TreeMap<rows>({
              ArrayList<List of items in the same cell(if exists)>
          })
    })
    */
  public static List<List<Integer>> verticalTraversalProper(TreeNode root) {
        List<List<Integer>> verticalResult = new ArrayList<>();

        //outer map is <TreeMap> because to keep the coloumn number in order - (refer point 1.)
        Map<Integer, Map<Integer, List<Integer>> > verticalMap = new TreeMap<>();
        recursiveTraversalProper(root, verticalMap, 0, 0);

        for(Map.Entry colEntry : verticalMap.entrySet()){
            Map<Integer, List<Integer>> rowEntryMap = (Map<Integer, List<Integer>>)colEntry.getValue();
            List<Integer> tempRowList = new ArrayList<>();

            for(Map.Entry rowEntry : rowEntryMap.entrySet()){
                List<Integer> cellItems = (List<Integer>) rowEntry.getValue();
                //applying sorting for point number 3.
                Collections.sort(cellItems);
                tempRowList.addAll(cellItems);
            }

            verticalResult.add(tempRowList);
        }
        return verticalResult;
    }

    public static void recursiveTraversalProper(TreeNode cur, Map<Integer, Map<Integer, List<Integer>>> verticalMap, int col, int row){
        if(cur == null){
            return;
        }

        if(!verticalMap.containsKey(col)){
           //inner map is also <TreeMap> because to keep the row number in order, inside the coloumn - (refer point 2.)
            verticalMap.put(col, new TreeMap<>());
        }
        if(!verticalMap.get(col).containsKey(row)){
            verticalMap.get(col).put(row, new ArrayList<Integer>());
        }
        verticalMap.get(col).get(row).add(cur.data);

        recursiveTraversalProper(cur.left, verticalMap, col-1, row+1); //here col indexes will be negative
        recursiveTraversalProper(cur.right, verticalMap, col+1, row+1);
    }
}
