package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10974 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.valueOf(br.readLine());
        int s[] = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = i+1;
        }

        appendSBValue(s, sb);
        while (next_permutation(s)){
            appendSBValue(s, sb);
            //hasNext = next_permutation(s);
        }
        System.out.println(sb);
    }


    public static boolean next_permutation(int[] s){

        int i = s.length-1;
        while ( i > 0 && s[i-1] >= s[i]){
            i--;
        }
        if(i <= 0) {return false;}

        int j = s.length-1;
        while (s[i-1]>=s[j]){
            j--;
        }

        int temp = s[i-1];
        s[i-1] = s[j];
        s[j] = temp;

        j = s.length-1;
        while (i<j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void appendSBValue(int[] s, StringBuilder sb) {
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]+" ");
        }
        sb.append("\n");
    }

}
