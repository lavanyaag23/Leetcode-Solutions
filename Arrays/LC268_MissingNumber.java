/*
 * LeetCode Problem #268 - Missing Number
 *
 * Difficulty: Easy
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/missing-number/
 *
 * Approach:
 * Calculate the expected sum of numbers from 0 to n
 * and subtract the actual array elements to find
 * the missing number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }
}
