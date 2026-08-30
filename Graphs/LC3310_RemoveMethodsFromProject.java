/*
 * LeetCode Problem #3310 - Remove Methods From Project
 *
 * Difficulty: Medium
 * Topic: Graphs
 *
 * Problem Link:
 * https://leetcode.com/problems/remove-methods-from-project/
 *
 * Approach:
 * Start from method k and find all methods that are suspicious
 * because they are reachable from k through invocations.
 *
 * If any suspicious method is invoked by a non-suspicious method,
 * the suspicious methods cannot be safely removed, so return all methods.
 *
 * Otherwise, remove all suspicious methods and return the remaining methods.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        boolean[] suspicious = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        suspicious[k] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        // If a non-suspicious method invokes a suspicious method,
        // the suspicious methods cannot be removed.
        for (int[] edge : invocations) {
            int from = edge[0];
            int to = edge[1];
            
            if (!suspicious[from] && suspicious[to]) {
                List<Integer> result = new ArrayList<>();
                
                for (int i = 0; i < n; i++) {
                    result.add(i);
                }
                
                return result;
            }
        }
        
        // Remove all suspicious methods.
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}
