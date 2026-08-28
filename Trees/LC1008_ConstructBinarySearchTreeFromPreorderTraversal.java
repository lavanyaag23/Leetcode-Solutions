/*
 * LeetCode Problem #1008 - Construct Binary Search Tree from Preorder Traversal
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Search Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * Approach:
 * The first element of preorder is the root.
 * Elements smaller than the root belong to the left subtree,
 * while larger elements belong to the right subtree.
 * Recursively construct both subtrees using the valid range.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {

        if (index == preorder.length) {
            return null;
        }

        int value = preorder[index];

        if (value < lower || value > upper) {
            return null;
        }

        TreeNode root = new TreeNode(value);
        index++;

        root.left = build(preorder, lower, value);
        root.right = build(preorder, value, upper);

        return root;
    }
}
