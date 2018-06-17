package com.sopt.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B_11399 {

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int peopleCount = scn.nextInt();
        int times[] = new int[peopleCount];
        int total = 0;
        int ans = 0;
        for (int i = 0; i < peopleCount; i++) {
            times[i] = scn.nextInt();
        }

        Arrays.sort(times);

        for (int i = 0; i < peopleCount; i++) {
            total = total + times[i];
            ans += total;

        }
       System.out.println(ans);


    }
}
