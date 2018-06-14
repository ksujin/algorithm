package com.sopt.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1261 {
    Scanner scn = new Scanner(System.in);

    static int[][] map;
    public static final int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
    public static int[][] dist;
    public final static int INF = 100000;
    public static int column;
    public static int row;


    public void solve(){

         column = scn.nextInt();
         row = scn.nextInt();
        map = new int[row][column];
        dist = new int[row][column];

        for (int i = 0; i < row; i++) {
            String tempString = scn.next();

            for (int j = 0; j < column; j++) {
                char temp = tempString.charAt(j);
                map[i][j] = Integer.parseInt(String.valueOf(temp));
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dist[i][j] = INF;
            }
        }


        dijkstra(map[0][0]);

        System.out.println(dist[row-1][column-1]);


    }

    public void dijkstra(int start){
        //첫번째 값 초기화
        dist[0][0] = 0;
        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(0,0,0));

        while(!pq.isEmpty()){
            //현재까지 걸리는 cost
            int cost = pq.peek().cost;
            int x = pq.peek().x;
            int y = pq.peek().y;

            pq.poll();

            if (cost > dist[x][y]) continue;

            for (int i = 0; i < 4 ; i++) {
                //상하 좌우 이동
                int ax = x+dx[i];
                int ay = y+dy[i];
                //ax와 ay 가 range 안에 있나 체크

                if (isInRange(ax,ay) && dist[ax][ay] > dist[x][y]+map[ax][ay]){
                    dist[ax][ay] = dist[x][y]+map[ax][ay];
                    pq.offer(new Element(ax, ay, dist[ax][ay]));
                }
            }

        }


    }

    public static boolean isInRange(int x, int y){
        return (0 <= x && x < row) && (0 <= y && y < column);

    }
    public static void main(String[] args){
        new B_1261().solve();

    }

    class Element implements Comparable<Element>{
        int x;
        int y;
        //여기까지 오는데 걸리는 시간
        int cost;
        Element(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public int compareTo(Element o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }

}
