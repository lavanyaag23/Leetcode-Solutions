/*
 * LeetCode Weekly Contest - Sum of GCD of Formed Pairs
 *
 * Difficulty: Medium
 * Topic: Contest / Number Theory
 *
 * Approach:
 * Sort the array, then repeatedly form pairs by taking
 * adjacent elements. Compute the GCD of each pair using
 * the Euclidean Algorithm and accumulate the sum.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) (excluding sorting)
 */

import java.util.Arrays;

class Solution {

    public long sumOfGCD(int[] nums) {

        Arrays.sort(nums);

        long sum = 0;

        for (int i = 0; i + 1 < nums.length; i += 2) {
            sum += gcd(nums[i], nums[i + 1]);
        }

        return sum;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
