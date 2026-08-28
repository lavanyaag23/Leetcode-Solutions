/*
 * LeetCode Problem #2996 - Smallest Missing Integer Greater Than Sequential Prefix Sum
 *
 * Difficulty: Easy
 * Topic: Arrays, Hashing, Sorting
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
 *
 * Approach:
 * First, find the longest sequential prefix where every consecutive
 * element increases by exactly 1.
 *
 * Calculate the sum of this prefix. Starting from the prefix sum,
 * find the smallest integer that does not appear in the array.
 *
 * A HashSet is used for constant-time existence checks.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
