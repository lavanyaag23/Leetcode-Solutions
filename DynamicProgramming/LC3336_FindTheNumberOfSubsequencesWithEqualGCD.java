/*
 * LeetCode Problem #3336 - Find the Number of Subsequences With Equal GCD
 *
 * Difficulty: Hard
 * Topic: Dynamic Programming, Math, GCD
 *
 * Problem Link:
 * https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/
 *
 * Approach:
 * Use Dynamic Programming where dp[g1][g2] stores the number
 * of ways to build two disjoint subsequences having GCDs g1
 * and g2 respectively.
 *
 * For every element, there are three choices:
 * 1. Skip the element.
 * 2. Add it to the first subsequence.
 * 3. Add it to the second subsequence.
 *
 * Update the GCDs accordingly and accumulate the number of ways.
 * Finally, sum all states where both subsequences have the same
 * non-zero GCD.
 *
 * Time Complexity: O(n × M²)
 * Space Complexity: O(M²)
 *
 * where M = 200 (maximum possible value in nums)
 */

class Solution {

    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {

        int MAX = 200;

        long[][] dp = new long[MAX + 1][MAX + 1];
        dp[0][0] = 1;

        for (int x : nums) {

            long[][] next = new long[MAX + 1][MAX + 1];

            for (int g1 = 0; g1 <= MAX; g1++) {

                for (int g2 = 0; g2 <= MAX; g2++) {

                    if (dp[g1][g2] == 0) {
                        continue;
                    }

                    long ways = dp[g1][g2];

                    // Skip current element
                    next[g1][g2] = (next[g1][g2] + ways) % MOD;

                    // Add to first subsequence
                    int newGcd1 = (g1 == 0) ? x : gcd(g1, x);
                    next[newGcd1][g2] =
                            (next[newGcd1][g2] + ways) % MOD;

                    // Add to second subsequence
                    int newGcd2 = (g2 == 0) ? x : gcd(g2, x);
                    next[g1][newGcd2] =
                            (next[g1][newGcd2] + ways) % MOD;
                }
            }

            dp = next;
        }

        long answer = 0;

        for (int gcd = 1; gcd <= MAX; gcd++) {
            answer = (answer + dp[gcd][gcd]) % MOD;
        }

        return (int) answer;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
