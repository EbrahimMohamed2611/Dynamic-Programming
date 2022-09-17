package io.educative.zeroOneKnapsack;

import java.util.Arrays;

public class SubSetSum {

    // BruteForce From start to end
    public static boolean isSubSetEqualTarget(int[] arr, int target) {
        return isSubSetEqualTarget(0, arr, target);
    }

    private static boolean isSubSetEqualTarget(int index, int[] arr, int target) {
        if (target == 0) return true;

        if (index == arr.length - 1)
            return target == arr[arr.length - 1];

        // First will take the current element
        boolean isTakeValid = false;
        if (target >= arr[index])
            isTakeValid = isSubSetEqualTarget(index + 1, arr, target - arr[index]);
        // Then will skip it and take the next
        boolean isNotTakeValid = isSubSetEqualTarget(index + 1, arr, target);


        return isTakeValid || isNotTakeValid;
    }

    // BruteForce From end to start
    public static boolean isSubSetEqualTargetFromEndToStart(int[] arr, int target) {
        return isSubSetEqualTargetHelper(arr.length - 1, arr, target);
    }

    private static boolean isSubSetEqualTargetHelper(int index, int[] arr, int target) {
        if (target == 0) return true;
        if (index == 0)
            return target == arr[0];


        // First will take the current element
        boolean isTakeValid = false;
        if (target >= arr[index])
            isTakeValid = isSubSetEqualTargetHelper(index - 1, arr, target - arr[index]);
        // Then will skip it and take the next
        boolean isNotTakeValid = isSubSetEqualTargetHelper(index - 1, arr, target);


        return isTakeValid || isNotTakeValid;
    }


    // BruteForce From end to start
    public static boolean isSubSetEqualTargetFromEndToStartUsingDP(int[] arr, int target) {
        int[][] dp = new int[arr.length][target+1];
        return isSubSetEqualTargetHelperUsingDP(arr.length - 1, arr, target, dp);
    }

    private static boolean isSubSetEqualTargetHelperUsingDP(int index, int[] arr, int target, int[][] dp) {
        if (target == 0) return true;
        if (index == 0)
            return target == arr[0];

        if (dp[index][target] != 0) {
            if (dp[index][target] == 1) return true;
            else
                return false;
        }
        // First will take the current element
        boolean isTakeValid = false;
        if (target >= arr[index])
            isTakeValid = isSubSetEqualTargetHelperUsingDP(index - 1, arr, target - arr[index], dp);
        // Then will skip it and take the next
        boolean isNotTakeValid = isSubSetEqualTargetHelperUsingDP(index - 1, arr, target, dp);
        // 1 means true and 2 means false
        dp[index][target] = (isTakeValid || isNotTakeValid) ? 1 : 2;
        return isTakeValid || isNotTakeValid;
    }

    public static void main(String[] args) {
        System.out.println(isSubSetEqualTarget(new int[]{1, 2, 3, 7}, 6)); // true
        System.out.println(isSubSetEqualTarget(new int[]{1, 2, 7, 1, 5}, 10)); // true;
        System.out.println(isSubSetEqualTarget(new int[]{1, 3, 4, 8}, 6)); // false
        System.out.println();
        System.out.println(isSubSetEqualTargetFromEndToStart(new int[]{1, 2, 3, 7}, 6)); // true
        System.out.println(isSubSetEqualTargetFromEndToStart(new int[]{1, 2, 7, 1, 5}, 10)); // true;
        System.out.println(isSubSetEqualTargetFromEndToStart(new int[]{1, 3, 4, 8}, 6)); // false
        System.out.println();
        System.out.println(isSubSetEqualTargetFromEndToStartUsingDP(new int[]{1, 2, 3, 7}, 6)); // true
        System.out.println(isSubSetEqualTargetFromEndToStartUsingDP(new int[]{1, 2, 7, 1, 5}, 10)); // true;
        System.out.println(isSubSetEqualTargetFromEndToStartUsingDP(new int[]{1, 3, 4, 8}, 6)); // false
    }

}
