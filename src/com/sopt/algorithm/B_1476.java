package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1476 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int correctE = Integer.valueOf(line[0]);
        int correctS = Integer.valueOf(line[1]);
        int correctM = Integer.valueOf(line[2]);
        int e = 1;
        int s = 1;
        int m = 1;

        //1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
        for (int i = 1; i <12000 ; i++) {
            if(e == correctE && s == correctS && m == correctM) {
                System.out.println(i);
                break;
            }

            e++;
            s++;
            m++;

            if(e > 15){
                e = 1;
            }
            if(s > 28) {
                s = 1;
            }
            if(m > 19){
                m = 1;
            }
        }


        //-1씩 해서, 0 ≤ E < 15, 0 ≤ S < 28, 0 ≤ M < 19 -> 중국인의 나머지 정리 이용해서 풀이 가능
        //x % 15 = e, x % 28 = s, x % 19 = m 을 만족하는 x를 구함

    }

}
