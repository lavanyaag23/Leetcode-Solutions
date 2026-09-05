/*
 * LeetCode Problem #137 - Single Number II
 *
 * Difficulty: Medium
 * Topic: Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/single-number-ii/
 *
 * Approach:
 * Every number appears exactly three times except one number.
 * Count the number of set bits at every bit position.
 * If a bit occurs three times, it contributes 0 after taking
 * the count modulo 3. The remaining bits form the single number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            int count = 0;

            for (int num : nums) {
                count += (num >> i) & 1;
            }

            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
