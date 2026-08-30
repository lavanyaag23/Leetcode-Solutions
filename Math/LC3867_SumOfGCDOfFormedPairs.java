/*
 * LeetCode Problem #3867 - Sum of GCD of Formed Pairs
 *
 * Difficulty: Medium
 * Topic: Math, Sorting, Two Pointers
 *
 * Problem Link:
 * https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/
 *
 * Approach:
 * First, construct the prefixGcd array by maintaining the maximum
 * element seen so far and calculating gcd(nums[i], max).
 *
 * Sort the prefixGcd array.
 *
 * Then pair the smallest element with the largest element,
 * the second smallest with the second largest, and so on.
 * Add the GCD of each pair to the answer.
 *
 * If the array length is odd, the middle element remains unpaired
 * and is ignored.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {

        int n = nums.length;
        int[] prefixGcd = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        long answer = 0;

        for (int i = 0; i < n / 2; i++) {
            answer += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }

        return answer;
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
