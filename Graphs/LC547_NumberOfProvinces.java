/*
 * LeetCode Problem #547 - Number of Provinces
 *
 * Difficulty: Medium
 * Topic: Graphs, DFS, Connected Components
 *
 * Problem Link:
 * https://leetcode.com/problems/number-of-provinces/
 *
 * Approach:
 * Treat the cities as vertices of an undirected graph.
 * Use DFS to visit every city connected to the current city.
 * Each time an unvisited city is found, start a new DFS traversal
 * and increment the province count.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int city, int[][] isConnected, boolean[] visited) {

        visited[city] = true;

        for (int next = 0; next < isConnected.length; next++) {

            if (isConnected[city][next] == 1 && !visited[next]) {
                dfs(next, isConnected, visited);
            }
        }
    }
}
