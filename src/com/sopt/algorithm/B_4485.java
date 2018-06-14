package com.sopt.algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_4485 {

    static Scanner scn = new Scanner(System.in);
    public static final int INF = 160000;
    static int[] dx = {0,-1,1,0}, dy={1,0,0,-1};
    static int[][] maze;
    static int[][] dist;
    static int n;

    public void solve(int n, int times){
        maze = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scn.nextInt();
                dist[i][j] = INF;
            }
        }

        dijkstra(maze[0][0]);
        System.out.println("Problem "+times+": "+dist[n-1][n-1]);


    }

    public void dijkstra(int first){
        dist[0][0] = maze[0][0];

        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(0,0,maze[0][0]));

        while(!pq.isEmpty()){
            int x = pq.peek().x;
            int y = pq.peek().y;
            int cost = pq.peek().cost;

            pq.poll();

            if (dist[x][y] < cost) continue;

            for (int i = 0; i < 4; i++) {
                int ax = x+dx[i];
                int ay = y+dy[i];
                //System.out.println("("+ax+","+ay+")");
                //System.out.println(isInRange(ax,ay));

                if(isInRange(ax,ay) && dist[ax][ay] > dist[x][y]+maze[ax][ay]){

                    dist[ax][ay] = dist[x][y]+maze[ax][ay];
                   // System.out.println("("+ax+","+ay+")"+"에서 값은"+dist[ax][ay]);
                    pq.add(new Element(ax, ay, dist[ax][ay]));
                }
            }
        }

    }

    public boolean isInRange(int x, int y){
        return (0<=x && x<n)&&(0<=y && y<n);
    }

    public static void main(String[] args){
        int times = 1;
        while(true){
            n = scn.nextInt();
            if (n==0) break;
            new B_4485().solve(n, times);
            times++;
        };
    }

    class Element implements Comparable<Element>{
        int x;
        int y;
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
