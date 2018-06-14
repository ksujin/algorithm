/*package com.sopt.algorithm;

import java.util.Scanner;

import static java.lang.Float.max;

public class B_11048 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rowCount = scn.nextInt();
        int columCount = scn.nextInt();
        int[][] maze = new int[rowCount][columCount];
        int[][] dp = new int[rowCount][columCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columCount; j++) {
                maze[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columCount; j++) {
                int current = maze[i][j];

                if (i == 0 && j == 0) {
                    dp[i][j] = current;
                } else if (i == 0) {
                    dp[i][j] = current + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = current + dp[i - 1][j];
                } else {
                dp[i][j] = (int) (current + max(dp[i - 1][j], dp[i][j - 1]));
                }

            }
        }

        System.out.println(dp[rowCount-1][columCount-1]);
    }
}
*/