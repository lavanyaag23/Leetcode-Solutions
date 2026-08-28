/*
 * LeetCode Problem #3348 - Smallest Divisible Digit Product II
 *
 * Difficulty: Hard
 * Topic: Math, Greedy, Number Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-divisible-digit-product-ii/
 *
 * Approach:
 * Factorize the given number into prime factors 2, 3, 5, and 7.
 * Construct the smallest number whose digits have a product
 * divisible by the given number.
 *
 * The digit factors are grouped to minimize the resulting number.
 * If the required factorization cannot be represented using digits
 * from 1 to 9, return "-1".
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 */

class Solution {
    public String smallestNumber(String num, long t) {

        int[] count = new int[4];
        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                count[i]++;
                t /= primes[i];
            }
        }

        if (t != 1) {
            return "-1";
        }

        StringBuilder result = new StringBuilder();

        while (count[3] >= 1) {
            result.append('7');
            count[3]--;
        }

        while (count[2] >= 1) {
            result.append('5');
            count[2]--;
        }

        while (count[1] >= 2) {
            result.append('9');
            count[1] -= 2;
        }

        while (count[0] >= 3) {
            result.append('8');
            count[0] -= 3;
        }

        while (count[0] >= 1 && count[1] >= 1) {
            result.append('6');
            count[0]--;
            count[1]--;
        }

        while (count[0] >= 2) {
            result.append('4');
            count[0] -= 2;
        }

        while (count[1] >= 1) {
            result.append('3');
            count[1]--;
        }

        while (count[0] >= 1) {
            result.append('2');
            count[0]--;
        }

        char[] digits = result.toString().toCharArray();

        java.util.Arrays.sort(digits);

        return new String(digits);
    }
}
