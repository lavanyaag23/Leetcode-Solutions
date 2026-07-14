/*
 * LeetCode Problem #35 - Search Insert Position
 *
 * Difficulty: Easy
 * Topic: Binary Search
 *
 * Problem Link:
 * https://leetcode.com/problems/search-insert-position/
 *
 * Approach:
 * Use Binary Search to find the target element.
 * If the target is found, return its index.
 * Otherwise, return the position where it should
 * be inserted to maintain the sorted order.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                return mid;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return left;
    }
}
