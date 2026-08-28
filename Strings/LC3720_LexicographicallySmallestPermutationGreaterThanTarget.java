/*
 * LeetCode Problem #3720 - Lexicographically Smallest Permutation Greater Than Target
 *
 * Difficulty: Medium
 * Topic: Strings, Backtracking, Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/
 *
 * Approach:
 * Build the permutation from left to right using the available characters.
 * Whenever possible, keep the current character equal to the target.
 * If equality is no longer possible, choose the smallest available character
 * greater than the corresponding target character and append the remaining
 * characters in sorted order.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public String lexicographicallySmallestPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int current = target.charAt(i) - 'a';

            if (freq[current] > 0) {
                freq[current]--;
                prefix.append(target.charAt(i));
                continue;
            }

            for (int c = current + 1; c < 26; c++) {

                if (freq[c] > 0) {
                    freq[c]--;
                    prefix.append((char) ('a' + c));

                    appendRemaining(prefix, freq);
                    return prefix.toString();
                }
            }

            while (prefix.length() > 0) {

                int last = prefix.length() - 1;
                int previous = prefix.charAt(last) - 'a';

                freq[previous]++;
                prefix.deleteCharAt(last);

                int targetIndex = prefix.length();
                int targetChar = target.charAt(targetIndex) - 'a';

                for (int c = targetChar + 1; c < 26; c++) {

                    if (freq[c] > 0) {
                        freq[c]--;
                        prefix.append((char) ('a' + c));

                        appendRemaining(prefix, freq);
                        return prefix.toString();
                    }
                }
            }

            return "";
        }

        return "";
    }

    private void appendRemaining(StringBuilder result, int[] freq) {

        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {
                result.append((char) ('a' + c));
                freq[c]--;
            }
        }
    }
}
