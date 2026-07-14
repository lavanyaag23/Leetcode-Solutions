/*
 * LeetCode Problem #704 - Binary Search
 *
 * Difficulty: Easy
 * Topic: Binary Search
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-search/
 *
 * Approach:
 * Use the Binary Search algorithm on the sorted array.
 * Compare the middle element with the target and
 * eliminate half of the search space in each iteration
 * until the target is found or the search space becomes empty.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int search(int[] nums, int target) {

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

        return -1;
    }
}
