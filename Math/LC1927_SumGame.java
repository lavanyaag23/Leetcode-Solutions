/*
 * LeetCode Problem #1927 - Sum Game
 *
 * Difficulty: Medium
 * Topic: Math, Greedy, Game Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/sum-game/
 *
 * Approach:
 * Calculate the difference between the sums of digits in the left
 * and right halves and count the number of '?' characters in each half.
 * Alice wins if Bob cannot make the two halves equal after optimally
 * replacing the unknown digits.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean sumGame(String num) {

        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftQuestion = 0;
        int rightQuestion = 0;

        for (int i = 0; i < half; i++) {

            if (num.charAt(i) == '?') {
                leftQuestion++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        for (int i = half; i < n; i++) {

            if (num.charAt(i) == '?') {
                rightQuestion++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int questionDifference = leftQuestion - rightQuestion;
        int sumDifference = leftSum - rightSum;

        if (questionDifference == 0) {
            return sumDifference != 0;
        }

        return Math.abs(sumDifference + questionDifference * 4) > 0;
    }
}
