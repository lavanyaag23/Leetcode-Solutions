/*
 * LeetCode Problem #958 - Check Completeness of a Binary Tree
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, BFS, Queue
 *
 * Problem Link:
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * Approach:
 * Use level-order traversal (BFS).
 *
 * In a complete binary tree, after encountering a null child,
 * every following node in level-order traversal must also be null.
 *
 * Use a queue to process nodes level by level and maintain a flag
 * indicating whether a null position has already been encountered.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean isCompleteTree(TreeNode root) {

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        boolean foundNull = false;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                foundNull = true;
            } else {

                if (foundNull) {
                    return false;
                }

                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return true;
    }
}
