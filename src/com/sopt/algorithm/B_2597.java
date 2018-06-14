package com.sopt.algorithm;


import java.util.Scanner;

public class B_2597 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int sum = 0;
        int inputArray[] = new int[10];


        for (int i = 0; i < 10; i++) {
            int inputNum = scn.nextInt();

            inputArray[i] = inputNum;
            sum += inputNum;

        }

        int maxCount = 0;
        int maxNum  = 0;
        for (int i = 0; i < 10; i++) {
            int tempNum = inputArray[i];
            int tempCount = 0;
            for (int j = 0; j < 10; j++) {
                if(tempNum == inputArray[j]){
                    tempCount++;
                }
            }
            if (tempCount > maxCount){
                maxCount = tempCount;
                maxNum = tempNum;
            }
        }

        System.out.println(sum / 10);
        System.out.println(maxNum);



    }
}
