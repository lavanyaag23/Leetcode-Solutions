/*
 * LeetCode Problem #501 - Find Mode in Binary Search Tree
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Search Tree, Inorder Traversal
 *
 * Problem Link:
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * Approach:
 * Perform an inorder traversal of the BST.
 * Since inorder traversal visits values in sorted order, count consecutive
 * equal values and track the maximum frequency.
 * Store all values whose frequency equals the maximum frequency.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    private Integer previous = null;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] modes = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            modes[i] = result.get(i);
        }

        return modes;
    }

    private void inorder(TreeNode node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        if (previous != null && previous == node.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            result.clear();
            result.add(node.val);
        } else if (currentCount == maxCount) {
            result.add(node.val);
        }

        previous = node.val;

        inorder(node.right);
    }
}
