/*
 * LeetCode Problem #3718 - Smallest Missing Multiple of K
 *
 * Difficulty: Easy
 * Topic: Math, Arrays, HashSet
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-missing-multiple-of-k/
 *
 * Approach:
 * Store all elements of the array in a HashSet.
 * Starting from k, check each positive multiple of k.
 * The first multiple that is not present in the set is the answer.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int multiple = k;

        while (set.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}
