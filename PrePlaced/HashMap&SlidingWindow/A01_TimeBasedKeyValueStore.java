

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Link: https://leetcode.com/problems/time-based-key-value-store
 */
public class A01_TimeBasedKeyValueStore {

  class TimeMap {

    /*
     * Approach: Using HashMap and TreeMap
     * - Use HashMap on higher level to store values againt particular key
     * - For each key, Use Tree map to store all the values of key against each timestamp
     * - We are using TreeMap here because, treeMap sorts the records based on keys (in our case its timestamp) 
     *    and that'll be usefull when fetching records for particular timestamp or the latest timestamp
     */
    Map<String, TreeMap<Integer, String>> timeMap = new HashMap<>();

    public TimeMap() {
      timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      if (!timeMap.containsKey(key)) {
        timeMap.put(key, new TreeMap<>(Collections.reverseOrder()));
      }
      TreeMap<Integer, String> values = timeMap.get(key);
      values.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
      TreeMap<Integer, String> values = timeMap.get(key);
      if (values == null) {
        return "";
      }

      for (Map.Entry entry : values.entrySet()) {
        int timestampKey = (int) entry.getKey();
        if (timestamp >= timestampKey) {
          return entry.getValue().toString();
        }
      }
      return "";
    }
  }
}
