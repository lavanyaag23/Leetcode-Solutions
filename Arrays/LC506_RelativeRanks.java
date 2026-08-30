/*
 * LeetCode Problem #506 - Relative Ranks
 *
 * Difficulty: Easy
 * Topic: Arrays / Sorting
 *
 * Problem Link:
 * https://leetcode.com/problems/relative-ranks/
 *
 * Approach:
 * Store each athlete's score along with their original index.
 * Sort the athletes by score in descending order.
 * Assign Gold Medal, Silver Medal, and Bronze Medal to the
 * top three athletes. The remaining athletes receive their rank.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {

            int index = indices[i];

            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}
