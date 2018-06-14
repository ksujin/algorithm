/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_2293 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // 0 <= coinTypeCount <= 100
        int coinTypeCount = scn.nextInt();
        int totalMoney = scn.nextInt();
        int coinType[] = new int[coinTypeCount+1];
        int dp[] = new int[totalMoney+1];

        for (int i = 0; i < coinTypeCount; i++) {
            //coinType 이 들어감. 1,2,5
            coinType[i] = scn.nextInt();
        }


        dp[0] = 1;
        //코인이 1일때 2일때 5일때 순회
        for (int i = 0; i < coinTypeCount ; i++) {
            //돈을 주어진 것까지 돌면서 현재 제공된 coin 으로 몇가지 경우가 가능한가 판단
            //1원일때 현재 주어진 돈으로 몇가지 경우의 수가 가능한가.
            for (int j = 1; j <= totalMoney ; j++) {
                //현재 구하고자하는 돈이 코인 타입보다 커야 가능
                if(coinType[i] <= j){
                    dp[j] = dp[j] + dp[j-coinType[i]];
                }
            }
        }

        System.out.println(dp[totalMoney]);


    }
}*/
