
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

  //2. Using the hashmap. time- O(n log(n)), space- O(1)
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
