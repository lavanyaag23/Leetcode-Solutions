/*
 * LeetCode Problem #918 - Maximum Sum Circular Subarray
 *
 * Difficulty: Medium
 * Topic: Dynamic Programming
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
 * Approach:
 * Use Kadane's Algorithm twice:
 * 1. Find the maximum subarray sum.
 * 2. Find the minimum subarray sum.
 * The circular maximum is:
 *      totalSum - minimumSubarraySum.
 * If all elements are negative, return the maximum subarray sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int maxSum = nums[0];
        int currentMax = 0;

        int minSum = nums[0];
        int currentMin = 0;

        for (int num : nums) {

            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
