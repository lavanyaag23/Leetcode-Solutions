/*
 * LeetCode Problem #3515 - Path Existence Queries in a Graph II
 *
 * Difficulty: Medium
 * Topic: Graphs, Union Find (Disjoint Set Union)
 *
 * Problem Link:
 * https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/
 *
 * Approach:
 * Build connected components using Disjoint Set Union (Union Find).
 * Merge adjacent vertices whose value difference does not exceed
 * maxDiff. For each query, check whether both vertices belong
 * to the same connected component.
 *
 * Time Complexity: O((n + q) * α(n))
 * Space Complexity: O(n)
 */

class Solution {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n; i++) {

            if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
                union(parent, rank, i, i - 1);
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

    private void union(int[] parent, int[] rank, int x, int y) {

        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {

            parent[rootX] = rootY;

        } else if (rank[rootX] > rank[rootY]) {

            parent[rootY] = rootX;

        } else {

            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
