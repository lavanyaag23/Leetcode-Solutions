/*
 * LeetCode Problem #67 - Add Binary
 *
 * Difficulty: Easy
 * Topic: Bit Manipulation, String
 *
 * Problem Link:
 * https://leetcode.com/problems/add-binary/
 *
 * Approach:
 * Traverse both binary strings from right to left.
 * Add corresponding bits along with the carry.
 * Store the result and reverse it at the end.
 *
 * Time Complexity: O(max(n, m))
 * Space Complexity: O(max(n, m))
 */

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}
