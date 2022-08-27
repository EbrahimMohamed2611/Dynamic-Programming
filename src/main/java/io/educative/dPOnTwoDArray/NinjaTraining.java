package io.educative.dPOnTwoDArray;

/*
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities.
(Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day.
 As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days.
 Can you help Ninja find out the maximum merit points Ninja can earn?
You are given a 2D array of size N*3  ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate
    the maximum number of merit points that Ninja can earn.
 */
public class NinjaTraining {
    //  [Amazon]
    public static int ninjaTraining(int days, int[][] points) {
        return ninjaTraining(days - 1, points, 3);

    }

    private static int ninjaTraining(int day, int[][] points, int lastTask) {
        if (day == 0) // Last Day
        {
            int maxPointsCanTaken = 0;
            for (int task = 0; task < points[0].length; task++)
                if (task != lastTask)
                    maxPointsCanTaken = Math.max(maxPointsCanTaken, points[day][task]);
            return maxPointsCanTaken;
        }

        int maxPoint = 0;
        for (int task = 0; task < points[0].length; task++)
            if (lastTask != task)
                maxPoint = Math.max(maxPoint, points[day][task] + ninjaTraining(day - 1, points, task));

        return maxPoint;
    }


    public static int ninjaTrainingMemoization(int days, int[][] points) {
        int[][] dp = new int[points.length + 1][4];
        return ninjaTrainingMemoization(days - 1, points, 3, dp);

    }

    private static int ninjaTrainingMemoization(int day, int[][] points, int lastTask, int[][] dp) {
        if (day == 0) // Last Day
        {
            int maxPointsCanTaken = 0;
            for (int task = 0; task < points[0].length; task++)
                if (task != lastTask)
                    maxPointsCanTaken = Math.max(maxPointsCanTaken, points[day][task]);
            return dp[day][lastTask] = maxPointsCanTaken;
        }
        if (dp[day][lastTask] != 0)
            return dp[day][lastTask];
        int maxPoint = 0;
        for (int task = 0; task < points[0].length; task++)
            if (lastTask != task)
                maxPoint = Math.max(maxPoint, points[day][task] + ninjaTrainingMemoization(day - 1, points, task, dp));

        return dp[day][lastTask] = maxPoint;
    }

    public static void main(String[] args) {

        System.out.println(ninjaTraining(3, new int[][]{
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        }));    // 11
        System.out.println(ninjaTraining(3, new int[][]{
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        }));    // 210
        System.out.println("Memoization");

        System.out.println(ninjaTrainingMemoization(3, new int[][]{
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        }));    // 11
        System.out.println(ninjaTrainingMemoization(3, new int[][]{
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        }));    // 210


    }
}
