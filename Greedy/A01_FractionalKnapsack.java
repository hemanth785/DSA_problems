package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Link: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 * 
 */
public class A01_FractionalKnapsack {
  class Item {
    int value, weight;

    Item(int x, int y) {
      this.value = x;
      this.weight = y;
    }
  }

  /*
   * Solution: 
   * Since in this problem, we can pick the fraction of item, 
   * so we dont have to worry about whether the item fits in the bag
   * 
   * - So our approach would be here is that, first pick the max available item which has greater value/weight
   * 
   * - To achieve this, we can sort the item list based on the value/weight ratio and then start filling.
   * 
   * - at the end if some small space left, fill it with fraction of the next valuable item.
   * 
   * Time: n * log(n), space: O(n)
   */
  double fractionalKnapsack(int W, Item arr[], int n) {
    List<Item> itemList = new ArrayList<>(Arrays.asList(arr));
    Collections.sort(itemList, (a, b) -> {
      if ((b.value * 0.1 / b.weight) > (a.value * 0.1 / a.weight)) {
        return 1;
      } else if ((b.value * 0.1 / b.weight) < (a.value * 0.1 / a.weight)) {
        return -1;
      } else {
        return 0;
      }
    });

    double maxValue = 0;

    for (Item item : itemList) {
      int weight = item.weight;
      int value = item.value;
      if (weight <= W) {
        maxValue = maxValue + value;
        W = W - weight;
      } else {
        double valuePerWeight = (double) value / weight;
        maxValue = (maxValue + (valuePerWeight * W));
        break;
      }
    }

    return maxValue;
  }
}
