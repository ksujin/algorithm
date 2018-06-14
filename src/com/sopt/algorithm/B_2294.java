/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_2294 {
    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // 0 <= coinTypeCount <= 100
    int coinTypeCount = scn.nextInt();
    int totalMoney = scn.nextInt();
    int coinType[] = new int[coinTypeCount+1];
    int dp[] = new int[totalMoney+1];

    for (int i = 0; i < coinTypeCount; i++) {
        //coinType 이 들어감. 1,5,12
        coinType[i] = scn.nextInt();

    }


    int max = 100001;
  //  int min = max;
    //15일때 1,5,12가 있다고 할때 dp[3], dp[10], dp[14] 따져서 min 값 구함
    dp[0] = 0;
    //코인이 1일때 5일때 12일때 순회

        for (int i = 1; i <= totalMoney ; i++) {
            dp[i] = max; //dp[1], dp[2], ... dp[15]  = 100001
            for (int j = 0; j < coinTypeCount; j++) {
               // System.out.println("j = " + j);
               // System.out.println("coinType[j] = " + coinType[j]);
               // System.out.println("dp[i-coinType[j]] = " + dp[i-coinType[j]]);
                if(i >= coinType[j] && dp[i-coinType[j]] != max) {
                    dp[i] = Math.min(dp[i], dp[i - coinType[j]] + 1);

                }
            }
        }

    if(dp[totalMoney] == max){
        System.out.println(-1);
    } else{
        System.out.println(dp[totalMoney]);
    }




}
}*/
