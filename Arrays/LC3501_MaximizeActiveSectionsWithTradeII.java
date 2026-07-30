/*
 * LeetCode Problem #3501 - Maximize Active Section with Trade II
 *
 * Difficulty: Medium
 * Topic: Arrays / Sliding Window / Prefix Sum
 *
 * Problem Link:
 * https://leetcode.com/problems/maximize-active-sections-with-trade-ii/
 *
 * Approach:
 *
 * We need to maximize the number of active sections ('1').
 *
 * Convert the problem into finding the best gain by flipping
 * a continuous segment.
 *
 * Use Kadane's Algorithm:
 *
 * - '0' gives +1 gain when converted to '1'
 * - '1' gives -1 cost when converted
 *
 * Find maximum gain subarray and add it to existing ones.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


class Solution {

    public int maxActiveSectionsAfterTrade(String s) {


        int ones = 0;


        for (char ch : s.toCharArray()) {

            if (ch == '1') {
                ones++;
            }
        }


        int maxGain = 0;

        int currentGain = 0;


        for (char ch : s.toCharArray()) {


            if (ch == '0') {

                currentGain += 1;

            } else {

                currentGain -= 1;
            }


            currentGain = Math.max(currentGain, 0);


            maxGain = Math.max(maxGain, currentGain);
        }


        return ones + maxGain;
    }
}
