/*
 * LeetCode Problem #2948 - Make Lexicographically Smallest Array by Swapping Elements
 *
 * Difficulty: Medium
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
 *
 * Approach:
 * Sort the elements while keeping track of their original indices.
 * Elements can be swapped when their values differ by at most limit.
 * Group such elements together and assign the sorted values back to
 * their original positions to obtain the lexicographically smallest array.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];

        int start = 0;

        while (start < n) {

            int end = start;

            while (end + 1 < n &&
                   pairs[end + 1][0] - pairs[end][0] <= limit) {
                end++;
            }

            List<Integer> indices = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                indices.add(pairs[i][1]);
            }

            Collections.sort(indices);

            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = pairs[start + i][0];
            }

            start = end + 1;
        }

        return result;
    }
}
