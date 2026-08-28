/*
 * LeetCode Problem #1382 - Balance a Binary Search Tree
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Search Tree, Inorder Traversal
 *
 * Problem Link:
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 *
 * Approach:
 * Perform an inorder traversal to store all nodes in sorted order.
 * Then construct a balanced BST by choosing the middle node as the
 * root and recursively building the left and right subtrees.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    private List<TreeNode> nodes = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {

        inorder(root);
        return buildBalancedTree(0, nodes.size() - 1);
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        nodes.add(root);
        inorder(root.right);
    }

    private TreeNode buildBalancedTree(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = nodes.get(mid);

        root.left = buildBalancedTree(left, mid - 1);
        root.right = buildBalancedTree(mid + 1, right);

        return root;
    }
}
