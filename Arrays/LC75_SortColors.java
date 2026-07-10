/*
 * LeetCode Problem #75 - Sort Colors
 *
 * Difficulty: Medium
 * Topic: Arrays, Two Pointers
 *
 * Problem Link:
 * https://leetcode.com/problems/sort-colors/
 *
 * Approach:
 * Use the Dutch National Flag Algorithm with three pointers:
 * - left: boundary for 0s
 * - right: boundary for 2s
 * - current: traverses the array
 *
 * Swap elements to place 0s at the beginning and 2s at the end,
 * leaving 1s automatically in the middle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public void sortColors(int[] nums) {

        int left = 0;
        int current = 0;
        int right = nums.length - 1;

        while (current <= right) {

            if (nums[current] == 0) {

                swap(nums, left, current);
                left++;
                current++;

            } else if (nums[current] == 2) {

                swap(nums, current, right);
                right--;

            } else {

                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
