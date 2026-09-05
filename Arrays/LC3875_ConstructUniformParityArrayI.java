/*
 * LeetCode Problem #3875 - Construct Uniform Parity Array I
 *
 * Difficulty: Easy
 * Topic: Arrays, Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/construct-uniform-parity-array-i/
 *
 * Approach:
 * Check the parity of the elements in the array.
 *
 * If all elements have the same parity, the array is already uniform.
 * Otherwise, determine whether the required operation can make all
 * elements have the same parity.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean constructUniformParityArray(int[] nums) {

        boolean hasEven = false;
        boolean hasOdd = false;

        for (int num : nums) {

            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }

            if (hasEven && hasOdd) {
                return false;
            }
        }

        return true;
    }
}
