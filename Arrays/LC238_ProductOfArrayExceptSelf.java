# LeetCode 238 - Product of Array Except Self

## Problem Difficulty
🟡 Medium

## Problem Statement

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The solution must run in O(n) time without using division.

## Example

Input:
[1,2,3,4]

Output:
[24,12,8,6]

## Approach

- Create a prefix product array.
- Create a suffix product array.
- Multiply prefix and suffix products for each index.
- Achieve O(n) time complexity.

## Concepts Used

- Arrays
- Prefix Product
- Suffix Product
- Space Optimization

## Time Complexity

O(n)

## Space Complexity

O(1) Extra Space (excluding output array)

## LeetCode 
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;

        for(int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        for(int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }

        return answer;
    }
}

https://leetcode.com/problems/product-of-array-except-self/

---
⭐ Solved as part of my DSA & LeetCode journey.
