package io.educative.zeroOneKnapsack;

public class CountOfSubsetSum {
    public int countSubsets(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];
        return countSubsets(0, nums, sum, dp);
    }

    private int countSubsets(int index, int[] nums, int sum, int[][] dp) {
        if (sum == 0) return 1;
        if (index == nums.length - 1)
            return (sum == nums[index]) ? 1 : 0;
        if (dp[index][sum] != 0)
            return dp[index][sum];
        int firstSub = 0;
        if (sum >= nums[index])
            firstSub = countSubsets(index + 1, nums, sum - nums[index], dp);
        int secondSub = countSubsets(index + 1, nums, sum, dp);
        return dp[index][sum] = firstSub + secondSub;
    }

    public static void main(String[] args) {
        // {1, 2, 7, 1, 5}, S=9
        CountOfSubsetSum countOfSubsetSum = new CountOfSubsetSum();
        System.out.println(countOfSubsetSum.countSubsets(new int[]{1, 1, 2, 3}, 4)); // 3
        System.out.println(countOfSubsetSum.countSubsets(new int[]{1, 2, 3, 3}, 6)); // 3
        System.out.println(countOfSubsetSum.countSubsets(new int[]{1, 2, 7, 1, 5}, 9)); // 3
    }
}
