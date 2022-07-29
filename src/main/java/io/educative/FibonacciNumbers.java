package io.educative;

import java.util.Arrays;

public class FibonacciNumbers {

    // (1) First BruteForce Solution Time Complexity (2^n) Space O(n)
    public static int fibonacci(int number) {
        if (number <= 1)
            return number;
        return fibonacci(number - 2) + fibonacci(number - 1);
    }

    // (2) Memoization Solution Time Complexity (n) Space O(n) + O(n) Stack space

    public static int fib(int number) {
        int[] dp = new int[number + 1];
        Arrays.fill(dp, -1);
        return fib(number, dp);
    }

    private static int fib(int number, int[] dp) {
        if (number <= 1)
            return number;

        if (dp[number] != -1)
            return dp[number];

        dp[number] = fib(number - 1, dp) + fib(number - 2, dp);
        return dp[number];

    }

    // (3) Tabulation Solution Time Complexity (n) Space O(n)
    public static int fibWithTabulation(int number) {
        int[] dp = new int[number + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= number; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[number];
    }

    // (4) Space Optimization Time Complexity (n) Space O(1)
    public static int fibSpaceOptimization(int number) {
        if (number <= 1)
            return 1;
        int prev = 1;
        int secondPrev = 0;
        int current = 0;
        for (int i = 2; i <= number; i++) {
            current = prev + secondPrev;
            secondPrev = prev;
            prev = current;
        }
        return current;
    }


    public static void main(String[] args) {

        System.out.println(fibonacci(5));
        System.out.println(fib(5));
        System.out.println(fibWithTabulation(5));
        System.out.println(fibSpaceOptimization(5));

        System.out.println(fibonacci(20));
        System.out.println(fib(20));
        System.out.println(fibWithTabulation(20));
        System.out.println(fibSpaceOptimization(20));
    }
}
