package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int classMap[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            classMap[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        //한 시험장에서 감시할 수 있는 수
        int superCount = Integer.valueOf(st.nextToken());
        int viceCount = Integer.valueOf(st.nextToken());

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int classCount = classMap[i];
            ans++;
            classCount -= superCount;
            if (classCount > 0) {
                ans += classCount / viceCount;
                if (classCount % viceCount != 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
