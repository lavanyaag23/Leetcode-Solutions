/*
 * LeetCode Problem #2904 - Shortest and Lexicographically Smallest Beautiful String
 *
 * Difficulty: Medium
 * Topic: Strings, Sliding Window
 *
 * Problem Link:
 * https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
 *
 * Approach:
 * Use a sliding window to find substrings containing exactly k occurrences
 * of '1'. Keep track of the shortest valid substring. If multiple substrings
 * have the same length, choose the lexicographically smallest one.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int ones = 0;
        String answer = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            if (ones == k) {

                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                if (answer.isEmpty()
                        || current.length() < answer.length()
                        || (current.length() == answer.length()
                        && current.compareTo(answer) < 0)) {
                    answer = current;
                }
            }
        }

        return answer;
    }
}
