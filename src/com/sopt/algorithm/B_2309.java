package com.sopt.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B_2309 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int arr[] = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = scn.nextInt();
        } //input

        int ans[] = new int[7];
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 4; j++) {
                for (int k = j+1; k < 5; k++) {
                    for (int l = k+1; l < 6; l++) {
                        for (int m = l+1; m < 7 ; m++) {
                            for (int n = m+1; n < 8 ; n++) {
                                for (int o = n+1; o < 9; o++) {
                                    int total = arr[i] + arr[j] + arr[k] + arr[l] + arr[m] + arr[n] + arr[o];
                                    if(total == 100) {
                                        ans[0] = arr[i];
                                        ans[1] = arr[j];
                                        ans[2] = arr[k];
                                        ans[3] = arr[l];
                                        ans[4] = arr[m];
                                        ans[5] = arr[n];
                                        ans[6] = arr[o];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } //for i

        Arrays.sort(ans);

        for (int i = 0; i < 7; i++) {
            System.out.println(ans[i]);
        }



    }
}
