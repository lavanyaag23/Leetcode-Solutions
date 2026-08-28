/*
 * LeetCode Problem #3069 - Distribute Elements Into Two Arrays I
 *
 * Difficulty: Easy
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/distribute-elements-into-two-arrays-i/
 *
 * Approach:
 * Initialize two arrays using the first two elements.
 * For each remaining element, compare the last elements of both arrays.
 * Place the current element into the array whose last element is larger.
 * Finally, concatenate both arrays to form the result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] resultArray(int[] nums) {

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        first.add(nums[0]);
        second.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {

            if (first.get(first.size() - 1) > second.get(second.size() - 1)) {
                first.add(nums[i]);
            } else {
                second.add(nums[i]);
            }
        }

        int[] result = new int[nums.length];
        int index = 0;

        for (int value : first) {
            result[index++] = value;
        }

        for (int value : second) {
            result[index++] = value;
        }

        return result;
    }
}
