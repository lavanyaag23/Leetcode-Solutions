/*
 * LeetCode Problem #1464 - Maximum Product of Two Elements in an Array
 *
 * Difficulty: Easy
 * Topic: Arrays / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * Approach:
 * Find the two largest elements in the array.
 *
 * The maximum product is:
 * (largest - 1) * (secondLargest - 1)
 *
 * We can find the two maximum values in a single traversal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProduct(int[] nums) {

        int first = 0;
        int second = 0;


        for (int num : nums) {

            if (num > first) {

                second = first;
                first = num;

            } else if (num > second) {

                second = num;
            }
        }


        return (first - 1) * (second - 1);
    }
}
