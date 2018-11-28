package com.sopt.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B_5052 {
    static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){
        int testCase = scn.nextInt();
        for (int i = 0; i < testCase; i++) {
            solve();
        }
    }

    public static void solve(){
        int n = scn.nextInt();
        String phoneArr[] = new String[n];
        for (int i = 0; i < n; i++) {
            phoneArr[i] = scn.next();
        }
        Arrays.sort(phoneArr);
        System.out.println(Arrays.toString(phoneArr));
        //i가 i+1 에 포함되어있지 않으면 일관성 있음
        boolean flag = true; //일관성 없음
        for (int i = 0; i < n-1; i++) {
            int current = phoneArr[i].length();
            int next = phoneArr[i+1].length();

            if (current < next){
                int cnt = 0;
                for (int j = 0; j < current; j++) {
                    if(phoneArr[i].charAt(j) == phoneArr[i+1].charAt(j)){
                        cnt++;
                    } else {
                        break;
                    }
                    if(cnt == current) {
                        flag = false;
                        break;//일관성 없음.....
                    }
                }
            }
        }

        if(flag){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
