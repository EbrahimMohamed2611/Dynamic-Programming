package io.educative.fibonacciNumbers;

// 3 Jump
public class ClimbingStairs {

    // First Way using bruteForce
    public static int countWays(int stairs) {
        if (stairs < 0)
            return 0;
        if (stairs == 0 || stairs == 1)
            return 1;

        int oneJump = countWays(stairs - 1);
        int twoJump = countWays(stairs - 2);
        int threeJump = countWays(stairs - 3);

        return oneJump + twoJump + threeJump;
    }


    // Second Way using DP Memoization
    public static int countWaysMemoization(int stairs) {
        int[] dp = new int[stairs + 1];
        return countWays(stairs, dp);
    }

    private static int countWays(int stairs, int[] dp) {
        if (stairs < 0)
            return 0;
        if (stairs == 0 || stairs == 1)
            return 1;

        if (dp[stairs] != 0)
            return dp[stairs];
        int oneJump = countWays(stairs - 1, dp);
        int twoJump = countWays(stairs - 2, dp);
        int threeJump = countWays(stairs - 3, dp);
        return dp[stairs] = oneJump + twoJump + threeJump;
    }

    // Third Way using DP Tabulation
    public static int countWaysTabulation(int stairs) {
        if (stairs == 0 || stairs == 1) return 1;
        if (stairs == 2) return 2;
        int[] dp = new int[stairs + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[stairs];
    }


    // Third Way using Space Optimization
    public static int countWaysSpaceOptimization(int stairs) {
        if (stairs == 0 || stairs == 1) return 1;
        if (stairs == 2) return 2;

        int firstPrev =2;
        int secondPrev =1;
        int thirdPrev =1;
        int current = 0;
        for (int i = 3; i <= stairs; i++) {
            current = firstPrev + secondPrev + thirdPrev;
            thirdPrev = secondPrev;
            secondPrev = firstPrev;
            firstPrev = current;
        }
        return current;
    }


    // First Way using bruteForce
//    public static int countWaysUsingLoop(int stairs, int k) {
//        if (stairs == 0 || stairs == 1)
//            return 1;
//        if (stairs == 2)
//            return 2;
//        int sum = 0;
//        for (int i = 1; i <= k; i++) {
//            sum += countWays(stairs - i);
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        System.out.println("BruteForce");
        System.out.println(countWays(3)); // 4
        System.out.println(countWays(4)); // 7
        System.out.println(countWays(10)); // 274
//        System.out.println(countWaysUsingLoop(3,3)); // 4
//        System.out.println(countWaysUsingLoop(4,4)); // 7
//        System.out.println(countWaysUsingLoop(10,10)); // 274

        System.out.println("DP using Memoization");
        System.out.println(countWaysMemoization(3)); // 4
        System.out.println(countWaysMemoization(4)); // 7
        System.out.println(countWaysMemoization(10)); // 274

        System.out.println("DP using Tabulation");
        System.out.println(countWaysTabulation(3)); // 4
        System.out.println(countWaysTabulation(4)); // 7
        System.out.println(countWaysTabulation(10)); // 274

        System.out.println("DP using Space Optimization");
        System.out.println(countWaysSpaceOptimization(3)); // 4
        System.out.println(countWaysSpaceOptimization(4)); // 7
        System.out.println(countWaysSpaceOptimization(10)); // 274
    }

}
