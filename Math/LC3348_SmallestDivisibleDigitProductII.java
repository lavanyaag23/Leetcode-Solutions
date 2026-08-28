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

import java.util.*;

class Solution {

    // Prime factors: 2, 3, 5, 7
    // Maximum exponents needed for t <= 1e14
    int A, B, C, D;
    int BC_D, C_D, D_SIZE;
    int[] dp;

    // Factor contribution of digits 1..9
    int[][] factor = {
        {0, 0, 0, 0}, // 0 - unused
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {

        // Factorize t
        int[] need = new int[4];
        long x = t;

        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            while (x % primes[i] == 0) {
                need[i]++;
                x /= primes[i];
            }
        }

        // If t contains another prime factor, impossible.
        if (x != 1) {
            return "-1";
        }

        A = need[0];
        B = need[1];
        C = need[2];
        D = need[3];

        buildDP();

        /*
         * First try to use the same length as num.
         */

        int n = num.length();

        // Prefix factor counts.
        int[] p2 = new int[n + 1];
        int[] p3 = new int[n + 1];
        int[] p5 = new int[n + 1];
        int[] p7 = new int[n + 1];

        int[] zeroPrefix = new int[n + 1];

        for (int i = 0; i < n; i++) {

            int digit = num.charAt(i) - '0';

            p2[i + 1] = p2[i];
            p3[i + 1] = p3[i];
            p5[i + 1] = p5[i];
            p7[i + 1] = p7[i];

            zeroPrefix[i + 1] = zeroPrefix[i];

            if (digit == 0) {
                zeroPrefix[i + 1]++;
            } else {
                p2[i + 1] += factor[digit][0];
                p3[i + 1] += factor[digit][1];
                p5[i + 1] += factor[digit][2];
                p7[i + 1] += factor[digit][3];
            }
        }
        
        // This check is incorrect because num itself can contain zeros.
        // A valid number must be zero-free. If num has a zero, it can never be a valid answer itself.
        if (zeroPrefix[n] == 0 &&
            p2[n] >= A &&
            p3[n] >= B &&
            p5[n] >= C &&
            p7[n] >= D) {

            return num;
        }

        /*
         * Find the smallest number of the SAME length
         * that is greater than num.
         *
         * We try changing the rightmost possible position first.
         */
        for (int pos = n - 1; pos >= 0; pos--) {

            // Prefix before pos must contain no zero.
            if (zeroPrefix[pos] > 0) {
                continue;
            }

            int original = num.charAt(pos) - '0';

            // We need a strictly larger digit.
            for (int d = original + 1; d <= 9; d++) {

                int cur2 = Math.min(A, p2[pos] + factor[d][0]);
                int cur3 = Math.min(B, p3[pos] + factor[d][1]);
                int cur5 = Math.min(C, p5[pos] + factor[d][2]);
                int cur7 = Math.min(D, p7[pos] + factor[d][3]);

                int r2 = A - cur2;
                int r3 = B - cur3;
                int r5 = C - cur5;
                int r7 = D - cur7;

                int remaining = n - pos - 1;

                // Can the suffix satisfy the remaining factors?
                if (getDP(r2, r3, r5, r7) <= remaining) {

                    StringBuilder ans = new StringBuilder(n);

                    // Original prefix
                    ans.append(num, 0, pos);

                    // Changed digit
                    ans.append((char) ('0' + d));

                    // Build smallest possible suffix.
                    buildSuffix(
                        ans,
                        remaining,
                        r2, r3, r5, r7
                    );

                    return ans.toString();
                }
            }
        }

        /*
         * No solution of the same length.
         *
         * The next possible solution must be longer than num.
         * The length is determined by the greater of (n + 1) and the
         * minimum digits required by the prime factors of t.
         */
        int length = Math.max(n + 1, getDP(A, B, C, D));
        
        // If the number of digits required is impossibly large, the check within buildDP will handle it.
        // No need for an explicit check here. Let's construct the smallest number of that length.

        StringBuilder ans = new StringBuilder(length);

        buildSuffix(
            ans,
            length,
            A, B, C, D
        );

        return ans.toString();
    }

    /*
     * dp[state] = minimum number of digits needed to
     * satisfy the factor requirements represented by state.
     *
     * This is completely iterative.
     */
    private void buildDP() {

        D_SIZE = D + 1;
        C_D = (C + 1) * D_SIZE;
        BC_D = (B + 1) * C_D;

        int totalStates =
            (A + 1) * (B + 1) * (C + 1) * (D + 1);

        dp = new int[totalStates];
        // Use a value larger than any possible length (2e5)
        Arrays.fill(dp, 1_000_000); 

        dp[0] = 0;

        for (int a = 0; a <= A; a++) {
            for (int b = 0; b <= B; b++) {
                for (int c = 0; c <= C; c++) {
                    for (int d = 0; d <= D; d++) {

                        int idx = encode(a, b, c, d);

                        if (dp[idx] >= 1_000_000) {
                            continue;
                        }

                        int current = dp[idx];

                        // Digits 2..9.
                        for (int digit = 2; digit <= 9; digit++) {

                            int na = Math.min(
                                A,
                                a + factor[digit][0]
                            );

                            int nb = Math.min(
                                B,
                                b + factor[digit][1]
                            );

                            int nc = Math.min(
                                C,
                                c + factor[digit][2]
                            );

                            int nd = Math.min(
                                D,
                                d + factor[digit][3]
                            );

                            int next = encode(na, nb, nc, nd);

                            if (dp[next] > current + 1) {
                                dp[next] = current + 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private int encode(int a, int b, int c, int d) {
        return (((a * (B + 1) + b) * (C + 1) + c) * (D + 1) + d);
    }

    private int getDP(int a, int b, int c, int d) {
        return dp[encode(a, b, c, d)];
    }

    /*
     * Construct lexicographically smallest suffix.
     *
     * We are allowed to use digit 1 because it contributes
     * nothing to the product.
     */
    private void buildSuffix(
        StringBuilder ans,
        int length,
        int r2,
        int r3,
        int r5,
        int r7
    ) {

        for (int pos = 0; pos < length; pos++) {

            int left = length - pos - 1;

            for (int digit = 1; digit <= 9; digit++) {

                int nr2 = Math.max(
                    0,
                    r2 - factor[digit][0]
                );

                int nr3 = Math.max(
                    0,
                    r3 - factor[digit][1]
                );

                int nr5 = Math.max(
                    0,
                    r5 - factor[digit][2]
                );

                int nr7 = Math.max(
                    0,
                    r7 - factor[digit][3]
                );

                /*
                 * If the remaining factors can be satisfied
                 * using the remaining positions, choose this
                 * digit.
                 */
                if (getDP(nr2, nr3, nr5, nr7) <= left) {

                    ans.append((char) ('0' + digit));

                    r2 = nr2;
                    r3 = nr3;
                    r5 = nr5;
                    r7 = nr7;

                    break;
                }
            }
        }
    }
}
