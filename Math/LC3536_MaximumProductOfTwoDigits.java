/*
 * LeetCode Problem #3536 - Maximum Product of Two Digits
 *
 * Difficulty: Easy
 * Topic: Math / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-product-of-two-digits/
 *
 * Approach:
 * Extract all digits of the given number.
 *
 * The maximum product is obtained by multiplying
 * the two largest digits.
 *
 * Maintain the largest and second largest digits
 * while traversing the number.
 *
 * Time Complexity: O(log10(n))
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProduct(int n) {

        int first = 0;
        int second = 0;


        while (n > 0) {

            int digit = n % 10;
            n = n / 10;


            if (digit > first) {

                second = first;
                first = digit;

            } else if (digit > second) {

                second = digit;
            }
        }


        return first * second;
    }
}
