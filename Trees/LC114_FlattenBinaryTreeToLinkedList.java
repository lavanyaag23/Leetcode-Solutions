/*
 * LeetCode Problem #114 - Flatten Binary Tree to Linked List
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Approach:
 * Use reverse preorder traversal (right -> left -> root).
 * Keep track of the previously processed node and connect the current
 * node's right pointer to it while setting its left pointer to null.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {

    private TreeNode previous = null;

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = previous;
        root.left = null;

        previous = root;
    }
}
