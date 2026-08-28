/*
 * LeetCode Problem #486 - Predict the Winner
 *
 * Difficulty: Medium
 * Topic: Dynamic Programming, Game Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/predict-the-winner/
 */

class Solution {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = nums.clone();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(
                    nums[i] - dp[j],
                    nums[j] - dp[j - 1]
                );
            }
        }

        return dp[n - 1] >= 0;
    }
}
