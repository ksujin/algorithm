package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_14501 {
    static int appointment[][];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        appointment = new int[n][2];
        int maxPay[] = new int[n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.valueOf(st.nextToken());
            int pay = Integer.valueOf(st.nextToken());
            appointment[i][0] = day;
            appointment[i][1] = pay;
        }

        for (int i = 0; i < n; i++) {
            //dfs
            //dfs(i, n, 0);
        }

        System.out.println(max);
    }
    static void dfs(int current, int n, int total) {
        //System.out.println(current + "일자에 진입!");
        int day = appointment[current][0];
        int pay = appointment[current][1];

        if (current + day >= n) {
            //System.out.println("리턴~");
            if (current + day == n) {
                total += pay;
            }
            max = max > total ? max : total;
            return;
        }

        total += pay;
        //System.out.println(pay);

        for (int i = current+day; i < n; i++) {
            //dfs i
            if (i < n) {
                dfs(i, n, total);
            }
        }
    }
}
