/*
 * LeetCode Problem #2958 - Length of Longest Subarray With at Most K Frequency
 *
 * Difficulty: Medium
 * Topic: Arrays, Sliding Window, Hashing
 *
 * Problem Link:
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
 *
 * Approach:
 * Use a sliding window with a HashMap to store the frequency of
 * each element in the current window.
 *
 * Expand the right pointer and increase the frequency of the
 * current element. If its frequency becomes greater than k,
 * move the left pointer forward until the window becomes valid.
 *
 * Track the maximum valid window length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            frequency.put(
                nums[right],
                frequency.getOrDefault(nums[right], 0) + 1
            );

            while (frequency.get(nums[right]) > k) {
                frequency.put(
                    nums[left],
                    frequency.get(nums[left]) - 1
                );
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
