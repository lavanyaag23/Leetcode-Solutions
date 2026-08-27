/*
 * LeetCode Problem #3702 - Longest Subsequence With Non-Zero Bitwise XOR
 *
 * Difficulty: Medium
 * Topic: Bit Manipulation, Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/
 *
 * Approach:
 * The longest possible subsequence is the entire array if its XOR
 * is non-zero.
 *
 * If the XOR of all elements is zero, removing one element with a
 * non-zero value makes the XOR non-zero. Therefore, the answer is
 * n - 1 when at least one non-zero element exists.
 *
 * If all elements are zero, every subsequence has XOR equal to zero,
 * so no valid non-empty subsequence exists.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int longestSubsequence(int[] nums) {

        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        return hasNonZero ? nums.length - 1 : 0;
    }
}
