package com.sopt.algorithm;

import java.util.Scanner;

//쉬운 계단 수 (dp)
//N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)
public class B_10844 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        new B_10844().solve(n);
    }

    void solve(int n) {
        //dp[n][l] 은 길이가 n 일때 마지막 수가 l 인 계단수
        //dp[n][l] = dp[n-1][l-1] + dp[n-1][l+1]
        //이때 l 이 0일때와 9일때는 제외
        // if l == 0 => dp[n][l] = dp[n-1][l+1]
        // if l == 9 => dp[n][l] = dp[n-1][l-1]
        long dp[][] = new long[101][11];
        long ans = 0;
        int MOD = 1000000000;

        //값 초기화
        for (int i = 1; i <= 9 ; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n ; i++) {
            dp[i][0] = dp[i-1][1];

            for (int j = 1; j <= 9 ; j++) {
                //어차피 dp[i][9] 일때 +1 을 한다 한들 초기값이 0으로 들어가있으니까 따로 처리 안해줘도 됨
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;

            }
        } //for i


        for (int i = 0; i <= 9; i++) {
            ans += dp[n][i] ;
        }
        //다 더한후에 모드 연산 해야함
        System.out.println(ans % MOD);

    }
}
