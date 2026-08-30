/*
 * LeetCode Problem #3345 - Smallest Divisible Digit Product I
 *
 * Difficulty: Easy
 * Topic: Math
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-divisible-digit-product-i/
 *
 * Approach:
 * Starting from n, calculate the product of the digits of each number.
 * If the digit product is divisible by t, return that number.
 * Otherwise, continue checking the next number.
 *
 * Time Complexity: O(k * d)
 * Space Complexity: O(1)
 */

class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int num = n;
            int product = 1;

            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}
