# Greedy Algorithms

This folder contains solutions to LeetCode problems related to **Greedy Algorithms** implemented in Java.

Greedy algorithms build up a solution step by step, always choosing the option that looks best at the moment. They are efficient and often used for optimization problems.

---

## 📚 Topics Covered

* Array-based Greedy Problems
* Interval Problems
* Jump Game Variations
* Maximum/Minimum Optimization Problems
* Scheduling Problems
* Partitioning Problems

---

## ✅ Solved Problems

| #   | Problem        | Difficulty |
|-----|----------------|------------|
| 55  | Jump Game      | Medium     |

---

## 🎯 Learning Objectives

* Understand greedy decision-making strategy
* Learn how to identify optimal local choices
* Improve array traversal techniques
* Solve reachability and optimization problems
* Distinguish between greedy and dynamic programming approaches

---

## 💡 Key Concepts

* **Farthest Reach Concept**
* **Local vs Global Optimization**
* **Single Pass Array Traversal**
* **Early Termination Condition**

---

## 🚀 Problem: LeetCode #55 - Jump Game

### 🧩 Problem Statement

You are given an integer array `nums`.

Each element represents the maximum jump length from that position.

Return `true` if you can reach the last index starting from index `0`, otherwise return `false`.

---

### 🧠 Approach (Greedy)

* Maintain a variable `maxReach` to track the farthest index you can reach.
* Iterate through the array.
* If the current index is greater than `maxReach`, return `false`.
* Update `maxReach = max(maxReach, i + nums[i])`.
* If `maxReach >= last index`, return `true`.

---

### ⚙️ Algorithm Steps

1. Initialize `maxReach = 0`
2. Traverse the array from left to right
3. If `i > maxReach`, return `false`
4. Update `maxReach`
5. If `maxReach >= n-1`, return `true`

---

### 📊 Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## 📌 Example

### Input
