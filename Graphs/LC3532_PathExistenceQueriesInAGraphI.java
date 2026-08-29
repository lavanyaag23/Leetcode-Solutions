/*
 * LeetCode Problem #3532 - Path Existence Queries in a Graph I
 *
 * Difficulty: Medium
 * Topic: Graphs
 *
 * Problem Link:
 * https://leetcode.com/problems/path-existence-queries-in-a-graph-i/
 *
 * Approach:
 * The graph is constructed using adjacent nodes whose values differ
 * by at most the given limit.
 *
 * We can determine connected components by traversing the nodes
 * from left to right. If the difference between consecutive values
 * is greater than the limit, a new component starts.
 *
 * For each query, a path exists if both nodes belong to the same
 * connected component.
 *
 * Time Complexity: O(n + q)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] component = new int[n];
        int id = 0;

        component[0] = id;

        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) > maxDiff) {
                id++;
            }

            component[i] = id;
        }

        boolean[] result = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            result[i] = component[u] == component[v];
        }

        return result;
    }
}
