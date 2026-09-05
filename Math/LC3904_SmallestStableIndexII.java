/*
 * LeetCode Problem #3904 - Smallest Stable Index II
 *
 * Difficulty: Easy
 * Topic: Math, String
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-stable-index-ii/
 *
 * Approach:
 * We check the indices from left to right and determine whether the
 * prefix and suffix satisfy the stability condition.
 *
 * The first index satisfying the condition is returned.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int smallestStableIndex(String s) {

        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (isStable(s, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isStable(String s, int index) {

        int left = 0;
        int right = 0;

        for (int i = 0; i <= index; i++) {
            left += s.charAt(i) - '0';
        }

        for (int i = index + 1; i < s.length(); i++) {
            right += s.charAt(i) - '0';
        }

        return left == right;
    }
}
