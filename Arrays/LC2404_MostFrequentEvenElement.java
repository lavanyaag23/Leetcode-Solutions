/*
 * LeetCode Problem #2404 - Most Frequent Even Element
 *
 * Difficulty: Easy
 * Topic: Arrays / Hashing
 *
 * Problem Link:
 * https://leetcode.com/problems/most-frequent-even-element/
 *
 * Approach:
 * Count the frequency of every even number using a HashMap.
 * Then find the even number with the highest frequency.
 * If multiple even numbers have the same frequency, return
 * the smallest one.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {

            int num = entry.getKey();
            int count = entry.getValue();

            if (count > maxFrequency ||
                (count == maxFrequency && num < answer)) {
                maxFrequency = count;
                answer = num;
            }
        }

        return answer;
    }
}
