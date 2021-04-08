package com.programmers.algorithm;


import java.util.ArrayList;
import java.util.Arrays;

public class P_42840 {

    public static void main(String[] args) {
        int answers[] = {1,3,2,4,2};
        solution(answers);
    }

    public static int[] solution(int[] answers) {

        //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        //2번 수포자가 찍는 방식: 2, 1(1), 2, 3(3), 2, 4(5), 2, 5(7), 2, 1(9), 2, 3, 2, 4, 2, 5, ...
        //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        int firstCorrectCount = 0;
        int secondCorrectCount = 0;
        int thridCorrectCount = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            //첫번째 수포자
            int firstPersonAnswer = (i % 5) + 1;
            if (answer == firstPersonAnswer) {
                firstCorrectCount++;
            }

            //두번째 수포자
            int secondPersonAnswer = 0;
            int secondIndex = i % 8;
            switch (secondIndex) {
                case 0:
                case 2:
                case 4:
                case 6:
                    secondPersonAnswer = 2;
                    break;
                case 1:
                    secondPersonAnswer = 1;
                    break;
                case 3:
                    secondPersonAnswer = 3;
                    break;
                case 5:
                    secondPersonAnswer = 4;
                    break;
                case 7:
                    secondPersonAnswer = 5;
                    break;
            }

            if (answer == secondPersonAnswer) {
                secondCorrectCount++;
            }


            //세번째 수포자
            int thirdPersonAnswer = 0;

            int thirdIndex = i % 10;
            switch (thirdIndex) {
                case 0:
                case 1:
                    thirdPersonAnswer = 3;
                    break;
                case 2:
                case 3:
                    thirdPersonAnswer = 1;
                    break;
                case 4:
                case 5:
                    thirdPersonAnswer = 2;
                    break;
                case 6:
                case 7:
                    thirdPersonAnswer = 4;
                    break;
                case 8:
                case 9:
                    thirdPersonAnswer = 5;
                    break;
            }

            if (answer == thirdPersonAnswer) {
                thridCorrectCount++;
            }
        }

        int[] answerCounts = {firstCorrectCount, secondCorrectCount, thridCorrectCount};
        int maxCorrectCount = Arrays.stream(answerCounts).max().getAsInt();

        ArrayList<Integer> answerList = new ArrayList();
        for (int i = 1; i <= answerCounts.length ; i++) {
            int correctCount = answerCounts[i-1];
            if (correctCount == maxCorrectCount) {
                answerList.add(i);
            }
        }

        int maxCorrectPeople = answerList.size();
        int[] answer = new int[maxCorrectPeople];

        for (int i = 0; i < maxCorrectPeople; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
