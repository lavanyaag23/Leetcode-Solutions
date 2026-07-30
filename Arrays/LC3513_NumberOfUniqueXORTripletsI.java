/*
 * LeetCode Problem #3513 - Number of Unique XOR Triplets I
 *
 * Difficulty: Medium
 * Topic: Arrays / Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/number-of-unique-xor-triplets-i/
 *
 * Approach:
 *
 * We need to find the number of unique values that can be
 * obtained by:
 *
 * nums[i] ^ nums[j] ^ nums[k]
 *
 * For every possible triplet, store the XOR result in a HashSet.
 *
 * HashSet automatically removes duplicate XOR values.
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 */


import java.util.*;


class Solution {

    public int uniqueXorTriplets(int[] nums) {


        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;


        for (int i = 0; i < n; i++) {


            for (int j = i + 1; j < n; j++) {


                for (int k = j + 1; k < n; k++) {


                    int xor = nums[i] ^ nums[j] ^ nums[k];


                    set.add(xor);
                }
            }
        }


        return set.size();
    }
}
