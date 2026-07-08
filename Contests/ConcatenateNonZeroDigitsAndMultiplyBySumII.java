/*
 * LeetCode Problem - Concatenate Non-Zero Digits and Multiply by Sum II
 *
 * Difficulty: Medium
 * Topic: Math, String, Simulation
 *
 * Approach:
 * Extract all non-zero digits and concatenate them to form a number.
 * Calculate the sum of non-zero digits and multiply both values.
 * Use modulo operation to avoid overflow.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    static final long MOD = 1_000_000_007;

    public int sumAndMultiply(String s) {

        long number = 0;
        long sum = 0;

        for (char ch : s.toCharArray()) {

            int digit = ch - '0';

            if (digit != 0) {

                number = (number * 10 + digit) % MOD;
                sum += digit;
            }
        }

        return (int)((number * sum) % MOD);
    }
}
