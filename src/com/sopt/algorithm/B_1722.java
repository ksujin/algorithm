package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1722 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String[] secondLine = br.readLine().split(" ");

        //1이면 그 다음 k 받아서 {1...n} 까지의 순열 중 k 번째 순열 출력
        //2이면 n만큼 숫자 받아서 {1...n} 까지의 순열 중 몇번째인지 출력
        int problemType = Integer.valueOf(secondLine[0]);
        if (problemType == 1) {
            int s[] = new int[n];
            StringBuilder sb = new StringBuilder();

            //초기값 설정 ex) 1,2,3,4
            for (int i = 0; i <n ; i++) {
                s[i] = i+1;
            }

            long k = Long.valueOf(secondLine[1]);

            //k번째 순열 구함
            long used = 0;
            for (int i = 0; i < n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if((used & (1<<j)) != 0){
                        continue;
                    }

                    long factorial = factorial(n-1-i);
                    if(k > factorial){
                        k -= factorial;
                        continue;
                    } else {
                        s[i] = j;
                        used = used|(1<<j);
                        break;
                    }
                }
            }

            //순열 출력
            for (int i = 0; i < n; i++) {
                sb.append(s[i]+" ");
            }
            System.out.println(sb);
        } else {
            int s1[] = new int[n];
            //입력받은 순열
            for (int i = 0; i < n; i++) {
                s1[i] = Integer.valueOf(secondLine[i+1]);
            }
            //몇번째 순열인지 출력
            long ans = 1;

            for (int i = 0; i < n; i++) {
                long usedCount = 0;
                for (int j = 0; j < i; j++) {
                    if(s1[j] < s1[i]) {usedCount++;}
                }
                long restValue = s1[i]-1-usedCount;
                ans += restValue*factorial(n-i-1);
            }

            System.out.println(ans);
        }
    }

    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}
