/*
 * LeetCode Problem #938 - Range Sum of BST
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Search Tree, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Approach:
 * Use DFS to traverse the BST.
 * If the current node value is within [low, high], add it to the sum.
 * Since it is a BST, skip the left subtree when the value is below low
 * and skip the right subtree when the value is above high.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
