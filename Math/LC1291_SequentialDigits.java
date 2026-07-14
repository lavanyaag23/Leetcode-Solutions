/*
 * LeetCode Problem #1291 - Sequential Digits
 *
 * Difficulty: Medium
 * Topic: Math
 *
 * Problem Link:
 * https://leetcode.com/problems/sequential-digits/
 *
 * Approach:
 * Generate all possible sequential digit numbers using
 * the string "123456789". For each possible length,
 * extract substrings, convert them to integers, and
 * include those within the given range.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();
        String digits = "123456789";

        int minLength = String.valueOf(low).length();
        int maxLength = String.valueOf(high).length();

        for (int length = minLength; length <= maxLength; length++) {

            for (int start = 0; start + length <= 9; start++) {

                int number = Integer.parseInt(
                        digits.substring(start, start + length));

                if (number >= low && number <= high) {
                    result.add(number);
                }
            }
        }

        return result;
    }
}
