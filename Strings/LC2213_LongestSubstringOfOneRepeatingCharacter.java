/*
 * LeetCode Problem #2213 - Longest Substring of One Repeating Character
 *
 * Difficulty: Hard
 * Topic: Strings, Segment Tree, Range Query
 *
 * Problem Link:
 * https://leetcode.com/problems/longest-substring-of-one-repeating-character/
 *
 * Approach:
 * Use a segment tree to maintain the longest consecutive sequence
 * of equal characters in every segment of the string.
 *
 * For each node, store:
 * - Prefix length of equal characters
 * - Suffix length of equal characters
 * - Maximum length of equal characters
 * - Leftmost and rightmost characters
 *
 * After each character update, merge the affected segments and use
 * the maximum value at the root as the current answer.
 *
 * Time Complexity: O((n + q) log n)
 * Space Complexity: O(n)
 */

class Solution {

    private int[] prefix;
    private int[] suffix;
    private int[] longest;
    private char[] leftChar;
    private char[] rightChar;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();

        prefix = new int[4 * n];
        suffix = new int[4 * n];
        longest = new int[4 * n];
        leftChar = new char[4 * n];
        rightChar = new char[4 * n];

        char[] chars = s.toCharArray();

        build(1, 0, n - 1, chars);

        int[] answer = new int[queryCharacters.length()];

        for (int i = 0; i < queryCharacters.length(); i++) {

            int index = queryIndices[i];
            chars[index] = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, chars[index]);

            answer[i] = longest[1];
        }

        return answer;
    }

    private void build(int node, int start, int end, char[] chars) {

        if (start == end) {
            prefix[node] = 1;
            suffix[node] = 1;
            longest[node] = 1;
            leftChar[node] = chars[start];
            rightChar[node] = chars[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid, chars);
        build(node * 2 + 1, mid + 1, end, chars);

        merge(node);
    }

    private void update(int node, int start, int end, int index, char value) {

        if (start == end) {
            prefix[node] = 1;
            suffix[node] = 1;
            longest[node] = 1;
            leftChar[node] = value;
            rightChar[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        merge(node);
    }

    private void merge(int node) {

        int left = node * 2;
        int right = node * 2 + 1;

        leftChar[node] = leftChar[left];
        rightChar[node] = rightChar[right];

        prefix[node] = prefix[left];
        suffix[node] = suffix[right];

        longest[node] = Math.max(longest[left], longest[right]);

        if (rightChar[left] == leftChar[right]) {

            longest[node] = Math.max(
                longest[node],
                suffix[left] + prefix[right]
            );

            if (prefix[left] == getLength(left)) {
                prefix[node] = getLength(left) + prefix[right];
            }

            if (suffix[right] == getLength(right)) {
                suffix[node] = getLength(right) + suffix[left];
            }
        }
    }

    private int getLength(int node) {
        return prefix[node] + suffix[node] - 1;
    }
}
