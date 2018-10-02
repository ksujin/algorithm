package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class line1 {

    public static void main(String[] args) throws IOException {

        int arr[] = new int[5001];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int myMoney = 20000;
        String[] line = bf.readLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.valueOf(line[i]);
        }

        for (int i = 0; i < line.length; i++) {
            int current = arr[i];
            if (current < 4 || current > 178) {
                System.out.println(myMoney);
                return;
            }

            if (current <= 40){
                int minus = 720;
                if (myMoney < minus){
                    System.out.println(myMoney);
                    return;
                } else {
                    myMoney -= minus;
                }
            } else {
                int minus = 720;
                //8키로마다 80원 추가
                current -= 40;
              //current 나머지 남아있음
                while (current - 8 >= 0){
                    minus += 80;
                    current -= 8;
                }

                if (current > 0) {
                    minus += 80;
                }

                if (myMoney < minus) {
                    System.out.println(myMoney);
                    return;
                } else {
                    myMoney -= minus;
                }
            } //else

        }

        System.out.println(myMoney);

    }
}
