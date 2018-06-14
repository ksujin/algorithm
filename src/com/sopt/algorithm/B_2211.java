package com.sopt.algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_2211 {
    static Scanner scn = new Scanner(System.in);
    public int[][] network;
    public int n;
    public boolean[][] visited;
    public int[] dist;
    public int[] prev;
    public final static int INF = 10001;

    public void solve(){
        n = scn.nextInt();
        int m = scn.nextInt();
        network = new int[n+10][n+10];

        visited = new boolean[n+10][n+10];
        dist = new int[n+10];
        prev = new int[n+10];

        for (int i = 0; i < n+1; i++) {
            dist[i] = INF;
        }
        for (int i = 0; i < m; i++) {
            int from = scn.nextInt();
            int to = scn.nextInt();
            int weight = scn.nextInt();

            network[from][to] = weight;
            network[to][from] = weight;
        }

        dijkstra(1);

        for (int i = 2; i <= n ; i++) {
            findPrev(i);
        }

        int resultCount = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                if(visited[i][j]){
                    resultCount++;
                }
            }
        }
        System.out.println(resultCount);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                if(visited[i][j]){
                    System.out.println(i+" "+j);
                }
            }
        }


    }

    public static void main(String[] args){
        new B_2211().solve();
    }

    public void findPrev(int end){
        if (end == 1) return;
        int tempEnd = end;
        int tempPrev = prev[tempEnd];

//        if (!visited[tempPrev][tempEnd]){
//            System.out.println(tempEnd +" "+tempPrev);
//        }
        //한개만 true 로 나중에 출력할때 위해서
        visited[tempPrev][tempEnd] = true;

        findPrev(tempPrev);

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

            for (int i = 0; i <= n; i++) {
                //길 없는 것
                if (network[here][i] == 0) continue;
                if (dist[i] > dist[here] + network[here][i]){

                    dist[i] = dist[here] + network[here][i];
                    //System.out.println(here+"과 " +i+"의 거리는 " +dist[i]);
                    prev[i] = here;
                    pq.add(new Element(i, dist[i]));
                }
            }


        }

    }

    class Element implements  Comparable<Element>{
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
