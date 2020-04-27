package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B_14889 {
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.valueOf(st.nextToken());
                arr[i][j] = val;
            }
        }


        doComb(0, n/2);
        System.out.println(min);
    }

    static void doComb(int start, int r) {
        if(r == 0) {
            min = Math.min(min, getDiff());
            return;
        }

        for (int i = start; i < n ; i++) {
                visited[i] = true;
                doComb(i+1, r-1);
                visited[i] = false;
        }

    }

    static int getDiff() {
        int sumStart = 0;
        int sumLink = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    sumStart += (arr[i][j]);
                    sumStart += (arr[j][i]);
                    //System.out.println(i +"와"+j+"가 결합: " +arr[i][j] +"+"+arr[j][i]+"="+(arr[j][i]+arr[i][j]));
                } else if (!visited[i] && !visited[j]) {
                    sumLink += (arr[i][j]);
                    sumLink += (arr[j][i]);
                }

            }
        }

        return Math.abs(sumLink - sumStart);
    }
}
