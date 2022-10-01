package io.educative.palindromicSubsequence;

public class PalindromePartitioning {


    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        return minCostRecursive(s, 0, dp) - 1;
    }

    private int minCostRecursive(String s, int index, int[] dp) {
        if (index == s.length()) return 0;
        if (dp[index] != 0)
            return dp[index];
        int minCost = Integer.MAX_VALUE;
        for (int start = index; start < s.length(); start++) {
            if (isPalindrome(s, index, start)) {
                int cost = 1 + minCostRecursive(s, start + 1, dp);
                minCost = Math.min(cost, minCost);
            }
        }

        return dp[index] = minCost;
    }


    public static int minCutTabulation(String s) {
        int size = s.length();
        int[] dp = new int[size + 1];
        dp[size] = 0;
        for (int index = size - 1; index >= 0; index--) {
            int minCost = Integer.MAX_VALUE;
            for (int start = index; start < size; start++) {
                if (isPalindrome(s, index, start)) {
                    int cost = 1 + dp[start + 1];
                    minCost = Math.min(cost, minCost);
                }
            }
            dp[index] = minCost;
        }
        return dp[0] - 1;
    }

    private static boolean isPalindrome(String string, int start, int end) {

        while (start < end) {
            if (string.charAt(start++) != string.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCutTabulation("aab")); //1
        System.out.println(minCutTabulation("ab")); //1
        System.out.println(minCutTabulation("a")); //0
    }

}
