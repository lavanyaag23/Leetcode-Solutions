/*
 * LeetCode Problem #136 - Single Number
 *
 * Difficulty: Easy
 * Topic: Bit Manipulation, Array
 *
 * Problem Link:
 * https://leetcode.com/problems/single-number/
 *
 * Approach:
 * Every number appears twice except one number.
 * XOR of a number with itself is 0, and XOR with 0 gives the number.
 * Therefore, XOR all elements to find the single number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
