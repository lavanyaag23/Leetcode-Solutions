/*
 * LeetCode Problem #213 - House Robber II
 *
 * Difficulty: Medium
 * Topic: Dynamic Programming
 *
 * Problem Link:
 * https://leetcode.com/problems/house-robber-ii/
 *
 * Approach:
 * Since houses are arranged in a circle, the first and last
 * houses cannot both be robbed.
 * Solve two linear House Robber problems:
 * 1. Rob houses from index 0 to n-2
 * 2. Rob houses from index 1 to n-1
 * Return the maximum of the two results.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }

        return Math.max(
            robLinear(nums, 0, n - 2),
            robLinear(nums, 1, n - 1)
        );
    }

    private int robLinear(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for(int i = start; i <= end; i++) {

            int current = Math.max(prev1, nums[i] + prev2);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
