package io.educative.fibonacciNumbers;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected,
    and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without
    alerting the police.
 */

public class HouseRobber_198 {

    // First Way using BruteForce
    public static int findMaxSteal(int[] wealth) {
        return findMaxStealHelper(wealth, wealth.length - 1);
    }

    private static int findMaxStealHelper(int[] wealth, int currentHouse) {
        if (currentHouse == 0)
            return wealth[currentHouse];
        if (currentHouse < 0)
            return 0;

        int stealFromCurrentHouseAndJumpToSecondNext = wealth[currentHouse] + findMaxStealHelper(wealth, currentHouse - 2);
        int skipCurrentHouseAndJumpToNext = findMaxStealHelper(wealth, currentHouse - 1);

        return Math.max(skipCurrentHouseAndJumpToNext, stealFromCurrentHouseAndJumpToSecondNext);
    }

    // Second Way using Dynamic Programming With Memoization
    public static int findMaxStealMemoization(int[] wealth) {
        int[] dp = new int[wealth.length];
        return findMaxStealHelper(wealth, wealth.length - 1, dp);
    }

    private static int findMaxStealHelper(int[] wealth, int currentHouse, int[] dp) {
        if (currentHouse == 0)
            return wealth[currentHouse];
        if (currentHouse < 0)
            return 0;

        if (dp[currentHouse] != 0)
            return dp[currentHouse];
        int stealFromCurrentHouseAndJumpToSecondNext = wealth[currentHouse] + findMaxStealHelper(wealth, currentHouse - 2, dp);
        int skipCurrentHouseAndJumpToNext = findMaxStealHelper(wealth, currentHouse - 1, dp);

        return dp[currentHouse] = Math.max(skipCurrentHouseAndJumpToNext, stealFromCurrentHouseAndJumpToSecondNext);
    }

    // Third Way using Dynamic Programming With Tabulation
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    Memory Usage: 41.6 MB, less than 47.45% of Java online submissions for House Robber.
     */
    public static int findMaxStealTabulation(int[] wealth) {
        int[] dp = new int[wealth.length];
        dp[0] = wealth[0];
        int currentHouse = 0;
        int nextHouse;
        for (int i = 1; i < wealth.length; i++) {
            currentHouse = wealth[i];
            if (i > 1)
                currentHouse += dp[i - 2];
            nextHouse = dp[i - 1];
            dp[i] = Math.max(currentHouse, nextHouse);
        }
        return dp[wealth.length - 1];
    }

    // Third Way using Space Optimization
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    Memory Usage: 41.7 MB, less than 31.00% of Java online submissions for House Robber.
     */
    public static int findMaxStealSpaceOptimization(int[] wealth) {
        if (wealth.length == 1)
            return wealth[0];

        int prev = wealth[0];
        int secondPrev = 0;
        int current = 0;

        for (int i = 1; i < wealth.length; i++) {
            int take = wealth[i];
            if (i > 1)
                take += secondPrev;

            int notTake = prev;
            current = Math.max(take, notTake);
            secondPrev = prev;
            prev = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSteal(new int[]{2, 5, 1, 3, 6, 2, 4})); // 15
        System.out.println(findMaxSteal(new int[]{2, 10, 14, 8, 1})); // 18
        System.out.println(findMaxSteal(new int[]{2, 1, 1, 2})); // 4
        System.out.println("Memoization");
        System.out.println(findMaxStealMemoization(new int[]{2, 5, 1, 3, 6, 2, 4})); // 15
        System.out.println(findMaxStealMemoization(new int[]{2, 10, 14, 8, 1})); // 18
        System.out.println(findMaxStealMemoization(new int[]{2, 1, 1, 2})); // 4
        System.out.println("Tabulation");
        System.out.println(findMaxStealTabulation(new int[]{2, 5, 1, 3, 6, 2, 4})); // 15
        System.out.println(findMaxStealTabulation(new int[]{2, 10, 14, 8, 1})); // 18
        System.out.println(findMaxStealTabulation(new int[]{2, 1, 1, 2})); // 4
        System.out.println("Space Optimization");
        System.out.println(findMaxStealSpaceOptimization(new int[]{2, 5, 1, 3, 6, 2, 4})); // 15
        System.out.println(findMaxStealSpaceOptimization(new int[]{2, 10, 14, 8, 1})); // 18
        System.out.println(findMaxStealSpaceOptimization(new int[]{2, 1, 1, 2})); // 4
    }

}
