package io.educative.longestCommonSubstring;

public class LongestCommonSubstring {

    public static int findLCSLength(String s1, String s2) {


        return findLCSLengthRecursive(s1, s2, 0, 0, 0);
    }

    private static int findLCSLengthRecursive(String s1, String s2, int index1, int index2, int maxLength) {
        if (index1 == s1.length() || index2 == s2.length())
            return maxLength;

        if (s1.charAt(index1) == s2.charAt(index2)) {
            maxLength = findLCSLengthRecursive(s1, s2, index1 + 1, index2 + 1, maxLength + 1);
        }

        int skipFirst = findLCSLengthRecursive(s1, s2, index1, index2 + 1, 0); // when mismatch will start with 0 again because we need consecutive string
        int skipSecond = findLCSLengthRecursive(s1, s2, index1 + 1, index2, 0);
        return Math.max(maxLength, Math.max(skipFirst, skipSecond));
    }

    /*
    Using Tabulation the best method
     */
    public static int findLCSLengthUsingTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // else will set it with 0 but zero the default value
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLCSLength("passport", "ppsspt"));
        System.out.println(findLCSLengthUsingTabulation("passport", "ppsspt"));
    }
}
