package io.educative.fibonacciNumbers;

/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.
 */
public class NthTribonacciNumber {

    // First Way using BruteForce
    public static int tribonacci(int n) {
        if (n < 2)
            return n;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    // Second Way Using Dynamic Programming And Memoization
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
    Memory Usage: 41 MB, less than 40.20% of Java online submissions for N-th Tribonacci Number.
     */
    public static int tribonacciMemoization(int n) {
        int[] dp = new int[n + 1];
        return tribonacci(n, dp);
    }

    private static int tribonacci(int n, int[] dp) {
        if (n < 2)
            return n;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (dp[n] != 0)
            return dp[n];

        return dp[n] = tribonacci(n - 1, dp) + tribonacci(n - 2, dp) + tribonacci(n - 3, dp);
    }

    // Third Way Using Dynamic Programming And Tabulation
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
    Memory Usage: 40.5 MB, less than 71.76% of Java online submissions for N-th Tribonacci Number.
     */
    public static int tribonacciTabulation(int n) {
        if (n == 0) return 0;
        if (n < 2)
            return n;
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }


    // Fourth Way Using Dynamic Programming And Space Optimization
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
    Memory Usage: 41 MB, less than 32.48% of Java online submissions for N-th Tribonacci Number.
     */
    public static int tribonacciSpaceOptimization(int n) {
        if (n == 0) return 0;
        if (n < 2)
            return n;
        if (n == 2) return 1;

        int thirdPrev = 0; // 0
        int secondPrev = 1; // 1
        int firstPrev = 1; // 2
        int fibOfN = 0;
        for (int i = 3; i <= n; i++) {
            fibOfN = thirdPrev + secondPrev + firstPrev;
            thirdPrev = secondPrev;
            secondPrev = firstPrev;
            firstPrev = fibOfN;
        }
        return fibOfN;
    }


    public static void main(String[] args) {
        System.out.println(tribonacci(4)); // 4
        System.out.println(tribonacci(25)); // 1389537

        System.out.println(tribonacciMemoization(4)); // 4
        System.out.println(tribonacciMemoization(25)); // 1389537

        System.out.println(tribonacciTabulation(4)); // 4
        System.out.println(tribonacciTabulation(25)); // 1389537

        System.out.println(tribonacciSpaceOptimization(4)); // 4
        System.out.println(tribonacciSpaceOptimization(25)); // 1389537
    }
}
