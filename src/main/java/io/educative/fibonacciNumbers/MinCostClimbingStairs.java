package io.educative.fibonacciNumbers;

public class MinCostClimbingStairs {

    // (1) First Way Using BruteForce
    public int minCostClimbingStairs1(int[] costs) {
        int n = costs.length;
        return Math.min(findMinCost1(n-1, costs),findMinCost1(n-2, costs));
    }

    private int findMinCost1(int n, int[] costs) {
        if(n == 0 || n == 1)
            return costs[n];
        int oneJump = findMinCost1(n-1,costs);
        int twoJump = findMinCost1(n-2, costs);
        return costs[n] + Math.min(oneJump, twoJump);
    }


    // (2) Second Way Using Dynamic Programming Memoization
    /*
    Runtime: 1 ms, faster than 89.83% of Java online submissions for Min Cost Climbing Stairs.
    Memory Usage: 41.8 MB, less than 94.61% of Java online submissions for Min Cost Climbing Stairs.
     */
    public int minCostClimbingStairs(int[] costs) {
        int n = costs.length;
        int[] dp = new int[n];
        return Math.min(findMinCost(n-1, costs, dp),findMinCost(n-2, costs,dp));
    }

    private int findMinCost(int n, int[] costs, int[] dp) {
        if(n == 0 || n == 1)
            return costs[n];
        if(dp[n] != 0)
            return dp[n];
        int oneJump = findMinCost(n-1,costs,dp);
        int twoJump = findMinCost(n-2, costs,dp);
        return dp[n] = costs[n] + Math.min(oneJump, twoJump);
    }


    // (3) Third way Using Tabulation
    /*
    Runtime: 1 ms, faster than 89.83% of Java online submissions for Min Cost Climbing Stairs.
    Memory Usage: 43.7 MB, less than 48.24% of Java online submissions for Min Cost Climbing Stairs.
     */
    public static int minCostClimbingStairsTabulation(int[] costs) {
        int n = costs.length;
        int[] dp = new int[n];
        dp[0] = costs[0];
        dp[1] = costs[1];
        int minCost = 0;
        for (int i = 2; i < n; i++) {
            minCost = Math.min(dp[i - 1], dp[i - 2]) + costs[i];
            dp[i] = minCost;
        }
        return  Math.min(dp[n - 1], dp[n - 2]);
    }

    // (4) Fourth way Using space Optimization

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Min Cost Climbing Stairs.
    Memory Usage: 41.8 MB, less than 96.70% of Java online submissions for Min Cost Climbing Stairs.
     */
    public static int minCostClimbingStairSpaceOptimization(int[] costs) {
        int n = costs.length;

        int prev = costs[1];
        int lastPrev = costs[0];
        int minCost = 0;
        for (int i = 2; i < n; i++) {
            minCost = Math.min(prev, lastPrev) + costs[i];
            lastPrev = prev;
            prev = minCost;
        }
        return Math.min(prev, lastPrev);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairsTabulation(new int[]{10,15,20})); // 15
        System.out.println(minCostClimbingStairSpaceOptimization(new int[]{10,15,20})); // 15
    }
}
