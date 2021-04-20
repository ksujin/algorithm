package com.programmers.algorithm;

import java.util.PriorityQueue;

public class P_42626 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        solution(scoville, K);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int oneScoville:
                scoville) {
            pq.offer(oneScoville);
        }


        while (pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }

            answer++;
            int min = pq.poll();
            int secondMin = pq.poll();

            int newScoville = min + secondMin * 2;
            pq.offer(newScoville);
        }


        System.out.println(answer);

        return answer;
    }
}
