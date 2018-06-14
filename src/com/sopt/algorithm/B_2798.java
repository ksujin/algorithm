package com.sopt.algorithm;

import java.util.Scanner;

public class B_2798 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //카드 개수
        int n = scn.nextInt();
        //딜러가 부른 숫자. 이 숫자 넘지 않아야함
        int m = scn.nextInt();
        int maxNum = -1;
        int cardArray[] = new int[n];

        for (int i = 0; i < n; i++) {
            cardArray[i] = scn.nextInt();
        }
        //m넘지 않으면서 m과 가장 가까운 것
        for (int i = 0; i < n; i++) {
            int firstCard = cardArray[i];
            for (int j = i+1; j < n; j++) {
                int secondCard = cardArray[j];
                for (int k = j+1; k < n; k++) {
                    int thirdCard = cardArray[k];
                    int sum = firstCard + secondCard + thirdCard;
                    if (sum > maxNum && sum <= m){
                        maxNum = sum;
                    }
                }
            }
        }

        System.out.println(maxNum);


    }
}
