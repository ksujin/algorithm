package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_2014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long prime[] = new long[k];
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            prime[i] = Integer.valueOf(st.nextToken());
            pq.add(prime[i]);
        }

        long head = 0;

        for (int i = 0; i < n; i++) {
            // n번째 뺀 값이 n번째 수가 된다.
            head = pq.poll();

            for (int j = 0; j < k; j++) {
                //queue에서 제일 작은 것 * 기존에 제공된 소수 한바퀴 곱함.
                long value = head * prime[j];
                pq.add(value);

                //중복 제거 작업
                if (head % prime[j] == 0) break;
            }

        }
        System.out.println(head);
    }
}
