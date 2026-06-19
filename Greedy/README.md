# LeetCode #55 - Jump Game

## Problem Statement

You are given an integer array `nums`.

Each element in the array represents the maximum jump length from that position.

Determine whether you can reach the last index starting from the first index.

### Example 1

```text
Input: nums = [2,3,1,1,4]
Output: true
```

### Example 2

```text
Input: nums = [3,2,1,0,4]
Output: false
```

---

## Approach

This problem can be solved efficiently using a **Greedy Algorithm**.

* Keep track of the farthest index that can be reached.
* Iterate through the array.
* If the current index is beyond the farthest reachable index, reaching the end is impossible.
* Update the farthest reachable index at each step.
* If the farthest reachable index reaches or exceeds the last index, return `true`.

---

## Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## Concepts Used

* Arrays
* Greedy Algorithm
* Problem Solving

---

## LeetCode Details

* Problem Number: 55
* Difficulty: Medium
* Topic: Greedy

---

## Solution Language

Java
