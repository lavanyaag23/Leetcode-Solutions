/*
 * LeetCode Problem #27 - Remove Element
 *
 * Difficulty: Easy
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/remove-element/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}

