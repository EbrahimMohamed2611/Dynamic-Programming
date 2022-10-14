package io.educative.zeroOneKnapsack;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static int findTargetSubsets(int[] nums, int target) {
//        int[] numberOfWays = new int[1];
        return findTargetSubsets(0, nums, target, 0);
//        return numberOfWays[0];
    }

    private static int findTargetSubsets(int index, int[] nums, int target, int sum) {
        // (index == nums.length) we need this sebaceous we need to take last element also
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else
                return 0;
        }

        int first = findTargetSubsets(index + 1, nums, target, sum + nums[index]);
        int second = findTargetSubsets(index + 1, nums, target, sum - nums[index]);
        return first + second;

    }

    /*
Runtime: 250 ms, faster than 46.15% of Java online submissions for Target Sum.
Memory Usage: 43.4 MB, less than 48.96% of Java online submissions for Target Sum.
*/
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return findTargetSubsets(0, nums, target, 0, cache);

    }

    private static int findTargetSubsets(int index, int[] nums, int target, int sum, Map<String, Integer> cache) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else
                return 0;
        }
        if (cache.containsKey(index + "+" + sum))
            return cache.get(index + "+" + sum);
        int first = findTargetSubsets(index + 1, nums, target, sum + nums[index], cache);
        int second = findTargetSubsets(index + 1, nums, target, sum - nums[index], cache);
        cache.put(index + "+" + sum, first + second);

        return first + second;

    }
    public static void main(String[] args) {
        /*
        Input: {1, 1, 2, 3}, S=1
        Output: 3
         */
        System.out.println(findTargetSubsets(new int[]{1, 1, 2, 3}, 1));
    }
}
