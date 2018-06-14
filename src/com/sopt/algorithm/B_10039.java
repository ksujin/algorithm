package com.sopt.algorithm;

import java.util.Scanner;

public class B_10039 {


        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int result = 0;
            for (int i = 0; i < 5; i++) {
                int score = scn.nextInt();
                if(score < 40){
                    result += 40;
                } else  {
                    result += score;
                }
            }

            System.out.println(result/5);

        }

}
