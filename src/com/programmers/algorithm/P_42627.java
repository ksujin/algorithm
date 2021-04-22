package com.programmers.algorithm;

import java.util.*;

//https://codevang.tistory.com/316
public class P_42627 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        solution(jobs);
    }

    public static int solution(int[][] jobs) {
        //들어온 순서대로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        //걸리는 시간이 짧은대로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int time = 0;
        int jobIndex = 0; //시간에 따라 처리를 기다리는 queue (pq)에 어디까지 들어갔나 판단하는 index
        int dealCount = 0; //처리량
        int answer = 0;

        //처리량이 들어온 job의 길이와 같을때까지 루프를 돈다
        while (dealCount != jobs.length) {

            //완료 시간까지 들어온 job들을 넣음
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                pq.offer(jobs[jobIndex++]);
            }

            //job이 다 처리되지 않았는데 pq 가 비어있는거라면 다음 job 을 바로 끌어와서 time 을 맞춰준다. (대박적..)
            if (pq.isEmpty()) {
                time = jobs[jobIndex][0];
            } else {
                //한개씩 처리
                int temp[] = pq.poll();
                int enterTime = temp[0];
                int handleTime = temp[1];
                answer += handleTime + time - enterTime;
                time += handleTime;
                dealCount++;
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}
