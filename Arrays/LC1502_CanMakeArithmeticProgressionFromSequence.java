/*
 * LeetCode Problem #1502 - Can Make Arithmetic Progression From Sequence
 *
 * Difficulty: Easy
 * Topic: Arrays / Sorting
 *
 * Problem Link:
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 *
 * Approach:
 *
 * An arithmetic progression has a constant difference
 * between consecutive elements.
 *
 * Steps:
 * 1. Sort the array.
 * 2. Calculate the difference between first two elements.
 * 3. Check if all adjacent differences are equal.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */


import java.util.Arrays;


class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {


        Arrays.sort(arr);


        int difference = arr[1] - arr[0];


        for (int i = 2; i < arr.length; i++) {


            if (arr[i] - arr[i - 1] != difference) {

                return false;
            }
        }


        return true;
    }
}
