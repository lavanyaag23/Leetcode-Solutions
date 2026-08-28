/*
 * LeetCode Problem #3622 - Check Divisibility by Digit Sum and Product
 *
 * Difficulty: Easy
 * Topic: Math, Number Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/
 *
 * Approach:
 * Extract each digit of the number and calculate its digit sum and
 * digit product. The number is divisible by both values if the
 * remainder is zero for each.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean checkDivisibility(int n) {

        int original = n;
        int sum = 0;
        int product = 1;

        while (n > 0) {

            int digit = n % 10;

            sum += digit;
            product *= digit;

            n /= 10;
        }

        return original % sum == 0 && original % product == 0;
    }
}
