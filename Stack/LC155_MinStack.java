/*
 * LeetCode Problem #155 - Min Stack
 *
 * Difficulty: Medium
 * Topic: Stack / Design
 *
 * Problem Link:
 * https://leetcode.com/problems/min-stack/
 *
 * Approach:
 * Use two stacks:
 *
 * 1. mainStack:
 *    Stores all pushed values.
 *
 * 2. minStack:
 *    Stores minimum values at each level.
 *
 * Whenever a smaller or equal value is pushed,
 * add it to minStack.
 *
 * During pop, remove from minStack if the popped
 * value is the current minimum.
 *
 * Time Complexity:
 * push()    -> O(1)
 * pop()     -> O(1)
 * top()     -> O(1)
 * getMin()  -> O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int val) {

        stack.push(val);


        if (minStack.isEmpty() || 
            val <= minStack.peek()) {

            minStack.push(val);
        }
    }


    public void pop() {

        int removed = stack.pop();


        if (removed == minStack.peek()) {

            minStack.pop();
        }
    }


    public int top() {

        return stack.peek();
    }


    public int getMin() {

        return minStack.peek();
    }
}
