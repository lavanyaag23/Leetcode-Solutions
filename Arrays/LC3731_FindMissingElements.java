/*
 * LeetCode Problem #3731 - Find Missing Elements
 *
 * Difficulty: Easy
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/find-missing-elements/
 *
 * Approach:
 * Find the minimum and maximum elements in the array.
 * Store all elements in a set, then check every number
 * between the minimum and maximum values.
 * Any number not present in the set is a missing element.
 *
 * Time Complexity: O(n + r)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
