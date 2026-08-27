/*
 * LeetCode Problem #700 - Search in a Binary Search Tree
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Search Tree
 *
 * Problem Link:
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * Approach:
 * Use the Binary Search Tree property to search efficiently.
 * If the target is smaller than the current node, move to the left subtree.
 * If the target is greater, move to the right subtree.
 * If the target matches the current node, return the current node.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(1)
 */

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {

            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}
