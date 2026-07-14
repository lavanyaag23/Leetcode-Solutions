/*
 * LeetCode Problem #443 - String Compression
 *
 * Difficulty: Medium
 * Topic: Strings, Two Pointers
 *
 * Problem Link:
 * https://leetcode.com/problems/string-compression/
 *
 * Approach:
 * Use two pointers:
 * - One pointer traverses the array to count consecutive
 *   occurrences of each character.
 * - Another pointer writes the compressed result in-place.
 *
 * If a character appears more than once, append its count
 * after the character.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {

                String frequency = String.valueOf(count);

                for (char c : frequency.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
