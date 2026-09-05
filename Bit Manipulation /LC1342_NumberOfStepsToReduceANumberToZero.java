/*
 * LeetCode Problem #1342 - Number of Steps to Reduce a Number to Zero
 *
 * Difficulty: Easy
 * Topic: Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 *
 * Approach:
 * Use bit manipulation to reduce the number.
 *
 * If the number is even, right shift it by one bit, which is
 * equivalent to dividing it by 2.
 *
 * If the number is odd, subtract 1 to make it even.
 *
 * Count every operation until the number becomes zero.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numberOfSteps(int num) {

        int steps = 0;

        while (num > 0) {

            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num--;
            }

            steps++;
        }

        return steps;
    }
}
