/*
 * LeetCode Problem #102 - Binary Tree Level Order Traversal
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, BFS, Queue
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Approach:
 * Use Breadth First Search (BFS) with a queue.
 *
 * Process all nodes at the current level before moving to the
 * next level. The queue size at the beginning of each iteration
 * tells us how many nodes belong to the current level.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();
                level.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
