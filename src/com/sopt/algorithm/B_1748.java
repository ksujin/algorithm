package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class B_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int inputNumber = Integer.parseInt( br.readLine() );

        int result = 0;

        for (int i = 1; i <= inputNumber; i++) {
            int tempInput = i;

            //자리수
            int temp = 0;
            while (tempInput != 0){
                tempInput = tempInput / 10;
                temp++;
            }
            result += temp;
           // System.out.println("i가 " + i+"일때 result = " + result + "이고 자리수는 : " + temp);

        }

        System.out.println(result);
        br.close();
    }
}
