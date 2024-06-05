
/*
Find the majority element, element which repeats for more than n/2 times (Where n is the size of array) in an array

input: [5,2,8,6,8,8,4,8,8]

This is same as finding majority in elections

*/
import java.util.*;

class Find_majority_element {
  public static void main(String[] args) {
    int arr[] = {5,2,8,6,8,8,4,8,8};
    // int res = findMajorityItem1(arr, arr.length);
    // int res = findMajorityItem2(arr, arr.length);
    int res = findMajorityItem3(arr, arr.length);
    System.out.println("Majority number: "+res);
  }

  //2. Use sorting. time: O(n log(n)), space: O(1)
  public static int findMajorityItem1(int arr[], int n){
    Arrays.sort(arr);  //time: n log(n)

    int maxCount = 0;
    int majorityitem = arr[0];

    int currentMax = 1;
    for(int i=1; i<n; i++){
      if(arr[i] == arr[i-1]){
        currentMax++;
      } else {
        if(currentMax > maxCount){
          maxCount = currentMax;
          majorityitem = arr[i-1];
        }
        currentMax = 1;
      }
    }
    if(currentMax > maxCount){
      maxCount = currentMax;
      majorityitem = arr[n-1];
    }

    //checking if highest repeating number has majority count
    if(maxCount > n/2){
      return majorityitem;
    } else {
      return -1;
    }
  }
  

  //2. Using the hashmap. time- O(n), space- O(n)
  public static int findMajorityItem2(int arr[], int n){
    //creating the map of count of each element
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int item: arr){
      if(map.get(item) != null){
        map.put(item, map.get(item)+1);
      } else {
        map.put(item, 1);
      }
    }

    //find the max count
    int maxCount = 0;
    int majorityNumber = 0;
    for(Map.Entry mapItem: map.entrySet()){
      int count = (int)mapItem.getValue();
      if(count > maxCount){
        maxCount = count;
        majorityNumber = (int)mapItem.getKey();
      }
    }

    return majorityNumber;
  }

  //3. Without using hashmap, time- O(n), space- O(1)
  //NOTE: this will not work for finding max repeating array element
  /*
   * Solution: We know that, majority element is the one which has more count than half of entire elements
   * That means, if we start counting majority element (and decreasing it againt any other element found), its count should survive till the end of array
   * 
   * 1. assume 1st element is the majority element, and initialize count as zero
   * 2. check for next element, if it is same as current majorit element, increase count or, decrease count
   *    - Now if count becomes zero, update the majority element as current array element
   * 3. Now after traversing all the elements, value of majority might be the majority element
   * 4. To confirm that, this is the majority element. count the majority element in the array
   * 5. if count is >n/2, this is the majority element. otherwise majority element not present in array
   */
  public static int findMajorityItem3(int arr[], int n){
    int count = 1;
    int majority = arr[0];
    //finding the probabale majoirity item
    for(int i=1; i<n; i++){
      if(majority == arr[i]){
        count++;
      } else {
        count--;
      }

      if(count == 0){
        majority = arr[i];
        count = 1;
      }
    }

    System.out.println("majority: "+majority);;

    // confirm if the item has majority count, i.e cound > n/2
    int tempCount = 0;
    for(int item: arr){
      if(item == majority){
        tempCount++;

        if(tempCount > n/2){
          return majority;
        }
      }
    }

    return -1;
  }
}
