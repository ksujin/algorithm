package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11729 {
    static StringBuilder sb = new StringBuilder();
    static int totalCount = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1,2,3);
        System.out.println(totalCount);
        System.out.println(sb);
    }

    //참고 : https://hyeonstorage.tistory.com/355

    //1. 기둥 1에서 n-1개의 원반을 기둥 2으로 옮긴다
    //2. 기둥 1에서 1개의 원반을 기둥 3으로 옮긴다
    //3. 기둥 2에서 n-1개의 원반을 기둥 3으로 옮긴다

    static void hanoi(int n, int from, int by, int to){
        if (n == 1){
            move(from,to);
        } else {
            hanoi(n-1, from, to, by);
            move(from, to);
            hanoi(n-1, by, from, to);
        }
    }

    static void move(int from, int to ){
        sb.append(from+" "+to+"\n");
        totalCount++;
    }
}
