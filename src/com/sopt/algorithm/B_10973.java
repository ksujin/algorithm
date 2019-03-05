package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10973 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int s[] = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.valueOf(values[i]);
        }

        if (previous_permutation(s)){
            for (int i = 0; i < n; i++) {
                System.out.print(s[i]+" ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean previous_permutation(int[] s){
        int n = s.length;
        int i = n-1;

        //1. s[i-1] > s[i] 를 만족하는 것중 가장 큰 i를 찾는다
        while (i > 0 && s[i-1] <= s[i]){
            i--;
        }
        if (i <= 0){
            return false;
        }

        //2. i<=j 중 s[i-1] > s[j] 만족하는 것 중 가장 큰 j를 찾는다

        int j = n-1;
        while (s[i-1] <= s[j]){
            j--;
        }

        //3. s[i-1]과 s[j] swap!
        int temp = s[i-1];
        s[i-1] = s[j];
        s[j] = temp;

        //4. i 뒤부터 모두 swap
        j = n-1;
        while (i < j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
