/*
 * LeetCode Problem #3734 - Lexicographically Smallest Palindromic Permutation Greater Than Target
 *
 * Difficulty: Hard
 * Topic: Strings, Greedy, Backtracking
 *
 * Problem Link:
 * https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/
 *
 * Approach:
 * Construct only the first half of the palindrome because the second half
 * is determined by mirroring it. Try to keep the prefix equal to the target
 * while possible. When equality is no longer possible, choose the smallest
 * available character greater than the target character and complete the
 * palindrome using the remaining characters in sorted order.
 *
 * Time Complexity: O(n * 26)
 * Space Complexity: O(n)
 */

class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int n = s.length();
        int half = n / 2;

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < half; i++) {

            int targetChar = target.charAt(i) - 'a';

            if (freq[targetChar] >= 2) {
                freq[targetChar] -= 2;
                left.append((char) ('a' + targetChar));
                continue;
            }

            String result = buildGreater(left, freq, target, i, n);
            if (!result.isEmpty()) {
                return result;
            }

            return "";
        }

        String candidate = buildPalindrome(left, freq, n);

        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        return buildGreater(left, freq, target, half - 1, n);
    }

    private String buildGreater(StringBuilder left, int[] freq,
                                String target, int position, int n) {

        for (int i = position; i >= 0; i--) {

            if (i < left.length()) {
                int previous = left.charAt(i) - 'a';
                freq[previous] += 2;
                left.deleteCharAt(i);
            }

            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (freq[c] >= 2) {

                    freq[c] -= 2;
                    left.append((char) ('a' + c));

                    while (left.length() < n / 2) {

                        boolean found = false;

                        for (int x = 0; x < 26; x++) {
                            if (freq[x] >= 2) {
                                freq[x] -= 2;
                                left.append((char) ('a' + x));
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            break;
                        }
                    }

                    return buildPalindrome(left, freq, n);
                }
            }
        }

        return "";
    }

    private String buildPalindrome(StringBuilder left, int[] freq, int n) {

        StringBuilder result = new StringBuilder(left);

        if (n % 2 == 1) {

            for (int c = 0; c < 26; c++) {
                if (freq[c] > 0) {
                    result.append((char) ('a' + c));
                    break;
                }
            }
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}
