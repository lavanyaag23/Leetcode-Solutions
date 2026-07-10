/*
 * LeetCode Problem #3514 - Path Existence Queries in a Graph I
 *
 * Difficulty: Medium
 * Topic: Graphs, Union Find (Disjoint Set Union)
 *
 * Problem Link:
 * https://leetcode.com/problems/path-existence-queries-in-a-graph-i/
 *
 * Approach:
 * Build connected components using Disjoint Set Union (Union Find).
 * For each query, check whether the two vertices belong to the
 * same connected component.
 *
 * Time Complexity: O((n + m + q) * α(n))
 * Space Complexity: O(n)
 */

class Solution {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n; i++) {

            if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
                union(parent, i, i - 1);
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            if (find(parent, queries[i][0]) == find(parent, queries[i][1])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private int find(int[] parent, int x) {

        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    private void union(int[] parent, int x, int y) {

        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
