/*
 * LeetCode Problem #2316 - Count Unreachable Pairs of Nodes in an Undirected Graph
 *
 * Difficulty: Medium
 * Topic: Graphs, DFS, Connected Components
 *
 * Problem Link:
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 *
 * Approach:
 * Find the size of every connected component using DFS.
 * For each component, every node in it forms an unreachable pair with
 * every node belonging to the remaining components.
 * Add componentSize * remainingNodes to the answer.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        long remaining = n;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                long componentSize = dfs(i, graph, visited);

                remaining -= componentSize;
                answer += componentSize * remaining;
            }
        }

        return answer;
    }

    private long dfs(int node, List<List<Integer>> graph, boolean[] visited) {

        visited[node] = true;
        long size = 1;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                size += dfs(neighbor, graph, visited);
            }
        }

        return size;
    }
}
