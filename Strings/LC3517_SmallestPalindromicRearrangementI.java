/*
 * LeetCode Problem #3517 - Smallest Palindromic Rearrangement I
 *
 * Difficulty: Medium
 * Topic: String / Counting / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
 *
 * Approach:
 *
 * A palindrome can be formed by:
 * - Taking half of the characters
 * - Sorting them in ascending order
 * - Mirroring the first half
 *
 * Since the first half determines the smallest palindrome,
 * arrange the smaller characters first.
 *
 * Steps:
 * 1. Count frequency of each character.
 * 2. Take half of every character count.
 * 3. Build the left half in sorted order.
 * 4. Add middle character if present.
 * 5. Append reverse of left half.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {

    public String smallestPalindrome(String s) {


        int[] freq = new int[26];


        for (char ch : s.toCharArray()) {

            freq[ch - 'a']++;
        }


        StringBuilder left = new StringBuilder();


        char middle = ' ';


        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1) {

                middle = (char) ('a' + i);
            }


            int count = freq[i] / 2;


            while (count-- > 0) {

                left.append((char) ('a' + i));
            }
        }


        StringBuilder answer = new StringBuilder();


        answer.append(left);


        if (middle != ' ') {

            answer.append(middle);
        }


        answer.append(left.reverse());


        return answer.toString();
    }
}
