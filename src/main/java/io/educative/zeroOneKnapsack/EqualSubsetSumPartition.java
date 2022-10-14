package io.educative.zeroOneKnapsack;

public class EqualSubsetSumPartition {
        /*
    Runtime: 30 ms, faster than 94.44% of Java online submissions for Partition Equal Subset Sum.
    Memory Usage: 59.2 MB, less than 40.46% of Java online submissions for Partition Equal Subset Sum.
    */
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        if (totalSum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length + 1][(totalSum / 2) + 1];
        return canPartition(nums, totalSum / 2, 0, dp);
    }

    private boolean canPartition(int[] nums, int sum, int currentIndex, Boolean[][] dp) {
        if (sum == 0) return true;

        if (nums.length - 1 == currentIndex)
            return nums[currentIndex] == sum;

        if (dp[currentIndex][sum] != null)
            return dp[currentIndex][sum];

        if (nums[currentIndex] <= sum)
            if (canPartition(nums, sum - nums[currentIndex], currentIndex + 1, dp)) {
                dp[currentIndex][sum] = true;
                return true;
            }
        boolean canPartition = canPartition(nums, sum, currentIndex + 1, dp);
        dp[currentIndex][sum] = canPartition;
        return canPartition;
    }
}
