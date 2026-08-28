/*
 * LeetCode Problem #1140 - Stone Game II
 *
 * Difficulty: Medium
 * Topic: Dynamic Programming, Game Theory, Prefix Sum
 *
 * Problem Link:
 * https://leetcode.com/problems/stone-game-ii/
 *
 * Approach:
 * Use dynamic programming with memoization.
 *
 * At each turn, a player can take between 1 and 2 * M piles.
 * The value of M changes based on the number of piles taken.
 *
 * Use suffix sums to quickly calculate the total number of stones
 * remaining from any position.
 *
 * dp[i][m] represents the maximum number of stones the current
 * player can obtain starting from index i with the current limit m.
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 */

class Solution {

    private int[][] dp;
    private int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    private int solve(int index, int m) {

        if (index >= suffix.length - 1) {
            return 0;
        }

        if (dp[index][m] != 0) {
            return dp[index][m];
        }

        int maxStones = 0;

        for (int x = 1; x <= 2 * m && index + x <= suffix.length - 1; x++) {

            int opponent = solve(index + x, Math.max(m, x));

            maxStones = Math.max(
                maxStones,
                suffix[index] - opponent
            );
        }

        return dp[index][m] = maxStones;
    }
}
