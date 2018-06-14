package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1238 {
    //거기까지 가는데 cost 저장
   public static int[] dist;
   public static int[] retDist;
   public static int[][] village;
   public static int[][]  retVillage;
   public static int n, m, destination;
   private final int INF =  Integer.MAX_VALUE;

   public void solve(){
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        destination = scn.nextInt();
        //목적지에서 각 마을까지 가는데 걸리는 cost 저장
        dist = new int[n+1];
        retDist = new int[n+1];

       village = new int[n+1][n+1];
       retVillage = new int[n+1][n+1];

        //그래프 저장

       //INF 할당
       for (int i = 0; i < n+1; i++) {
               dist[i] = INF;
               retDist[i] = INF;
           for (int j = 0; j < n+1; j++) {
               village[i][j] = INF;
               retVillage[i][j] = INF;
           }
       }

       //그래프 모양 만들기
       for (int i = 0; i < m; i++) {
           int start = scn.nextInt();
           int end = scn.nextInt();
           int weight = scn.nextInt();

           village[start][end] = weight;
           retVillage[end][start] = weight;
       }

       dijkstra(destination, dist, village);
       dijkstra(destination, retDist, retVillage);

       int max = -1;

       for (int i = 1; i <= n; i++) {
           int destTovillage = dist[i];
           int villageTodest = retDist[i];
           int result = destTovillage+villageTodest;
           if (result > max){
               max = result;
           }
       }

       System.out.println(max);


   }

   public void dijkstra(int start, int[] dist, int[][] village){
       dist[start] = 0;
       PriorityQueue<Element> pq = new PriorityQueue<>();
       pq.add(new Element(start, 0));

       while(!pq.isEmpty()){
           int here = pq.peek().node;
           int cost = pq.peek().cost;

           pq.poll();

           if (dist[here] < cost) continue;

           for (int i = 1; i < n+1; i++) {
               int weight = village[here][i] ;
               if (weight == INF) continue;

               if (dist[i] > dist[here]+weight){
                   dist[i] = dist[here]+weight;
                   pq.add(new Element(i, dist[i]));
               }
           }
       }
   }

   public static void main(String[] args){
       new B_1238().solve();
   }

   class Element implements Comparable<Element>{
       int node;
       int cost;

       Element(int node, int cost){
           this.cost = cost;
           this.node = node;
       }

       @Override
       public int compareTo(Element o) {
           return this.cost < o.cost ? -1 : 1;
       }
   }
}


