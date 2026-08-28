/*
 * LeetCode Problem #2099 - Find Subsequence of Length K With the Largest Sum
 *
 * Difficulty: Easy
 * Topic: Greedy, Sorting, Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 *
 * Approach:
 * Store each element along with its original index.
 *
 * Sort the elements in descending order and select the k largest
 * values. To preserve the order required for a subsequence, sort
 * the selected elements by their original indices before building
 * the result.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> nums[b] - nums[a]);

        Integer[] selected = Arrays.copyOf(indices, k);

        Arrays.sort(selected);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = nums[selected[i]];
        }

        return result;
    }
}
