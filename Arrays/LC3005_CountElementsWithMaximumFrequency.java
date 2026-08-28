/*
 * LeetCode Problem #3005 - Count Elements With Maximum Frequency
 *
 * Difficulty: Easy
 * Topic: Arrays, Hashing, Frequency Counting
 *
 * Problem Link:
 * https://leetcode.com/problems/count-elements-with-maximum-frequency/
 *
 * Approach:
 * Count the frequency of every element using a HashMap.
 *
 * Find the maximum frequency and then add the frequencies of all
 * elements that occur with this maximum frequency.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;

        for (int count : frequency.values()) {
            maxFrequency = Math.max(maxFrequency, count);
        }

        int result = 0;

        for (int count : frequency.values()) {
            if (count == maxFrequency) {
                result += count;
            }
        }

        return result;
    }
}
