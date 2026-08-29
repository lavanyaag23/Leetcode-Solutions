/*
 * LeetCode Problem #3756 - Concatenate Non-Zero Digits and Multiply by Sum II
 *
 * Difficulty: Medium
 * Topic: Math
 *
 * Problem Link:
 * https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/
 *
 * Approach:
 * Traverse the digits of n. Ignore all zero digits.
 * Concatenate the remaining digits to form a number and calculate
 * their sum at the same time.
 *
 * The final answer is the concatenated number multiplied by the
 * sum of the non-zero digits.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 */

class Solution {
    public long sumAndMultiply(int n) {

        String s = String.valueOf(n);
        StringBuilder digits = new StringBuilder();

        long sum = 0;

        for (char c : s.toCharArray()) {
            if (c != '0') {
                digits.append(c);
                sum += c - '0';
            }
        }

        long number = Long.parseLong(digits.toString());

        return number * sum;
    }
}
