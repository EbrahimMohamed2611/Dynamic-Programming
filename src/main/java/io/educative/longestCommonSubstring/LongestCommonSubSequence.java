package io.educative.longestCommonSubstring;

public class LongestCommonSubSequence {

    // BruteForce
    public static int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    private static int longestCommonSubsequence(String text1, String text2, int index1, int index2) {
        if (index1 == text1.length() || index2 == text2.length())
            return 0;


        if (text1.charAt(index1) == text2.charAt(index2))
            return 1 + longestCommonSubsequence(text1, text2, index1 + 1, index2 + 1);

        int firstSkip = longestCommonSubsequence(text1, text2, index1 + 1, index2);

        int secondSkip = longestCommonSubsequence(text1, text2, index1, index2 + 1);

        return Math.max(firstSkip, secondSkip);
    }

    // Using Memoization DP
    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        return longestCommonSubsequence(text1, text2, 0, 0, dp);
    }

    private static int longestCommonSubsequence(String text1, String text2, int index1, int index2, int[][] dp) {
        if (index1 == text1.length() || index2 == text2.length())
            return 0;

        if (dp[index1][index2] != 0)
            return dp[index1][index2];
        int firstSkip, secondSkip;

        if (text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1 + longestCommonSubsequence(text1, text2, index1 + 1, index2 + 1, dp);
        else {
            firstSkip = longestCommonSubsequence(text1, text2, index1 + 1, index2, dp);
            secondSkip = longestCommonSubsequence(text1, text2, index1, index2 + 1, dp);
        }

        return dp[index1][index2] = Math.max(firstSkip, secondSkip);
    }

    // Using Tabulation DP
    /*
    Runtime: 15 ms, faster than 84.56% of Java online submissions for Longest Common Subsequence.
Memory Usage: 46 MB, less than 86.98% of Java online submissions for Longest Common Subsequence.
     */
    public static int longestCommonSubsequenceDPTabulation(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("acd", "ced"));
        System.out.println(longestCommonSubsequence("abcde", "ace")); //3

        System.out.println(longestCommonSubsequenceDP("acd", "ced"));
        System.out.println(longestCommonSubsequenceDP("abcde", "ace")); //3

        System.out.println(longestCommonSubsequenceDPTabulation("acd", "ced"));
        System.out.println(longestCommonSubsequenceDPTabulation("abcde", "ace")); //3
    }
}
