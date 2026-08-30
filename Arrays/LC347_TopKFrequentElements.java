/*
 * LeetCode Problem #347 - Top K Frequent Elements
 *
 * Difficulty: Medium
 * Topic: Arrays / Hashing
 *
 * Problem Link:
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Approach:
 * Use a HashMap to count the frequency of each element.
 * Then use a bucket array where the index represents frequency.
 * Elements are placed into buckets according to their frequency.
 * Traverse the buckets from highest frequency to lowest and collect
 * elements until k elements are found.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int freq = buckets.length - 1; freq >= 0 && index < k; freq--) {

            if (buckets[freq] != null) {
                for (int num : buckets[freq]) {
                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
