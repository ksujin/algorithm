package com.sopt.algorithm;

import java.util.Scanner;

//9465 스티커
public class B_9565 {
    static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){

        int testCase = scn.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = scn.nextInt();
            new B_9565().solve(n);
        }
    }

    void solve(int n){
        //dp[n][l] => n 행 일때 (0/1) l 열에서 나올 수 있는 최대 값
        //dp[n][l] = a[n][l] + max(dp[원래 n과 다른 값][l-1],dp[원래 n과 다른 값][l-2])
        int dp[][] = new int[2][n+1];
        int a[][] = new int[2][n+1];

        for (int i = 0; i < 2; i++) {

            for (int j = 1; j <= n ; j++) {
                a[i][j] = scn.nextInt();
            }
        }

        dp[0][1] = a[0][1];
        dp[1][1] = a[1][1];

        for (int i = 2; i <= n ; i++) {
            dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1])+a[0][i];
            dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1])+a[1][i];
        }

        System.out.println(Math.max(dp[0][n], dp[1][n]));

    }
}
