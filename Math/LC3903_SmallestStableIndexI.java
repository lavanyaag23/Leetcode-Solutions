/*
 * LeetCode Problem #3903 - Smallest Stable Index I
 *
 * Difficulty: Easy
 * Topic: Math, Prefix Sum
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-stable-index-i/
 *
 * Approach:
 * Calculate the total sum of the array first.
 * Then traverse the array while maintaining the prefix sum.
 *
 * For each index, the suffix sum is:
 * totalSum - prefixSum - nums[i]
 *
 * The first index where the prefix sum equals the suffix sum
 * is the smallest stable index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int smallestStableIndex(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int suffixSum = totalSum - prefixSum - nums[i];

            if (prefixSum == suffixSum) {
                return i;
            }

            prefixSum += nums[i];
        }

        return -1;
    }
}
