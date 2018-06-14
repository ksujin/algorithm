package com.sopt.algorithm;

import java.util.Scanner;

public class B_2490 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int result = 0;
            for (int j = 0; j < 4; j++) {
                result += scn.nextInt();
            }
            if(result == 4) {
                System.out.println("E");
            } else if(result == 3) {
                System.out.println("A");
            } else if(result == 2) {
                System.out.println("B");
            } else if(result == 1) {
                System.out.println("C");
            } else if(result == 0) {
                System.out.println("D");
            }

        }




    }
}
