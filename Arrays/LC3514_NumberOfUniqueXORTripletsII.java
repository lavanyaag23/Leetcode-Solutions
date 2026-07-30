/*
 * LeetCode Problem #3514 - Number of Unique XOR Triplets II
 *
 * Difficulty: Medium
 * Topic: Arrays / Bit Manipulation / Hashing
 *
 * Problem Link:
 * https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
 *
 * Approach:
 *
 * For every possible triplet (i, j, k):
 *
 * nums[i] ^ nums[j] ^ nums[k]
 *
 * is calculated and stored in a HashSet.
 *
 * The HashSet keeps only unique XOR values.
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^3)
 */


import java.util.*;


class Solution {

    public int uniqueXorTriplets(int[] nums) {


        HashSet<Integer> result = new HashSet<>();

        int n = nums.length;


        for (int i = 0; i < n; i++) {


            for (int j = i + 1; j < n; j++) {


                for (int k = j + 1; k < n; k++) {


                    result.add(
                        nums[i] ^ nums[j] ^ nums[k]
                    );
                }
            }
        }


        return result.size();
    }
}
