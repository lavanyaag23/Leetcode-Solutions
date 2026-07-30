/*
 * LeetCode Problem #1670 - Design Front Middle Back Queue
 *
 * Difficulty: Medium
 * Topic: Queue / Deque
 *
 * Problem Link:
 * https://leetcode.com/problems/design-front-middle-back-queue/
 *
 * Approach:
 * Use two Deques to maintain balance:
 *
 * left  -> stores first half of elements
 * right -> stores second half of elements
 *
 * Maintain:
 * size(left) == size(right)
 * OR
 * size(left) == size(right) + 1
 *
 * Middle element is always the last element of left.
 *
 * Time Complexity:
 * All operations: O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.*;

class FrontMiddleBackQueue {

    private Deque<Integer> left;
    private Deque<Integer> right;


    public FrontMiddleBackQueue() {

        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }


    private void balance() {

        while (left.size() > right.size() + 1) {

            right.addFirst(left.removeLast());
        }


        while (left.size() < right.size()) {

            left.addLast(right.removeFirst());
        }
    }


    public void pushFront(int val) {

        left.addFirst(val);

        balance();
    }


    public void pushMiddle(int val) {

        if (left.size() > right.size()) {

            right.addFirst(left.removeLast());
        }

        left.addLast(val);

        balance();
    }


    public void pushBack(int val) {

        right.addLast(val);

        balance();
    }


    public int popFront() {

        if (isEmpty()) {
            return -1;
        }

        int value;

        if (!left.isEmpty()) {

            value = left.removeFirst();

        } else {

            value = right.removeFirst();
        }

        balance();

        return value;
    }


    public int popMiddle() {

        if (isEmpty()) {
            return -1;
        }

        int value = left.removeLast();

        balance();

        return value;
    }


    public int popBack() {

        if (isEmpty()) {
            return -1;
        }

        int value;

        if (!right.isEmpty()) {

            value = right.removeLast();

        } else {

            value = left.removeLast();
        }

        balance();

        return value;
    }


    private boolean isEmpty() {

        return left.isEmpty() && right.isEmpty();
    }
}
