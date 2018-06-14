package com.sopt.algorithm;

import java.util.Scanner;

public class B_5582 {

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        char[] A = new char[4001];
        char[] B = new char[4001];
        int[][] dp = new int[4001][4001];

        String tempA = scn.nextLine();
        String tempB = scn.nextLine();
        int aLength = tempA.length();
        int bLength = tempB.length();
        A = tempA.toCharArray();
        B = tempB.toCharArray();

        int max = 0;

        for (int i = 0; i < aLength ; i++) {
            for (int j = 0; j< bLength; j++) {

                if(A[i] == B[j]){
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }

                    max = max < dp[i][j] ? dp[i][j] : max;

                }
            }
        }

        System.out.println(max);


    }
}
