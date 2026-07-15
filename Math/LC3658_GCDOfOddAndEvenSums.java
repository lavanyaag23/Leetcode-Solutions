/*
LeetCode Problem: 3658. GCD of Odd and Even Sums
Difficulty: Easy

Approach:
- The sum of the first n odd numbers is n².
- The sum of the first n even numbers is n(n + 1).
- Compute the GCD of these two values using the Euclidean Algorithm.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n, n * (n + 1));
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
