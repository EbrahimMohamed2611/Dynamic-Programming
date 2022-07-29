package io.educative.fibonacciNumbers;

public class ClimbingStairsTwoStairs {

    // (1) Using BruteForce

    /*
     * public static int climbStairs(int n) {
     * if (n == 0 || n == 1) return 1;
     * <p>
     * int oneStair = climbStairs(n - 1);
     * int twoStair = climbStairs(n - 2);
     * return oneStair + twoStair;
     * }
     */


    // (2) Using Memoization

    /*
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 41 MB, less than 41.54% of Java online submissions for Climbing Stairs.
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1]; // From 0 To N
        return climbStairsRecursive(n, dp);
    }

    private static int climbStairsRecursive(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = climbStairsRecursive(n - 1, dp) + climbStairsRecursive(n - 2, dp);
        return dp[n];
    }

    // (3) Using Iterative And Tabulation

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    Memory Usage: 40.9 MB, less than 41.54% of Java online submissions for Climbing Stairs.
    */

    public static int climbStairsTabulation(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    // (4) Using Iterative with space Optimization

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    Memory Usage: 38.9 MB, less than 94.58% of Java online submissions for Climbing Stairs.
     */
    public static int climbStairsSpaceOptimization(int n) {
        if (n == 0 || n == 1) return 1;
        int prevStair = 1;
        int secondPrevStair = 1;
        int currentStair = 0;
        for (int i = 2; i <= n; i++) {
            currentStair = prevStair + secondPrevStair;
            secondPrevStair = prevStair;
            prevStair = currentStair;
        }
        return currentStair;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3

        System.out.println(climbStairsTabulation(2)); // 2
        System.out.println(climbStairsTabulation(3)); // 3

        System.out.println(climbStairsSpaceOptimization(2)); // 2
        System.out.println(climbStairsSpaceOptimization(3)); // 3
    }
}
