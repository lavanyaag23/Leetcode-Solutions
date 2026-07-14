/*
 * LeetCode Problem #189 - Rotate Array
 *
 * Difficulty: Medium
 * Topic: Arrays, Two Pointers
 *
 * Problem Link:
 * https://leetcode.com/problems/rotate-array/
 *
 * Approach:
 * Rotate the array to the right by k steps using the
 * reverse technique:
 * 1. Reverse the entire array.
 * 2. Reverse the first k elements.
 * 3. Reverse the remaining elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
