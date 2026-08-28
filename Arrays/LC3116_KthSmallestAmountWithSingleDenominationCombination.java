/*
 * LeetCode Problem #3116 - Kth Smallest Amount With Single Denomination Combination
 *
 * Difficulty: Hard
 * Topic: Arrays, Math, Binary Search, Number Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/
 *
 * Approach:
 * Use binary search on the possible amount.
 * For a given value x, count how many positive amounts up to x are
 * divisible by at least one coin denomination using inclusion-exclusion.
 * The kth amount is the smallest x for which the count is at least k.
 *
 * Time Complexity: O(2^n * log(maxAnswer))
 * Space Complexity: O(1)
 */

class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long left = 1;
        long right = (long) coins[0] * k;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long count(long x, int[] coins) {

        long result = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long gcd = gcd(lcm, coins[i]);
                    lcm = lcm / gcd * coins[i];

                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                long value = x / lcm;

                if (bits % 2 == 1) {
                    result += value;
                } else {
                    result -= value;
                }
            }
        }

        return result;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
