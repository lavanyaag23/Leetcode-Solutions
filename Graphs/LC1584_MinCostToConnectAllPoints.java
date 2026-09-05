/*
 * LeetCode Problem #1584 - Min Cost to Connect All Points
 *
 * Difficulty: Medium
 * Topic: Graphs, Minimum Spanning Tree, Prim's Algorithm
 *
 * Problem Link:
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 * Approach:
 * Treat every point as a node in a complete graph.
 * The cost of connecting two points is their Manhattan distance.
 * Use Prim's Algorithm to construct the Minimum Spanning Tree.
 * At every step, select the unvisited point with the minimum
 * connection cost and update the costs of the remaining points.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int[] minCost = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }

        minCost[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            int current = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                    (current == -1 || minCost[i] < minCost[current])) {
                    current = i;
                }
            }

            visited[current] = true;
            totalCost += minCost[current];

            for (int i = 0; i < n; i++) {

                if (!visited[i]) {

                    int distance =
                            Math.abs(points[current][0] - points[i][0])
                            + Math.abs(points[current][1] - points[i][1]);

                    minCost[i] = Math.min(minCost[i], distance);
                }
            }
        }

        return totalCost;
    }
}
