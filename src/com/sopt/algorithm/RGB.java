package com.sopt.algorithm;/*package com.sopt.algorithm;

import java.util.Scanner;

public class RGB {
    public static void main(String[] args){

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); //집 갯수
    int d[][] = new int[n + 1][3];
    int a[][] = new int[n + 1][3];
		
		for(
    int i = 1;
    i <=n;i++)

    {
        for (int j = 0; j < 3; j++) {
            a[i][j] = scn.nextInt();
        }
    }

    d[0][0]=d[0][1]=d[0][2]=a[0][0]=a[0][1]=a[0][2]=0;
		
		for(
    int i = 1;
    i <=n;i++)

    {
        d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
        d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
        d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
    }
		
		System.out.println(Math.min(d[n][2],Math.min(d[n][0],d[n][1])));
}

}*/
