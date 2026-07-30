/*
 * LeetCode Problem #3499 - Maximize Active Section with Trade I
 *
 * Difficulty: Medium
 * Topic: Arrays / Sliding Window / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/maximize-active-section-with-trade-i/
 *
 * Approach:
 * 
 * We count the existing number of '1's.
 *
 * The trade operation allows converting one continuous
 * inactive section surrounded by active sections.
 *
 * Using run-length encoding:
 * - Store consecutive groups of 0s and 1s.
 * - For every middle 1-block surrounded by 0-blocks,
 *   calculate the gain from converting it.
 *
 * Gain = left zero block + right zero block
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();


        int initialOnes = 0;

        for (char c : s.toCharArray()) {

            if (c == '1') {
                initialOnes++;
            }
        }


        String t = "1" + s + "1";


        int[] len = new int[n + 2];
        char[] type = new char[n + 2];

        int count = 0;
        int i = 0;


        while (i < t.length()) {

            int j = i;


            while (j < t.length() &&
                    t.charAt(j) == t.charAt(i)) {

                j++;
            }


            len[count] = j - i;
            type[count] = t.charAt(i);

            count++;

            i = j;
        }


        int answer = initialOnes;


        for (int k = 1; k < count - 1; k++) {

            if (type[k] == '1') {

                int leftZero = len[k - 1];
                int rightZero = len[k + 1];


                if (leftZero > 0 && rightZero > 0) {

                    answer = Math.max(
                            answer,
                            initialOnes + leftZero + rightZero
                    );
                }
            }
        }


        return answer;
    }
}
