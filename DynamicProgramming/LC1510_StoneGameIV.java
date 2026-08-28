/*
 * LeetCode Problem #1510 - Stone Game IV
 *
 * Difficulty: Hard
 * Topic: Dynamic Programming, Game Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/stone-game-iv/
 *
 * Approach:
 * Use Dynamic Programming to determine whether the current player
 * can force a win for each number of remaining stones.
 *
 * dp[i] is true if the current player can win with i stones.
 *
 * For every i, try removing every possible perfect square.
 * If there is a square j*j such that dp[i - j*j] is false,
 * then the current player can make a winning move.
 *
 * Time Complexity: O(n√n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
