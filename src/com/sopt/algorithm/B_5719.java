package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_5719 {
    static int n, m, start, end;
    static int path[][];
    static int dist[];
    ArrayList<ArrayList<Integer>> prev;

    private static final int INF = Integer.MAX_VALUE;
    static Scanner scn = new Scanner(System.in);

    public void solve(int n, int m){
        start = scn.nextInt();
        end = scn.nextInt();

        path = new int[n][n];
        dist = new int[n];
        prev = new ArrayList<>();



        //입력받기
        for (int i = 0; i < m ; i++) {
            int from = scn.nextInt();
            int to = scn.nextInt();
            int weight = scn.nextInt();

            path[from][to] = weight;
        }

        //초기화

        for (int i = 0; i < n; i++) {
           dist[i] = INF;
           prev.add(new ArrayList());
        }

        dijkstra(start);

      //최적 경로 찾은 후 그 길들 없앰
        deleteOpt(end);

        //다시 최적 경로 돌림
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
        }

        dijkstra(start);

        System.out.println(dist[end] == INF ? "-1" : dist[end]);

    }

    public void deleteOpt(int end){
        if (end == start) return;
        for (int i = 0; i < prev.get(end).size(); i++) {
            int tempPrev = prev.get(end).get(i);
         //   System.out.println("현재의 종점은 "+end+"이고 그 전 노드는" + tempPrev);
            path[tempPrev][end] = 0;
            deleteOpt(tempPrev);
        }
    }

    public void dijkstra(int start){
        dist[start] = 0;
        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(start,0));

        while(!pq.isEmpty()){

            int here = pq.peek().node;
            int cost = pq.peek().cost;

            pq.poll();

            if (dist[here] < cost) continue;

            for (int i = 0; i < n; i++) {
                int hereTonext = path[here][i];
               // System.out.println(here+"에서 "+i+"로 가는 값은 "+hereTonext);
                //길이 없는 경우
                if (hereTonext == 0) continue;
                //다음거에 저장되있는게 현재까지 + 현재-다음보다 크다면
                if(dist[i] > hereTonext + dist[here]){
                    dist[i] = hereTonext + dist[here];
//                    if(i==6 && here == 2){
//
//                        System.out.println("dist[6] = " +dist[i]+", hereTonext = "+hereTonext +" dist[here] : "+dist[here]);
//                    }

                    //현재거는 추가하고 예전거는 지운다
                    prev.get(i).clear();
                    prev.get(i).add(here);
                    pq.add(new Element(i, dist[i]));
                } else if (dist[i] == hereTonext + dist[here]){
                    dist[i] = hereTonext + dist[here];
                    prev.get(i).add(here);
                }
            }
        }


    }



    class Element implements Comparable<Element>{
        int node;
        int cost;

        Element(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Element o) {
            return this.cost < o.cost ? -1:1;
        }
    }

    public static void main(String[] args){

        while (true){
            n = scn.nextInt();
            m = scn.nextInt();

            if (n == 0 && m == 0) break;
            new B_5719().solve(n, m);
        }




    }
}
