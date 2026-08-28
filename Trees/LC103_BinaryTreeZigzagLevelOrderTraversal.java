/*
 * LeetCode Problem #103 - Binary Tree Zigzag Level Order Traversal
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, BFS
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Approach:
 * Perform a level-order traversal using a queue.
 * For each level, store the nodes normally when traversing from left
 * to right and reverse the order when traversing from right to left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
