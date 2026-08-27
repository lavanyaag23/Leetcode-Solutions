/*
 * LeetCode Problem #2331 - Evaluate Boolean Binary Tree
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
 *
 * Approach:
 * Leaf nodes contain boolean values:
 * 0 represents false and 1 represents true.
 *
 * Internal nodes contain:
 * 2 -> OR operation
 * 3 -> AND operation
 *
 * Recursively evaluate the left and right subtrees and
 * apply the operation represented by the current node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public boolean evaluateTree(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        }

        return left && right;
    }
}
