package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10819 {
    static int max=0;
    static int count;
    static int N, ans; //크기


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine());
        int[] val = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i){
            val[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print("\n");

        f(val, 0);
        System.out.println(ans);

    }

    static void f(int arr[], int d){

        if(d == N-1){

            int temp = 0;

            for (int i = 0; i < N-1; i++) {
              temp += Math.abs(arr[i]-arr[i+1]);
            }
            ans = ans > temp ? ans : temp;

            //System.out.println(max);
            return;
        }

        for (int i = d; i < N; i++) {
            swap(arr, d, i);
            f(arr, d+1);
            swap(arr, d, i);
        }
    }

    static void swap(int arr[], int d, int i){
        int temp = arr[d];
        arr[d] = arr[i];
        arr[i] = temp;
    }



}
