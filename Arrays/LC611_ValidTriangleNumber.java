/*
 * LeetCode Problem #611 - Valid Triangle Number
 *
 * Difficulty: Medium
 * Topic: Arrays, Sorting, Two Pointers
 *
 * Problem Link:
 * https://leetcode.com/problems/valid-triangle-number/
 *
 * Approach:
 * Sort the array first. Then, fix the largest side and use
 * two pointers to count all valid pairs that satisfy the
 * triangle inequality:
 *
 * nums[left] + nums[right] > nums[i]
 *
 * If the condition is true, all elements between left and
 * right also satisfy it, so add (right - left) to the answer.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1) (excluding sorting implementation)
 */

import java.util.Arrays;

class Solution {

    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int count = 0;
        int n = nums.length;

        for (int i = n - 1; i >= 2; i--) {

            int left = 0;
            int right = i - 1;

            while (left < right) {

                if (nums[left] + nums[right] > nums[i]) {

                    count += right - left;
                    right--;

                } else {

                    left++;
                }
            }
        }

        return count;
    }
}
