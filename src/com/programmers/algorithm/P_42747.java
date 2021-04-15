package com.programmers.algorithm;

public class P_42747 {
    public static void main(String[] args) {
        int ciattions[] = {3, 0, 6, 1, 5};
        solution(ciattions);
    }

    public static int solution(int[] citations) {
        int[] isHigherThan = new int[citations.length+1]; //isHigherThan[0] = 0 -> 0 회 이상 인용된건 0개.
        int[] isLowerThan = new int[citations.length+1]; // isLowerThan[2] = 1 -> 2회 이하 인용된건 1개


        for (int i = 0; i <= citations.length; i++) {
            for (int citation:
                    citations) {
                if (citation >= i) {
                    isHigherThan[i]++;
                } else {
                    isLowerThan[i]++;
                }
            }
        }

        int answer = 0;

        //h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용
        for (int i = citations.length; i >= 0; i--) {
            if (isHigherThan[i] >= i && isLowerThan[i] <  i) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);


        return answer;
    }
}
