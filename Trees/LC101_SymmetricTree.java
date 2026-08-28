/*
 * LeetCode Problem #101 - Symmetric Tree
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Approach:
 * A binary tree is symmetric if the left subtree is a mirror image
 * of the right subtree.
 * Recursively compare the left node of one subtree with the right node
 * of the other subtree and vice versa.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
