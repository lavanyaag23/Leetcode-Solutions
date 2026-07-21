/*
 * LeetCode Problem #3228 - Maximize Active Section with Trade I
 *
 * Difficulty: Medium
 * Topic: Strings
 *
 * Problem Link:
 * https://leetcode.com/problems/maximize-active-section-with-trade-i/
 *
 * Approach:
 * Add artificial '1's at both ends of the string to simplify
 * boundary handling.
 *
 * First, count the number of 1s in the original string.
 *
 * Then, divide the modified string into consecutive runs of
 * 0s and 1s.
 *
 * For every internal 1-run surrounded by two 0-runs:
 *
 *     0-run | 1-run | 0-run
 *
 * We can turn the middle 1-run into 0s, causing the three
 * runs to merge into one continuous 0-run.
 *
 * We can then turn this merged 0-run into 1s.
 *
 * Therefore, the gain is:
 *
 *     leftZero + rightZero
 *
 * We calculate the maximum possible gain over all internal
 * 1-runs.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();

        // Add artificial 1s to handle boundary cases
        String t = "1" + s + "1";

        // Count initial number of 1s
        int initialOnes = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                initialOnes++;
            }
        }

        int maxAnswer = initialOnes;

        // Store lengths and types of consecutive runs
        int[] len = new int[n + 2];
        char[] type = new char[n + 2];

        int count = 0;
        int i = 0;

        // Divide the string into consecutive runs
        while (i < t.length()) {

            int j = i;

            while (j < t.length()
                    && t.charAt(j) == t.charAt(i)) {
                j++;
            }

            len[count] = j - i;
            type[count] = t.charAt(i);
            count++;

            i = j;
        }

        /*
         * Consider an internal 1-run:
         *
         *     0-run | 1-run | 0-run
         *
         * Convert the 1-run into 0s.
         * The three runs merge into one 0-run.
         *
         * Convert the merged 0-run into 1s.
         *
         * Gain = leftZero + rightZero
         */
        for (int k = 1; k < count - 1; k++) {

            if (type[k] == '1') {

                int leftZero = len[k - 1];
                int rightZero = len[k + 1];

                if (leftZero > 0 && rightZero > 0) {

                    maxAnswer = Math.max(
                        maxAnswer,
                        initialOnes + leftZero + rightZero
                    );
                }
            }
        }

        return maxAnswer;
    }
}
