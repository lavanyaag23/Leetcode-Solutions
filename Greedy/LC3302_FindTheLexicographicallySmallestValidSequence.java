/*
 * LeetCode Problem #3302 - Find the Lexicographically Smallest Valid Sequence
 *
 * Difficulty: Medium
 * Topic: Greedy, Strings, Two Pointers
 *
 * Problem Link:
 * https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/
 *
 * Approach:
 * Find the earliest possible matching positions of the characters
 * of word2 in word1 using a forward scan.
 *
 * Then scan from the right to determine the latest possible matching
 * positions. This helps identify whether one character can be changed
 * while still forming a valid subsequence.
 *
 * Build the answer greedily by selecting the smallest possible
 * lexicographic sequence while maintaining enough positions for
 * the remaining characters.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

import java.util.*;

class Solution {
    public List<Integer> validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        List<Integer> result = new ArrayList<>();

        int[] suffix = new int[n + 1];
        Arrays.fill(suffix, n);

        int j = m - 1;

        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                suffix[j] = i;
                j--;
            }
        }

        int left = 0;
        boolean changed = false;

        for (int i = 0; i < n && left < m; i++) {

            if (word1.charAt(i) == word2.charAt(left)) {
                result.add(i);
                left++;
            } else if (!changed) {

                if (left + 1 == m || i + 1 <= suffix[left + 1]) {
                    result.add(i);
                    left++;
                    changed = true;
                }
            }
        }

        if (left != m) {
            return new ArrayList<>();
        }

        return result;
    }
}
