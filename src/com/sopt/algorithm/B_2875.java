package com.sopt.algorithm;

import java.util.Scanner;


public class B_2875 {

    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);


        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();


        int total = n+m;
        int n2 = n/2;

        int maxTeam = Math.min(n2, m);

        while ((total-maxTeam*3)<k){
            maxTeam--;
        }


        System.out.println(maxTeam);
    }
}
