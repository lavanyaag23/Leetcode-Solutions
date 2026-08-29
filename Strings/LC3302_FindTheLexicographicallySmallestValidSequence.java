/*
 * LeetCode Problem #3302 - Find the Lexicographically Smallest Valid Sequence
 *
 * Difficulty: Medium
 * Topic: Strings
 *
 * Problem Link:
 * https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/
 *
 * Approach:
 * Find the lexicographically smallest sequence of indices from word1
 * that can form word2 after deleting at most one character.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i] = m - j;
                j--;
            }
        }

        int[] result = new int[m];
        int index = 0;
        boolean skipped = false;

        for (int i = 0; i < n && index < m; i++) {

            if (word1.charAt(i) == word2.charAt(index)) {
                result[index++] = i;
            } 
            else if (!skipped && suffix[i + 1] >= m - index - 1) {
                skipped = true;
                result[index++] = i;
            }
        }

        return index == m ? result : new int[0];
    }
}
