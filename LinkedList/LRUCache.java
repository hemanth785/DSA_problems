package LinkedList;

import java.util.HashMap;

public class LRUCache {
  static class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node() {
    }

    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  int capacity;
  int size = 0;
  Node head;
  Node tail;
  HashMap<Integer, Node> cashMap = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (cashMap.get(key) != null) {
      Node node = cashMap.get(key);
      if (node != head) {
        moveToHead(node);
      }
      return head.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (cashMap.get(key) == null) {
      if (cashMap.size() == capacity) {
        // remove tail
        cashMap.remove(tail.key);

        // this case occurs when cache size is 1
        if (head == tail) {
          head = null;
          tail = null;
        } else {
          Node temp = tail.prev;
          tail.prev = null;
          temp.next = null;
          tail = temp;
        }

      }
      Node node = new Node(key, value);
      cashMap.put(key, node);
      addTohead(node);

    } else {
      // update existing node value
      Node node = cashMap.get(key);
      node.val = value;

      moveToHead(node);
    }
  }

  public void moveToHead(Node current) {
    if (current == head) {
      return;
    }
    if (current == tail) {
      tail = tail.prev;
      tail.next = null;
    } else {
      current.prev.next = current.next;
      current.next.prev = current.prev;
    }
    addTohead(current);
  }

  public void addTohead(Node node) {
    if (head != null) {
      node.next = head;
      head.prev = node;
      head = node;
    } else {
      head = node;
      tail = node;
    }
  }
}
