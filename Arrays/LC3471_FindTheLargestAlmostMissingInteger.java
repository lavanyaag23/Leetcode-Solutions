/*
 * LeetCode Problem #3471 - Find the Largest Almost Missing Integer
 *
 * Difficulty: Easy
 * Topic: Arrays, Hashing, Frequency Counting
 *
 * Problem Link:
 * https://leetcode.com/problems/find-the-largest-almost-missing-integer/
 *
 * Approach:
 * Count how many times each number appears in the array.
 * An integer is almost missing if it appears in exactly one subarray
 * of length k. Track the candidates that satisfy the condition and
 * return the largest one.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i <= n - k; i++) {

            Set<Integer> seen = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }

            for (int value : seen) {
                frequency.put(value, frequency.getOrDefault(value, 0) + 1);
            }
        }

        int answer = -1;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                answer = Math.max(answer, entry.getKey());
            }
        }

        return answer;
    }
}
