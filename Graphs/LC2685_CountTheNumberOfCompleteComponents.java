/*
 * LeetCode Problem #2685 - Count the Number of Complete Components
 *
 * Difficulty: Medium
 * Topic: Graphs, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/count-the-number-of-complete-components/
 *
 * Approach:
 * Build an adjacency list for the graph.
 * Use Depth-First Search (DFS) to find each connected component.
 * For every component, count:
 * - Number of vertices
 * - Sum of degrees
 *
 * A component is complete if every vertex is connected to
 * all other vertices in the component.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int[] component = dfs(i, graph, visited);

                int vertices = component[0];
                int degreeSum = component[1];

                if (degreeSum == vertices * (vertices - 1)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private int[] dfs(int node, List<Integer>[] graph, boolean[] visited) {

        visited[node] = true;

        int vertices = 1;
        int degreeSum = graph[node].size();

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {

                int[] result = dfs(neighbor, graph, visited);

                vertices += result[0];
                degreeSum += result[1];
            }
        }

        return new int[]{vertices, degreeSum};
    }
}
