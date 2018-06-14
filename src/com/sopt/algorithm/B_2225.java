package com.sopt.algorithm;

import java.util.Scanner;

public class B_2225 {
    public static void main(String[] args) {
        //합분해
        //0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
        //1.그 상태의 값을 구하기위해서 그 전의 값들을 전부다 구해서 더하는 식으로 구할 수 있다.
        //2. 예를 들어 20을 3번의 합으로 구하는 경우의 수는 0~20을 두번의 합으로 만들 수 있는 경우의 수를 전부 더하면 되는 것이다.

        //dp[k][n] = Σ(DP[k-1][n-l])
        //0 <= L <= N

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int dp[][] = new int[k+2][n+2];

        //동전 1개 이용해서 n원 만드는 경우의 수 -> 모두 1
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }

        //동전 i개 이용해서
        for (int i = 2; i <= k ; i++) {
            //j원을 만들 수 있는데
            for (int j = 0; j <= n ; j++) {
                //마지막 값이 0으로 끝날때 부터 j로 끝날때 까지 경우의 수 모두 돌면서 더해주면
                //동전 i개 이용해서 j원 만들 수 있는 경우의 수가 dp[i][j]에 저장됨
                for (int l = 0; l <= j ; l++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-l])%1000000000;
                }
            }
        }
        System.out.println(dp[k][n] % 1000000000);

    }
}
