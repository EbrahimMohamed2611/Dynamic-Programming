package io.educative.zeroOneKnapsack;

import java.util.*;

public class ZeroOnKnapsack {
    public static int solveKnapsackMemo(int[] profits, int[] weights, int capacity) {
        Map<String, Integer> cache = new HashMap<>();
        //Also we can use the array
       // int[][]dp = new int[profits.length][capacity+1];
        return solveKnapsackMemo(0, profits, weights, capacity, cache);
    }

    private static int solveKnapsackMemo(int currentIndex, int[] profits, int[] weights, int capacity, Map<String, Integer> cache) {
        if (currentIndex == profits.length - 1)
            if (weights[currentIndex] <= capacity)
                return profits[currentIndex];
            else
                return 0;
        if (cache.containsKey(currentIndex + "" + capacity))
            return cache.get(currentIndex + "" + capacity);
        //first: I'll take the current item based on condition
        int firstProfit = 0;
        if (weights[currentIndex] <= capacity)
            firstProfit = profits[currentIndex] + solveKnapsackMemo(currentIndex + 1, profits, weights, capacity - weights[currentIndex], cache);

        //then: I'll not take it
        int secondProfit = solveKnapsackMemo(currentIndex + 1, profits, weights, capacity, cache);
        int currentMaxProfit = Math.max(firstProfit, secondProfit);
        cache.put(currentIndex + "" + capacity, currentMaxProfit);
        // return dp[currentIndex][capacity] = Math.max(firstProfit, secondProfit);
        System.out.println();
        return currentMaxProfit;
    }


    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return solveKnapsack(0, profits, weights, capacity);
    }

    private static int solveKnapsack(int currentIndex, int[] profits, int[] weights, int capacity) {
        if (currentIndex == profits.length - 1)
            if (weights[currentIndex] <= capacity)
                return profits[currentIndex];
            else
                return 0;

        //first: I'll take the current item based on condition
        int firstProfit = 0;
        if (weights[currentIndex] <= capacity)
            firstProfit = profits[currentIndex] + solveKnapsack(currentIndex + 1, profits, weights, capacity - weights[currentIndex]);

        //then: I'll not take it
        int secondProfit = solveKnapsack(currentIndex + 1, profits, weights, capacity);

        return Math.max(firstProfit, secondProfit);
    }


    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;

        int[] profits2 = {4, 5, 3, 7};
        int[] weights2 = {2, 3, 1, 4};
        int capacity2 = 5;
        System.out.println(solveKnapsack(profits, weights, capacity)); //22
        System.out.println(solveKnapsack(profits2, weights2, capacity2)); //1
        System.out.println("Memoization");
        System.out.println(solveKnapsackMemo(profits, weights, capacity)); //22
        System.out.println(solveKnapsackMemo(profits2, weights2, capacity2)); //1
    }
}
