/*
 * LeetCode Problem #3312 - Sorted GCD Pair Queries
 *
 * Difficulty: Hard
 * Topic: Dynamic Programming / Number Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/sorted-gcd-pair-queries/
 *
 * Approach:
 * 1. Count the frequency of every number.
 * 2. For every possible GCD g, count how many array elements
 *    are divisible by g.
 * 3. Using inclusion-exclusion, compute the number of pairs
 *    having GCD exactly g.
 * 4. Build a prefix sum over the counts of GCD values.
 * 5. For each query, binary search on the prefix array to find
 *    the smallest GCD whose cumulative pair count exceeds the
 *    query index.
 *
 * Time Complexity: O(M log M + Q log M)
 * where M = maximum value in nums.
 *
 * Space Complexity: O(M)
 */

import java.util.*;

class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];

        for (int x : nums) {
            freq[x]++;
        }

        long[] divisible = new long[max + 1];

        for (int g = 1; g <= max; g++) {

            for (int multiple = g; multiple <= max; multiple += g) {
                divisible[g] += freq[multiple];
            }
        }

        long[] gcdPairs = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            long count = divisible[g];
            gcdPairs[g] = count * (count - 1) / 2;

            for (int multiple = g * 2; multiple <= max; multiple += g) {
                gcdPairs[g] -= gcdPairs[multiple];
            }
        }

        long[] prefix = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + gcdPairs[g];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1;

            int left = 1;
            int right = max;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = left;
        }

        return answer;
    }
}
