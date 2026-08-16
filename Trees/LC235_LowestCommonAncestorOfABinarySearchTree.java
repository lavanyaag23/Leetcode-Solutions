/*
 * LeetCode Problem #235 - Lowest Common Ancestor of a Binary Search Tree
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Search Tree
 *
 * Problem Link:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Approach:
 * Use the BST property to locate the split point.
 * If both nodes are smaller than the current node, move left.
 * If both nodes are greater than the current node, move right.
 * Otherwise, the current node is the Lowest Common Ancestor.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(1)
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }
}
