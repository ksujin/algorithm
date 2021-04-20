package com.programmers.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class P_42583 {
    public static void main(String[] args) {

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        solution(bridge_length, weight, truck_weights);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        int roadWeight = 0;
        int roadMaxWeight = weight;

        Queue<Integer> truckQueue = new LinkedList<>();
        for (int truck :
                truck_weights) {
            truckQueue.add(truck);
        }

        Queue<Integer> roadAvailabelQueue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            roadAvailabelQueue.add(0);
        }

        while (!truckQueue.isEmpty()) {
            time++;

            roadWeight -= roadAvailabelQueue.poll(); //마지막 빼내고

            int truckWeight = truckQueue.peek();
            boolean isAvailableNewTruck = roadWeight + truckWeight <= roadMaxWeight;
            if (isAvailableNewTruck) {
                roadWeight += truckQueue.poll();
            }

            roadAvailabelQueue.add(isAvailableNewTruck ? truckWeight : 0);
        }

        //time 은 마지막 truck이 다리에 진입했을때 시간이므로 다 건너려면 bridge 길이만큼 시간 더 필요
        int answer = time + bridge_length;
        System.out.println(answer);
        return answer;
    }
}
