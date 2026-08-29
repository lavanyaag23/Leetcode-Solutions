/*
 * LeetCode Problem #3518 - Smallest Palindromic Rearrangement II
 *
 * Difficulty: Hard
 * Topic: Strings / Counting / Combinatorics
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/
 *
 * Approach:
 * Count the frequency of each character and construct the palindrome
 * from both ends.
 *
 * For each position, try characters in increasing order and determine
 * whether enough distinct palindromic arrangements can be formed
 * with that choice.
 *
 * The first valid choice gives the lexicographically smallest result.
 *
 * Time Complexity: O(n * 26)
 * Space Complexity: O(26)
 */

class Solution {

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        int halfLength = s.length() / 2;

        for (int pos = 0; pos < halfLength; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                if (freq[ch] == 0) {
                    continue;
                }

                freq[ch]--;

                long ways = countWays(freq);

                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                }

                k -= ways;
                freq[ch]++;
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        char middle = 0;

        if (s.length() % 2 == 1) {
            for (int i = 0; i < 26; i++) {
                if (s.chars().filter(c -> c - 'a' == i).count() % 2 == 1) {
                    middle = (char) ('a' + i);
                    break;
                }
            }
        }

        if (middle != 0) {
            return left.toString() + middle + right;
        }

        return left.toString() + right;
    }

    private long countWays(int[] freq) {
        int total = 0;

        for (int count : freq) {
            total += count;
        }

        long result = 1;

        for (int i = 1; i <= total; i++) {
            result = Math.min(Long.MAX_VALUE, result * i);
        }

        for (int count : freq) {
            for (int i = 1; i <= count; i++) {
                result /= i;
            }
        }

        return result;
    }
}
