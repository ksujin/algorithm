package com.sopt.algorithm;

import java.util.Scanner;

public class B_1453 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  inputCount = scn.nextInt();
        int seatArray[] = new int[101];
        int rejectCount = 0;
        for (int i = 0; i < inputCount; i++) {
            int seatNum = scn.nextInt();
            if(seatArray[seatNum] == 0){
                seatArray[seatNum] = 1;
            } else  {
                rejectCount++;
            }
        }
        System.out.println(rejectCount);
    }
}
