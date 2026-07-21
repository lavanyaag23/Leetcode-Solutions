/*
 * LeetCode Problem #225 - Implement Stack using Queues
 *
 * Difficulty: Easy
 * Topic: Stack / Queue
 *
 * Problem Link:
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Approach:
 * Implement a stack using a single queue.
 *
 * For the push operation, add the new element to the queue.
 * Then rotate the previous elements to the back of the queue.
 * This ensures that the most recently added element always
 * stays at the front of the queue.
 *
 * Therefore:
 * - push() adds an element and rotates the queue.
 * - pop() removes the front element.
 * - top() returns the front element.
 * - empty() checks whether the queue is empty.
 *
 * Time Complexity:
 * push() - O(n)
 * pop()  - O(1)
 * top()  - O(1)
 * empty() - O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.offer(x);

        // Move all previous elements behind the new element
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
