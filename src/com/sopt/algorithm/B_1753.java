package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*public class B_1753 {
    static int v, e, startNode;
    Scanner scn = new Scanner(System.in);

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] dist;
    final static int INF = 5000000;


    void solve() {

        //n = 정점의 개수이자 목적지
        v = scn.nextInt();
        //m = 간선의 개수
        e = scn.nextInt();

        dist = new int[v+1];

        //노드 수만큼 어레이에 어레이 추가
        for (int i = 0; i < v+1; i++) {
            Arrays.fill(dist, INF);
            adj.add(new ArrayList<>());
        }

        startNode = scn.nextInt();

        for (int i = 0; i < e; i++) {
            int from = scn.nextInt();
            int to = scn.nextInt();
            //from 에서 to 로 가는 edge 의  weight
            int weight = scn.nextInt();

            adj.get(from).add(to*11+weight);
        }
       


        //1에서 출발 할때
        dijkstra(startNode);

        for (int i = 1; i < v+1; i++) {
            System.out.println(dist[i] < INF ? dist[i] : "INF");

        }



    }

    public void dijkstra(int first) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>();


        //처음노드에서 처음 노드까지 걸리는 비용
        dist[first] = 0;
        pq.add(new Element(first, 0));

        while (!pq.isEmpty()) {
            //시작점에서 현재까지오는데 필요한 값
            int cost = pq.peek().dist;
            int here = pq.peek().node;

            System.out.println("node "+here+" is peeked! and cost is "+cost);

            pq.poll();

            //예전에 저장된 값이 지금 불러오는 저장된 값보다 작다면 continue;
            //만약 dist[node4]값이
            //node2를 기준으로 잡을때는 cost가 7 이었다가
            //node3을 기준으로 잡을때 cost가 3 이 되었다고 하자
            //pq 이므로 cost가 3일때가 먼저 빠져나올텐데 이때 dist[4] = 3
            //그리고 나중에 cost가 7인 애가 빠져나올텐데 이때 얘의 cost 는 현재 dist[4] 보다 작으므로 continue
            //즉 이 전 노드들에 따라서 cost 가 다른 값으로 pq 에 저장될텐데 이 중 가장 값이 낮은걸 취하겠다는 것
            if (dist[here] < cost) {
                System.out.println("dist[here] is "+dist[here]);
                System.out.println("cost is "+cost );
                continue;
            }



            for (int x : adj.get(here)) {
                int adjNode = x / 11;
                int weight = x % 11;
                if (dist[adjNode] > weight + dist[here]) {
                    dist[adjNode] = weight + dist[here];
                    pq.add(new Element(adjNode, dist[adjNode]));
                    System.out.println("current node is "+here+" and node "+ adjNode+" is added and this value is " + dist[adjNode]);
                }

            }
        }
    }

    public static void main(String[] args) {
        new B_1753().solve();
    }

    class Element implements Comparable<Element>{
        //노드
        int node;
        //어떤 노드에서 u 까지 오는데 edge 의 weight 혹은 시작점에서 u까지 오는데 최단 비용 저장
        int dist;

        Element(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Element o) {
            return this.dist < o.dist ? -1 : 1;

        }
    }
}*/


