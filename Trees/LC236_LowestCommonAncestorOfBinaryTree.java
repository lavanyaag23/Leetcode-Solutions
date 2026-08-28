/*
 * LeetCode Problem #236 - Lowest Common Ancestor of a Binary Tree
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Approach:
 * Use recursion to search for nodes p and q.
 * If the current node is null, p, or q, return it.
 * Recursively search both subtrees.
 * If both sides return a node, the current node is the lowest common ancestor.
 * Otherwise, return the non-null result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
