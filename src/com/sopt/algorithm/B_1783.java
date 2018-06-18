package com.sopt.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1783 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        if (n == 1) {
            System.out.println(1);
        } else if(n==2){
            System.out.println(Math.min(4, (m+1)/2));
        } else if ( m < 7){
            System.out.println(Math.min(4, m));
        } else {
            System.out.println(m-2);
        }

    }
}
