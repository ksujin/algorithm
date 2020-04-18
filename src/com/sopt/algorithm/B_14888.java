package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14888 {
    static int[] operands, operatorsCount;
    static int n, maxAns, minAns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        operands = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }
        // + - x /
        operatorsCount = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operatorsCount[i] = Integer.parseInt(st.nextToken());
        }

        maxAns = -100000000;
        minAns = 1000000000;

        //operatorCount for문 돌면서 1 이상 남아있으면 그거 수행함. 그리고 dfs
        solve(1, operatorsCount, operands[0]);
        System.out.println(maxAns + "\n" + minAns);
    }

    static void solve(int operandIdx, int[] opCount, int tempAns) {
        for (int i = 0; i < 4; i++) {
            if(opCount[i] > 0) {
                int cal = 0;
                if (i == 0) {
                    cal = tempAns + operands[operandIdx];
                } else if (i == 1) {
                    cal = tempAns - operands[operandIdx];
                } else if (i == 2) {
                    cal = tempAns * operands[operandIdx];
                } else {
                    cal = tempAns / operands[operandIdx];
                }
                if (operandIdx == n-1) {
                    maxAns = maxAns > cal ? maxAns : cal;
                    minAns = minAns < cal ? minAns : cal;
                    return;
                }
                int nextOpCount[] = opCount.clone();
                nextOpCount[i]--;
                solve(operandIdx+1, nextOpCount, cal);
            }
        }

    }
}
