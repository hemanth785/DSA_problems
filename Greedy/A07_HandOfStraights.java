package Greedy;

import java.util.Map;
import java.util.TreeMap;

/*
 * Link: https://leetcode.com/problems/hand-of-straights/description/
 */
public class A07_HandOfStraights {
  /*
   * Approach: Using HashMap and sorting
   * - Base condition, check if total number of cards % groupsize == 0, if not return 0 
   * - First store the count of each card in Map (Tree map- becuase we need to access the card in ascending order)
   * - Then until all cards in treeMap becomes empty, run a loop
   *    - where fetch smallest card from map, while decremeneting its count
   *    - Then fetch next card with value = prevCard+1, until we form the group of given size
   *    - at any point, while fetching next card for group, if we dont find it in the map - that means we cannot form groups - so return false
   *  
   * - Or at the end of function return true
   */
  public boolean isNStraightHand(int[] hand, int groupSize) {
    int n = hand.length;
    if (n % groupSize != 0) {
      return false;
    }
    TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

    // Insert all the cards and their count in tree map
    for (int card : hand) {
      sortedMap.put(card, sortedMap.getOrDefault(card, 0) + 1);
    }

    while (!sortedMap.isEmpty()) {
      Map.Entry firstCardInGroup = sortedMap.firstEntry();
      int card = (int) firstCardInGroup.getKey();
      int count = (int) firstCardInGroup.getValue();
      if (count == 1) {
        sortedMap.remove(card);
      } else {
        sortedMap.put(card, count - 1);
      }

      int nextCardNeeded = card + 1;
      for (int i = 1; i < groupSize; i++) {
        if (!sortedMap.containsKey(nextCardNeeded)) {
          return false;
        } else {
          card = nextCardNeeded;
          count = sortedMap.get(nextCardNeeded);

          if (count == 1) {
            sortedMap.remove(card);
          } else {
            sortedMap.put(card, count - 1);
          }
          nextCardNeeded = card + 1;
        }
      }
    }

    return true;
  }
}
