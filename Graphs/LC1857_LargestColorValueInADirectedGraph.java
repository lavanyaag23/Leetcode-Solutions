/*
 * LeetCode Problem #1857 - Largest Color Value in a Directed Graph
 *
 * Difficulty: Hard
 * Topic: Graphs, Topological Sort, Dynamic Programming
 *
 * Problem Link:
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 *
 * Approach:
 * Use Kahn's algorithm for topological sorting.
 * For every node, maintain the maximum count of each color along any
 * path ending at that node. Propagate these counts to neighboring nodes.
 * If all nodes are not processed, the graph contains a cycle and -1 is returned.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n * 26)
 */

import java.util.*;

class Solution {

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] count = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            processed++;

            int color = colors.charAt(node) - 'a';
            count[node][color]++;

            answer = Math.max(answer, count[node][color]);

            for (int neighbor : graph.get(node)) {

                for (int c = 0; c < 26; c++) {
                    count[neighbor][c] =
                            Math.max(count[neighbor][c], count[node][c]);
                }

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processed == n ? answer : -1;
    }
}
