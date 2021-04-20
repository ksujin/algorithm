package com.programmers.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Work {
    int progress;
    int speed;

    Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}

public class P_42586 {
    public static void main(String[] args) {
        int[] progresses = //{93, 30, 55};
         {95, 90, 99, 99, 80, 99};
        int[] speeds = //{1, 30, 5};
                 {1, 1, 1, 1, 1, 1};
        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        int time = 0;
        ArrayList<Integer> answerList = new ArrayList<>();

        Queue<Work> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Work(progresses[i], speeds[i]));
        }


        while (!queue.isEmpty()) {
            time++;
            int polledItemCount = pollIfPossible(queue, time);
            if (polledItemCount != 0) {
                answerList.add(polledItemCount);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;

    }

    static int pollIfPossible(Queue<Work> queue, int time) {
        int polledItemCount = 0;

        while (!queue.isEmpty()) {
            Work work = queue.peek();
            if (work.progress + work.speed * time < 100) {
                break;
            }

            queue.poll();
            polledItemCount++;
        }

        return polledItemCount;
    }
}
