/*
 * LeetCode Problem #1979 - Find Greatest Common Divisor of Array
 *
 * Difficulty: Easy
 * Topic: Math
 *
 * Problem Link:
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 *
 * Approach:
 * Find the minimum and maximum elements in the array.
 * The GCD of the array is the GCD of these two values.
 * Use the Euclidean Algorithm to compute the GCD.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(min, max);
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
