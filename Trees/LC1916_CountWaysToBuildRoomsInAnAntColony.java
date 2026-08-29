/*
 * LeetCode Problem #1916 - Count Ways to Build Rooms in an Ant Colony
 *
 * Difficulty: Hard
 * Topic: Trees / Dynamic Programming
 *
 * Problem Link:
 * https://leetcode.com/problems/count-ways-to-build-rooms-in-an-ant-colony/
 *
 * Approach:
 * The rooms form a rooted tree where every room must be built after its
 * parent. Use DFS to calculate the number of ways to build each subtree.
 * For a node, combine the valid arrangements of all its child subtrees
 * using multinomial combinations.
 *
 * Precompute factorials and inverse factorials to calculate combinations
 * efficiently under modulo 10^9 + 7.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    List<Integer>[] graph;
    long[] fact;
    long[] invFact;

    public int waysToBuildRooms(int[] prevRoom) {

        int n = prevRoom.length;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph[prevRoom[i]].add(i);
        }

        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        return (int) dfs(0).ways;
    }

    private Result dfs(int node) {

        long ways = 1;
        int size = 0;

        for (int child : graph[node]) {

            Result childResult = dfs(child);

            ways = ways * childResult.ways % MOD;
            ways = ways * combination(
                    size + childResult.size,
                    childResult.size
            ) % MOD;

            size += childResult.size;
        }

        return new Result(ways, size + 1);
    }

    private long combination(int n, int r) {

        if (r < 0 || r > n) {
            return 0;
        }

        return fact[n] * invFact[r] % MOD
                * invFact[n - r] % MOD;
    }

    private long power(long base, long exponent) {

        long result = 1;

        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exponent >>= 1;
        }

        return result;
    }

    static class Result {

        long ways;
        int size;

        Result(long ways, int size) {
            this.ways = ways;
            this.size = size;
        }
    }
}
