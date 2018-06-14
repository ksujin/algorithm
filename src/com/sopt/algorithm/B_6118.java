package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_6118 {

    static int n, m, INF;
    static ArrayList<ArrayList<Integer>> path;
    static int dist[];
    public void solve(){

        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        path = new ArrayList<>();
        dist = new int[n+1];
        INF = Integer.MAX_VALUE;

        for (int i = 0; i < n+1 ; i++) {
            dist[i] = INF;
            path.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            path.get(a).add(b);
            path.get(b).add(a);

        }



        dijkstra(1);

        int maxVal = 0;
        for (int i = 0; i < n + 1; i++) {
            if (dist[i] == INF) continue;
            if (dist[i] > maxVal){
                maxVal = dist[i];
            }
        }

        for (int i = 0; i < n+1; i++) {
            if (dist[i] == maxVal){
                System.out.print(i + " ");
                System.out.print(dist[i]+ " ");
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < n+1; i++) {

            if (dist[i] == maxVal){
                count ++;
            }

        }
        System.out.println(count);


    }

    public static void dijkstra(int start){
        dist[start] = 0;
        PriorityQueue<Element> pq = new PriorityQueue();
        pq.add(new Element(1, 0));

        while(!pq.isEmpty()){
            int here = pq.peek().x;
            //현재까지의 거리
            int cost = pq.peek().cost;
            pq.poll();

            if (cost > dist[here]) continue;

            for (int i = 0; i < path.get(here).size(); i++) {
                int next = path.get(here).get(i);
                if (dist[here] + 1 < dist[next]){
                    dist[next] = dist[here] + 1;
                    pq.add(new Element(next, dist[next]));
                }
            }

        }

    }




    public static void main(String args[]){
        new B_6118().solve();
    }

}

class Element implements Comparable<Element>{
    int x;
    int cost;

    Element(int x, int cost){
        this.x = x;
        this.cost = cost;
    }

    @Override
    public int compareTo(Element o) {
        return this.cost < o.cost ? -1:1;
    }
}


