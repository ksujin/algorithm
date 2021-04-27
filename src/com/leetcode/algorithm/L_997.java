package com.leetcode.algorithm;

public class L_997 {
    public static void main(String[] args) {
        int N = 3;
        int[][] trust = {{1,2},{2,3}};
        findJudge(N, trust);
    }

    public static int findJudge(int N, int[][] trust) {
        int answer = -1;
        int believeCount[][] = new int[N + 1][2]; //[[1,2]] 0번째 시민은 1번 믿음을 주고, 2번 믿음을 받는다

        for (int i = 0; i < trust.length; i++) {
            int from = trust[i][0];
            int to = trust[i][1];

            believeCount[from][0]++;
            believeCount[to][1]++;
        }

        for (int i = 1; i <= N; i++) {
            int giveBelieveCount = believeCount[i][0];
            int givenBelieveCount = believeCount[i][1];
            if (giveBelieveCount == 0 && givenBelieveCount == N - 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

}
