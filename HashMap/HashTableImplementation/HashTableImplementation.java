package HashMap.HashTableImplementation;

import java.util.ArrayList;

public class HashTableImplementation {
  static class HashNode<K, V>{ //here we are mentioning K and V custom types, because we dont know what is the type of key and value we'll get
    K key;
    V val;
    HashNode<K, V> next=null;

    HashNode(K key, V val){
      this.key = key;
      this.val = val;
    }
  }

  /*
   * Appraoch:
   * - We need to use two data structures here - ArrayList and LinkedList, 
   *      Arraylist - To store the buckets
   *      LinkedList - To store the collision elements (Here collision is handled with)
   * - We need to implement the hashing function, which gives the index of bucket where the data needs to be stored
   * - At each bucket, we are storing the data in nodes (linkedList), because we might have to store multiple elements at same bucketIndex
   */

  static class Map<K, V>{
    private int numberOfBuckets, size;
    private ArrayList<HashNode<K, V>> bucketList;

    //constructor
    Map(){
      bucketList = new ArrayList<>();
      numberOfBuckets = 10;
      size = 0;

      for(int i=0; i<numberOfBuckets; i++){
        bucketList.add(null);
      }
    }

    //This is where we implemention our hash function
    private int getBucketIndex(K key){
      int index = key.hashCode() % numberOfBuckets;

      return index < 0 ? index * -1 : index;
    }

    void put(K key, V value){
      // 1. get the bucket index for this new key, using hash function
      int bucketIndex = getBucketIndex(key);
      HashNode<K, V> head = bucketList.get(bucketIndex);

      // 2. Check if this key already exists in hashTable
      HashNode<K, V> cur = head;
      while(cur != null){
        if(cur.key.equals(key)){
          cur.val = value;  // if key exists, update the value for key
          return;
        }
        cur = cur.next;
      }

      // 3. If key does not exists, create node and add it at the head of bucket index
      HashNode<K, V> newNode = new HashNode<>(key, value);
      newNode.next = head;
      bucketList.set(bucketIndex, newNode); //adding it as the head node
      size++;

      // 4. Check for the load factor, if load factor is more than threshold, we need to increase the number of buckets
      // [ Load factor = current size of map / number of buckets ]
      if((0.1 *size / numberOfBuckets) >= 0.8){
        //here we need to write the logic to increate bucket size
        System.out.println("Load factor has crossed theshold, please increase the number of buckets");
      }
    }

    V get(K key){
      //get bucket index by executing hash function
      int bucketIndex = getBucketIndex(key);
      HashNode<K, V> head = bucketList.get(bucketIndex);

      while (head != null) {
        if(head.key.equals(key)){
          return head.val;
        }
        head = head.next;
      }

      return null;
    }

    void remove(K key){
      //get bucket index by executing hash function
      int bucketIndex = getBucketIndex(key);
      HashNode<K, V> head = bucketList.get(bucketIndex);
      HashNode<K, V> prev = null;

      while(head != null){
        if(head.key.equals(key)){
          break;
        }
        prev = head;
        head = head.next;
      }

      //if key not found
      if(head == null){
        return;
      }

      //if key found at head
      if(prev == null){
        bucketList.set(bucketIndex, head.next);
      } else {
        prev.next = head.next;
      }

      size--; 
    }
  }

  public static void main(String[] args) {
    HashTableImplementation.Map<String, Integer> map = new HashTableImplementation.Map<>();
    
    map.put("Hemanth", 22);
    map.put("Ganesh", 45);
    map.put("Suresh", 34);
    map.put("Shivu", 21);

    System.out.println(map.get("Suresh"));

    map.remove("Suresh");

    System.out.println(map.get("Suresh"));
  }
}
