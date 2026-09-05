/*
 * LeetCode Problem #3876 - Construct Uniform Parity Array II
 *
 * Difficulty: Medium
 * Topic: Arrays, Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/construct-uniform-parity-array-ii/
 *
 * Approach:
 * Check whether the array can be transformed so that all elements
 * have the same parity.
 *
 * Count the number of even and odd elements. If all elements already
 * have the same parity, the array is uniform. Otherwise, determine
 * whether the allowed operation can make the required parity pattern.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean constructUniformParityArray(int[] nums) {

        int even = 0;
        int odd = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return even == nums.length || odd == nums.length;
    }
}
