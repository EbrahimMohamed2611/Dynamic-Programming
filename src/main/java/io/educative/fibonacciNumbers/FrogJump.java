package io.educative.fibonacciNumbers;

public class FrogJump {

    // (1) First Way Using BruteForce
    public static int frogJump(int n, int[] heights) {
        return frogJumpHelper(n - 1, heights);
    }

    private static int frogJumpHelper(int n, int[] heights) {
        if (n == 0) return 0;
        int oneJump = frogJumpHelper(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int twoJump = Integer.MAX_VALUE;
        if (n > 1) {
            twoJump = frogJumpHelper(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return Math.min(oneJump, twoJump);
    }


    public static int frogJump2(int n, int[] heights) {
        return frogJumpHelper2(0, n, heights);
    }

    private static int frogJumpHelper2(int index, int n, int[] heights) {
        if (n - 1 == index) return 0;
        int oneJump = frogJumpHelper2(index + 1, n, heights) + Math.abs(heights[index] - heights[index + 1]);
        int twoJump = Integer.MAX_VALUE;
        if (index < n - 2) {
            twoJump = frogJumpHelper2(index + 2, n, heights) + Math.abs(heights[index] - heights[index + 2]);
        }
        return Math.min(oneJump, twoJump);
    }

    // (2) Second Using Memoization
    public static int frogJumpMemo(int n, int[] heights) {
        int[] dp = new int[n];
        return frogJumpHelperWithMemo(n - 1, heights, dp);
    }

    private static int frogJumpHelperWithMemo(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;
        int oneJump = frogJumpHelperWithMemo(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        if (dp[n] != 0)
            return dp[n];
        int twoJump = Integer.MAX_VALUE;
        if (n > 1) {
            twoJump = frogJumpHelperWithMemo(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        return dp[n] = Math.min(oneJump, twoJump);
    }

    //(3) Third Using Tabulation
    public static int frogJumpTabulation(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        int oneJump, twoJump = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            oneJump = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1)
                twoJump = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(oneJump, twoJump);
        }
        return dp[n - 1];
    }

    //(4) Third Using Tabulation
    public static int frogJumpSpaceOptimization(int n, int[] heights) {
        int prevStep = 0;
        int secondPrevStep = 0;
        int current = 0;
        int oneJump, twoJump = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            oneJump = prevStep + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1)
                twoJump = secondPrevStep + Math.abs(heights[i] - heights[i - 2]);

            current = Math.min(oneJump, twoJump);
            secondPrevStep = prevStep;
            prevStep = current;
        }
        return current;
    }


    public static void main(String[] args) {
        System.out.println("BruteForce......");
        System.out.println(frogJump(6, new int[]{30, 10, 60, 10, 60, 50})); // 40
        System.out.println(frogJump(4, new int[]{10, 20, 30, 10})); // 20

        System.out.println("Memoization......");
        System.out.println(frogJumpMemo(6, new int[]{30, 10, 60, 10, 60, 50})); // 40
        System.out.println(frogJumpMemo(4, new int[]{10, 20, 30, 10})); // 20

        System.out.println(frogJump2(6, new int[]{30, 10, 60, 10, 60, 50})); // 40
        System.out.println(frogJump2(4, new int[]{10, 20, 30, 10})); // 20

        System.out.println("Tabulation......");
        System.out.println(frogJumpTabulation(6, new int[]{30, 10, 60, 10, 60, 50})); // 40
        System.out.println(frogJumpTabulation(4, new int[]{10, 20, 30, 10})); // 20

        System.out.println("SpaceOptimization......");
        System.out.println(frogJumpSpaceOptimization(6, new int[]{30, 10, 60, 10, 60, 50})); // 40
        System.out.println(frogJumpSpaceOptimization(4, new int[]{10, 20, 30, 10})); // 20
    }


}
