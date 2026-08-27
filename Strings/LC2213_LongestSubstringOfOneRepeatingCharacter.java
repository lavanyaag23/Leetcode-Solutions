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
    class Node {
        char left, right;
        int prefix, suffix, best, len;

        Node(char c) {
            left = right = c;
            prefix = suffix = best = len = 1;
        }

        Node() {}
    }

    Node[] tree;
    char[] arr;

    Node merge(Node a, Node b) {
        Node res = new Node();
        res.len = a.len + b.len;
        res.left = a.left;
        res.right = b.right;

        res.prefix = a.prefix;
        res.suffix = b.suffix;
        res.best = Math.max(a.best, b.best);

        if (a.right == b.left) {
            if (a.prefix == a.len)
                res.prefix = a.len + b.prefix;

            if (b.suffix == b.len)
                res.suffix = b.len + a.suffix;

            res.best = Math.max(res.best, a.suffix + b.prefix);
        }

        return res;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            tree[node] = new Node(c);
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, c);
        else
            update(node * 2 + 1, mid + 1, r, idx, c);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters,
                                  int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            arr[queryIndices[i]] = queryCharacters.charAt(i);

            update(1, 0, n - 1,
                   queryIndices[i],
                   queryCharacters.charAt(i));

            ans[i] = tree[1].best;
        }

        return ans;
    }
}
