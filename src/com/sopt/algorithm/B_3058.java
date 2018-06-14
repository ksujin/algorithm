package com.sopt.algorithm;


import java.util.Scanner;

public class B_3058 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  inputCount = scn.nextInt();
        int inputArray[] = new int[8];
        for (int i = 0; i < inputCount ; i++) {
            //코드 시작
            int sumResult = 0;
            int min = 101;
            for (int j = 0; j < 7 ; j++) {
                inputArray[j] = scn.nextInt();
                if(inputArray[j] % 2 == 0){
                    sumResult += inputArray[j];
                    min = Math.min(min, inputArray[j]);
                }

            }
            System.out.println(sumResult+" "+min);
        }
    }
}
