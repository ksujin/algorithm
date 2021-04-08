package com.programmers.algorithm;

import java.util.Arrays;

public class P_42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int commandsCount = commands.length;
        int[] answer = new int[commandsCount];

        for (int i = 0; i < commandsCount; i++) {
            int[] command = commands[i];
            int startIndex = command[0];
            int endIndex = command[1];
            int resultIndex = command[2]-1;

            int[] partialArray = new int[endIndex-startIndex+1];

            for (int j = startIndex; j <= endIndex; j++) {
                partialArray[j-startIndex] = array[j-1];
            }

            Arrays.sort(partialArray);

            answer[i] = partialArray[resultIndex];
        }
        return answer;
    }
}
