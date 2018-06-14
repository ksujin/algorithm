package com.sopt.algorithm;

import java.util.Scanner;

public class B_2609 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  firstNum = scn.nextInt();
        int  secondNum = scn.nextInt();

        int firstTemp = Math.max(firstNum,secondNum);
        int secondTemp = Math.min(firstNum,secondNum);

        int greatNum = gcd(firstTemp, secondTemp);
        int minNum = firstNum*secondNum/greatNum;

        System.out.println(greatNum);
        System.out.println(minNum);



    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
