package com.programmers.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class P_43164 {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
  //              {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
                // {"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}
        };
        solution(tickets);
    }

    static String[] answer;
    static boolean isEmpty = true;

    public static String[] solution(String[][] tickets) {

        answer = new String[tickets.length + 1];
        HashMap<String, ArrayList<String>> ticketMap = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            String departure = tickets[i][0];
            String arrival = tickets[i][1];

            if (ticketMap.containsKey(departure)) {
                ticketMap.get(departure).add(arrival);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(arrival);
                ticketMap.put(departure, list);
            }
        }


        String[] possibleAnswer = new String[tickets.length + 1];
        String departurePoint = "ICN";
        possibleAnswer[0] = departurePoint;
        travel(departurePoint, ticketMap, 1 , possibleAnswer);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " - ");
        }

        return answer;
    }



    static void travel(String departurePoint, HashMap<String, ArrayList<String>> ticketMap, int depth, String possibleAnswer[]) {
        if (depth == possibleAnswer.length) {


            //ICN - SFO - ATL - ICN - ATL - SFO
            //ICN - ATL - ICN - SFO - ATL - SFO
            //ICN - ATL - SFO - ATL - ICN - SFO
            if (isEmpty) {
                answer = Arrays.copyOf(possibleAnswer, possibleAnswer.length);
                isEmpty = false;
                return;
            }


            for (int i = 0; i < possibleAnswer.length; i++) {
                if (possibleAnswer[i].compareTo(answer[i]) > 0) {
                    break;
                } else if (possibleAnswer[i].compareTo(answer[i]) < 0) {
                    //System.out.println("현재의 " + i +" 번째 인덱스에 있는 "+ real[i] + " 가 " + answer[i] + "보다 큽니다");
                    answer = Arrays.copyOf(possibleAnswer, possibleAnswer.length);
                    break;
                }
            }
            return;
        }


        //중간에 끊기는 경우가 있으면 안되니까 key 값 체크해줘야한다!! - https://deok2kim.tistory.com/118
        if (!ticketMap.containsKey(departurePoint)) {
            return;
        }

        ArrayList<String> nextArrivals = ticketMap.get(departurePoint);
        int nextArrivalSize = nextArrivals.size();

        for (int i = 0; i < nextArrivalSize; i++) {
            String nextArrival = ticketMap.get(departurePoint).remove(i);
            possibleAnswer[depth] = nextArrival;
            travel(nextArrival, ticketMap, depth+1, possibleAnswer);
            ticketMap.get(departurePoint).add(i, nextArrival);
        }
    }
}
