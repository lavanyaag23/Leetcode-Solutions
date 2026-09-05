/*
 * LeetCode Problem #787 - Cheapest Flights Within K Stops
 *
 * Difficulty: Medium
 * Topic: Graphs, Bellman-Ford, Dynamic Programming
 *
 * Problem Link:
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * Approach:
 * Use a Bellman-Ford style relaxation for at most k + 1 edges.
 *
 * For each iteration, update the minimum cost to reach every city
 * using one additional flight. A temporary array is used so that
 * flights from the current iteration are not reused.
 *
 * After k + 1 iterations, return the minimum cost to reach the
 * destination. If it is still unreachable, return -1.
 *
 * Time Complexity: O(k * n + k * flights)
 * Space Complexity: O(n)
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        cost[src] = 0;

        for (int stops = 0; stops <= k; stops++) {

            int[] temp = cost.clone();

            for (int[] flight : flights) {

                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (cost[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(
                        temp[to],
                        cost[from] + price
                    );
                }
            }

            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
