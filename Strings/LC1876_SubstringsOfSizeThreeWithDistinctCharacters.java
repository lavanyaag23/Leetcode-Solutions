/*
 * LeetCode Problem #1876 - Substrings of Size Three with Distinct Characters
 *
 * Difficulty: Easy
 * Topic: Strings / Sliding Window
 *
 * Problem Link:
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 *
 * Approach:
 * Check every substring of length 3.
 * A substring is valid if all three characters are different.
 * Count the number of valid substrings.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countGoodSubstrings(String s) {

        int count = 0;

        for (int i = 0; i <= s.length() - 3; i++) {

            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) {
                count++;
            }
        }

        return count;
    }
}
