/*
 * LeetCode Problem #3090 - Maximum Length Substring With Two Occurrences
 *
 * Difficulty: Easy
 * Topic: Strings, Sliding Window, Hashing
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
 *
 * Approach:
 * Use a sliding window to maintain a substring in which every character
 * appears at most twice.
 *
 * Expand the right pointer and update the frequency of the current
 * character. If any character appears more than twice, move the left
 * pointer until the window becomes valid again.
 *
 * Track the maximum valid window length throughout the traversal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maximumLengthSubstring(String s) {

        int[] frequency = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            frequency[s.charAt(right) - 'a']++;

            while (frequency[s.charAt(right) - 'a'] > 2) {
                frequency[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
