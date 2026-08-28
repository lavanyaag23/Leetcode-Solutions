/*
 * LeetCode Problem #1872 - Stone Game VIII
 *
 * Difficulty: Hard
 * Topic: Dynamic Programming, Prefix Sum, Game Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/stone-game-viii/
 *
 * Approach:
 * Build prefix sums and process the game from right to left.
 * At each position, choose whether to take the current prefix sum
 * or keep the best result obtained from the next position.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;
        int[] prefix = new int[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        int best = prefix[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            best = Math.max(best, prefix[i] - best);
        }

        return best;
    }
}
