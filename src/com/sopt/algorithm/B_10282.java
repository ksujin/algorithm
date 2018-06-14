package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_10282 {
    static Scanner scn = new Scanner(System.in);
    public static ArrayList<ArrayList<Integer>> network ;
    public static int n;
    public static int[] dist;
    public final static int INF = Integer.MAX_VALUE;

    public void solve(){

        n = scn.nextInt();
        int d = scn.nextInt();
        int hackedComputer = scn.nextInt();
        dist = new int[n+1];
        network = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            dist[i] = INF;
            network.add(new ArrayList<>());

        }

        for (int i = 0; i < d; i++) {

            int to = scn.nextInt();
            int from = scn.nextInt();
            int weight = scn.nextInt();

            network.get(from).add(to*11 + weight);
        }



        dijkstra(hackedComputer);

        //총 감염되는 컴퓨터 수
        int contaminatedCount = 0;
        int max = -1;
        for (int i = 0; i < n+1 ; i++) {
            if (dist[i] == INF) continue;
            contaminatedCount++;
            if (max < dist[i]){
                max = dist[i];
            }
        }
        System.out.print(contaminatedCount+" "+max);


    }

    public static void main(String[] args){
        int testCast = scn.nextInt();
        for (int i = 0; i < testCast; i++) {

            new B_10282().solve();
        }

    }


    public void dijkstra(int start){
        PriorityQueue<Element> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Element(start, 0));

        while(!pq.isEmpty()){
            int here = pq.peek().node;
            int cost = pq.peek().cost;

            pq.poll();

            if (dist[here] < cost) continue;


            for (int i = 0; i < network.get(here).size(); i++) {
                int next = network.get(here).get(i) / 11;
                int weight = network.get(here).get(i) % 11;

                if (dist[next] > dist[here] + weight){
                    dist[next] = dist[here] + weight;
                    pq.add(new Element(next, dist[next]));
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
            return this.cost < o.cost ? -1 : 1;
        }
    }
}
