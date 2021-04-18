package com.programmers.algorithm;

public class P_42842 {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        solution(brown, yellow);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= yellow/2 + 1; i++) {
            int yellowRow = i;
            if (yellow % yellowRow != 0){
                continue;
            }
            int yellowColumn = yellow/i;
            int yellowCount = yellowRow*yellowColumn;
            int brownCount = yellowColumn * 2 + yellowRow * 2 + 4;

            if (yellowCount == yellow && brownCount == brown) {
                answer[0] = yellowColumn + 2;
                answer[1] = yellowRow + 2;
                break;
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }
}
