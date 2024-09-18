package Graph.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Link: https://www.geeksforgeeks.org/problems/account-merge/1
 */
public class A04_AccountsMerge {
  static class DisjointSet {
    int size[];
    int parent[];

    DisjointSet(int n) {
      size = new int[n + 1];
      parent = new int[n + 1];

      for (int i = 0; i < n; i++) {
        size[i] = 1;
        parent[i] = i; // initialy all nodes parent will be itself only
      }
    }

    // This will help in finding the ultimate parent (Boss of component) of anynode,
    // Along the way it also performs 'Path compression'
    public int findUltimateParent(int node) {
      if (parent[node] == node) {
        return node;
      }

      parent[node] = findUltimateParent(parent[node]); // this line does the job of path compression
      return parent[node];
    }

    // This will add one component to another dijoint component, if both of them are
    // already not connected
    public void unionBySize(int u, int v) {
      int ulp_of_u = findUltimateParent(u);
      int ulp_of_v = findUltimateParent(v);

      if (ulp_of_u == ulp_of_v) {
        return;
      }

      if (size[ulp_of_u] <= size[ulp_of_v]) {
        parent[ulp_of_u] = ulp_of_v;
        size[ulp_of_v] += size[ulp_of_u];
      } else {
        parent[ulp_of_v] = ulp_of_u;
        size[ulp_of_u] += size[ulp_of_v];
      }
    }
  }

  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);

    // Insert all the account emails into map against account index, while also checking for connected accounts
    Map<String, Integer> emailAccountMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<String> accountEmails = accounts.get(i);

      //starting from 1, because 1st item in list is the name
      for (int j = 1; j < accountEmails.size(); j++) {
        String email = accountEmails.get(j);
        if (emailAccountMap.containsKey(email)) {
          int u = i;
          int v = emailAccountMap.get(email);
          ds.unionBySize(u, v);
        } else {
          emailAccountMap.put(email, i);
        }
      }
    }

    // Merge the emails having save account id
    List<List<String>> mergedAccounts = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      mergedAccounts.add(new ArrayList<>());
    }
    for (Map.Entry entry : emailAccountMap.entrySet()) {
      String email = entry.getKey().toString();
      int index = (int) entry.getValue();

      mergedAccounts.get(ds.findUltimateParent(index)).add(email);
    }

    // Contruct result list by combining Name and merged emails
    List<List<String>> resultAccounts = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (mergedAccounts.get(i).size() == 0) {
        continue;
      }

      List<String> tempList = new ArrayList<>();
      tempList.add(accounts.get(i).get(0));

      Collections.sort(mergedAccounts.get(i));
      tempList.addAll(mergedAccounts.get(i));

      resultAccounts.add(tempList);
    }

    return resultAccounts;
  }
}
