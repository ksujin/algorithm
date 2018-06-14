/*package com.sopt.algorithm;

import java.util.Scanner;


public class B_11057 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputCount = scn.nextInt();
        int modNum = 10007;

        int[][] dp = new int[inputCount+1][10];

        //dp[i][j]라면 i는 주어지는 길이, j는 시작하는 숫자
        //길이가 1이면 무조건 오르막 개수는 무조건 1
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        //길이가 2일때부터 inputCount 일때까지
        for (int i = 2; i <= inputCount; i++) {
            //위의 길이에서 9로 시작할때 8으로 시작할때 7로 시작할때,,,0으로 시작할때 오르막 경우의 수
            for (int j = 9; j >= 0 ; j--) {
                //만약 9로 시작한다면 그때 경우의수는 1
               if (j==9){
                   dp[i][j] = 1;
               } else {
                   //dp[i][j] 즉 i 길이의 j로 시작하는 오르막 경우의 수는
                   //i-1 길이의 j로 시작하는 오르막 경우의 수 + i 길이의 j+1로 시작하는 오르막 경우의 수
                   dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % modNum;
               }
            }
        }

        int maxNum = 0;
        for (int i = 0; i < 10; i++) {
            maxNum = (maxNum + dp[inputCount][i]) % modNum;
        }
        System.out.println(maxNum);

    }
}
*/