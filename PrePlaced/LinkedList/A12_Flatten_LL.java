package PrePlaced.LinkedList;

/*
 * Link: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
 */
public class A12_Flatten_LL {
  public static class Node {
    int data;
    Node next = null;
    Node bottom = null;

    Node() { }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
  }
  /* ------------ */

  Node flatten(Node root) {
    Node cur = root;

    Node flattenedList = null;
    while (cur != null) {
      flattenedList = mergeList(flattenedList, cur);
      cur = cur.next;
    }

    return flattenedList; 
    // Note: Its important to return the 'flattenedList' as result head, 
    // if we return root, it'll not work.
  }

  Node mergeList(Node root1, Node root2) {
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }

    Node mergedHead = null;

    if (root1.data < root2.data) {
      mergedHead = root1;
      root1 = root1.bottom;
    } else {
      mergedHead = root2;
      root2 = root2.bottom;
    }

    Node cur = mergedHead;
    while (root1 != null && root2 != null) {
      if (root1.data <= root2.data) {
        cur.bottom = root1;
        root1 = root1.bottom;
      } else {
        cur.bottom = root2;
        root2 = root2.bottom;
      }
      cur = cur.bottom;
    }

    if (root1 != null) {
      cur.bottom = root1;
    }
    if (root2 != null) {
      cur.bottom = root2;
    }

    return mergedHead;
  }
}
