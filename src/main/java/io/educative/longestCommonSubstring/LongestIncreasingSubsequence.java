package io.educative.longestCommonSubstring;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    // O(N^2)
    public static int lisTabulation(final List<Integer> nums) {
        int maxLength = 1;
        int size = nums.size();
        int[] dp = new int[size];
        dp[0] = 1;
        for (int current = 1; current < size; current++) {
            dp[current] =1;
            for (int prev = 0; prev < current; prev++) { // take the largest LIS in the prev and add it to the current if it met the condition
                if(nums.get(prev) < nums.get(current)){
                    dp[current] = Math.max(dp[current], dp[prev]+1); // will add the prev +1 because the current will increase with itself
                    maxLength = Math.max(maxLength,dp[current]);
                }
            }
        }
        return maxLength;
    }

    public int lis(final List<Integer> A) {
        int size = A.size();
        int[][] dp = new int[size][size];
        return lengthOfLIS(-1,0,A, dp);
    }

    private int lengthOfLIS(int prev, int current, List<Integer> A,  int[][] dp){
        if(current == A.size())
            return 0;
        if(dp[prev+1][current] != 0)
            return dp[prev+1][current];
        // first not take the current Element
        int notTake = lengthOfLIS(prev, current+1, A, dp);
        // second with take the current element
        int take = 0;
        if(prev == -1 || A.get(prev) < A.get(current))
            take = 1 + lengthOfLIS(current, current+1, A, dp);

        return dp[prev+1][current] = Math.max(notTake, take);
    }

    public static void main(String[] args) {
        System.out.println(lisTabulation(Arrays.asList(84, 80, 27)));
    }
}
