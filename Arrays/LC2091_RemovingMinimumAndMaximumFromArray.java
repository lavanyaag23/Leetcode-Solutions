/*
 * LeetCode Problem #2091 - Removing Minimum and Maximum From Array
 *
 * Difficulty: Medium
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 *
 * Approach:
 * Find the positions of the minimum and maximum elements.
 * There are three possible ways to remove both:
 * 1. Remove both from the left.
 * 2. Remove both from the right.
 * 3. Remove the minimum from one side and the maximum from the other.
 *
 * Take the minimum number of removals among these possibilities.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex) + 1;
        int right = n - Math.max(minIndex, maxIndex);

        int mixed = Math.min(minIndex, maxIndex) + 1
                  + n - Math.max(minIndex, maxIndex);

        return Math.min(Math.min(left, right), mixed);
    }
}
