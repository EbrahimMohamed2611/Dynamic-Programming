package io.educative.fibonacciNumbers;

/*
Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.
 */
public class NumberFactors {

    // First way Using BruteForce
    public static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
//        if (n == 2) return 1;
//        if (n == 3) return 2;
        int one = countWays(n - 1);
        int three = countWays(n - 3);
        int four = countWays(n - 4);
        return one + three + four;
    }

    // Second way Using Dynamic Programming Memoization
    public static int countWaysMemoization(int n) {
        int[] dp = new int[n + 1];
        return countWays(n, dp);
    }

    private static int countWays(int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 1 || n == 0) return 1;
        if (dp[n] != 0)
            return dp[n];
        int one = countWays(n - 1, dp);
        int three = countWays(n - 3, dp);
        int four = countWays(n - 4, dp);
        return dp[n] = one + three + four;
    }

    // Second way Using Dynamic Programming Tabulation
    public static int countWaysTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 4] + dp[i - 3] + dp[i - 1];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(countWays(4)); // 4
        System.out.println(countWays(5)); // 6

        System.out.println("DP With Memoization");
        System.out.println(countWaysMemoization(4)); // 4
        System.out.println(countWaysMemoization(5)); // 6

        System.out.println("DP With Tabulation");
        System.out.println(countWaysTabulation(4)); // 4
        System.out.println(countWaysTabulation(5)); // 6


    }
}
