/*
 * LeetCode Problem #199 - Binary Tree Right Side View
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, BFS
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Approach:
 * Perform a level-order traversal using a queue.
 * For each level, the last node processed is the node visible
 * from the right side.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}
