/*
 * LeetCode Problem #3116 - Kth Smallest Amount With Single Denomination Combination
 *
 * Difficulty: Hard
 * Topic: Math, Binary Search, Inclusion-Exclusion
 *
 * Problem Link:
 * https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/
 *
 * Approach:
 * Use binary search on the possible amount.
 * For a given value, count how many positive integers up to that value
 * are divisible by at least one denomination using inclusion-exclusion.
 * Find the smallest value for which the count is at least k.
 *
 * Time Complexity: O(2^n log M)
 * Space Complexity: O(1)
 */

class Solution {
    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long value, int[] coins) {

        long total = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    if (lcm > value) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long current = value / lcm;

            if (bits % 2 == 1) {
                total += current;
            } else {
                total -= current;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
