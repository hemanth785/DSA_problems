public class A07_Search_in_infinite_long_sorted_array {
  public static void main(String[] args) {
    int infiniteArr[] = new int[1000];

    int number = 2;
    for(int i=0; i<1000; i++){
      infiniteArr[i] = number;
      number += 2;
    }

    //input Array with size 1000 has elements [2 ,4, 5, .... 2000]

    //Search in infinite long array
    int index = searchInInfiniteSortedArray(infiniteArr, 510);
    if(index == -1){
      System.out.println("Item not found"); 
    } else {
      System.out.println("Item found at index: "+index); 
    }
  }

  /*
   * Approach: 
   * - In an infinite long array, we dont know where to keep right pointer
   * - To tackle this issue, we can use one trick
   * - initialize left as 0, and right as 1
   * - Keep doubling the right pointer value at each stage, until we know that item to be searched on the left side of right pointer
   * - then perform the binary search between left and right pointer
   */
  public static int searchInInfiniteSortedArray(int arr[], int item){
    int low = 0;
    int high = 1;

    while(arr[high] < item){
      System.out.println(high+" - "+arr[high]);
      low = high;
      high = high * 2;

      //This is extra code to avoid array index out of bound situation
      if(high > arr.length){
        high = arr.length-1;
        break;
      }
    }

    while(low <= high){
      int mid = (low+high)/2;
      if(arr[mid] == item){
        return mid;
      } else if(arr[mid] < item){
        low = mid+1;
      } else {
        high = mid-1;
      }
    }

    return -1;
  }
}
