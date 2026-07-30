/*
 * LeetCode Problem #628 - Maximum Product of Three Numbers
 *
 * Difficulty: Easy
 * Topic: Arrays / Sorting / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * Approach:
 * The maximum product can be formed by:
 *
 * 1. Three largest numbers
 * OR
 * 2. Two smallest negative numbers and the largest number
 *
 * Sort the array and check both possibilities.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

class Solution {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;


        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];


        int option2 = nums[0] * nums[1] * nums[n - 1];


        return Math.max(option1, option2);
    }
}
