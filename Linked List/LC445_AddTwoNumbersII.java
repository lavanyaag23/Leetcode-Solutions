/*
 * LeetCode Problem #445 - Add Two Numbers II
 *
 * Difficulty: Medium
 * Topic: Linked List / Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * Approach:
 * Use two stacks to store the digits of both linked lists.
 *
 * Since the numbers are stored in forward order,
 * stacks allow us to process digits from least significant
 * digit to most significant digit.
 *
 * Add corresponding digits and create the result list
 * by inserting nodes at the front.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

import java.util.*;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        while (l1 != null) {

            stack1.push(l1.val);
            l1 = l1.next;
        }


        while (l2 != null) {

            stack2.push(l2.val);
            l2 = l2.next;
        }


        int carry = 0;
        ListNode head = null;


        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

            int sum = carry;


            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }


            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }


            carry = sum / 10;


            ListNode node = new ListNode(sum % 10);

            node.next = head;
            head = node;
        }


        return head;
    }
}
