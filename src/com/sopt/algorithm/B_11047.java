package com.sopt.algorithm;

import java.util.Scanner;

public class B_11047 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int coins[] = new int[n+1];

        for (int i = 1; i <= n; i++) {
            coins[i] = scn.nextInt();
        }

        //1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수) 이 조건 때문에 그리디 적용 가능
        int ans = 0;
        for (int i = n; i > 0 ; i--) {
            //큰 동전부터 쓸 때 몇개 사용해야하는가 구하면서 더해줌
            ans += k / coins[i];
            //큰 동전들을 쓰고 남은 나머지 값
            k = k % coins[i];

        }
        System.out.println(ans);
    }
}
